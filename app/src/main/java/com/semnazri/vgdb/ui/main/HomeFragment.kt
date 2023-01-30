package com.semnazri.vgdb.ui.main

import android.content.Intent
import android.view.KeyEvent
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.semnazri.vgdb.R
import com.semnazri.vgdb.base.BaseFragment
import com.semnazri.vgdb.ui.detail.DetailGameACtivity
import com.semnazri.vgdb.util.*
import kotlinx.android.synthetic.main.fragment_content.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment() {
    private val viewModel by viewModel<GameViewModel>()
    private val gameAdapter by lazy {
        ListGameAdapter {
            val intent = Intent(requireActivity(), DetailGameACtivity::class.java)
            intent.putExtra(AppConstant.GAME_KEYWORD, it.id!!)
            startActivity(intent)
        }
    }

    override fun getLayoutRes(): Int = R.layout.fragment_content

    override fun initPage() {
        viewModel.callEvent(GameViewModel.Event.LoadGameBySearch(""))

        rv_content.apply {
            setHasFixedSize(false)
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
            adapter = gameAdapter
            addItemDecoration(SpacerDecorator(context.convertDpToPx(8)))
            onScrolledToLastChild {
                viewModel.callEvent(GameViewModel.Event.LoadGameBySearchMore)
            }
        }
        text_edit_text.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                viewModel.callEvent(GameViewModel.Event.LoadGameBySearch(text_edit_text.text.toString()))
                return@OnKeyListener true
            }
            false
        })
    }

    override fun subscribeState() {
        subscribeState(viewModel.state) {
            when (it) {
                is GameViewModel.State.ShowError -> Snackbar.make(
                    parent, "Oops, somethings wrong", Snackbar.LENGTH_LONG
                ).show()
                is GameViewModel.State.ShowGame -> {
                    gameAdapter.items.clear()
                    gameAdapter.items =
                        it.gameList.toMutableList()
                }
                is GameViewModel.State.ShowGameMore -> gameAdapter.addItems(it.gameList)
            }
        }
    }
}
