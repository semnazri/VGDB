package com.semnazri.vgdb.ui.detail

import android.text.Html
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.semnazri.vgdb.R
import com.semnazri.vgdb.base.BaseActivity
import com.semnazri.vgdb.util.AppConstant
import com.semnazri.vgdb.util.subscribeState
import kotlinx.android.synthetic.main.activity_content_detail.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailGameACtivity : BaseActivity() {
    private val viewModel by viewModel<DetailGameViewModel>()
    override fun getLayoutResource(): Int = R.layout.activity_content_detail

//    private val gameId by lazy {
//        intent?.getIntExtra(AppConstant.GAME_KEYWORD, 0) ?: 0
//    }

    override fun initPage() {
        val gameId = intent?.getIntExtra(AppConstant.GAME_KEYWORD, 0) ?: 0
        viewModel.callEvent(DetailGameViewModel.Event.LoadGameById(gameId = gameId))
    }

    override fun observeData() {
        subscribeState(viewModel.state) {
            when (it) {
                is DetailGameViewModel.State.ShowDetailGame -> {
                    Glide.with(this).load(it.gameData.backgroundImage).into(img_content)
                    txt_publisher.text = it.gameData.publishers?.get(0)?.name ?: ""
                    txt_game_title.text = it.gameData.name
                    txt_release_date.text =
                        resources.getString(R.string.releaseDate, it.gameData.released)
                    txt_game_rating.text = it.gameData.rating.toString()
                    txt_game_played_by.text =
                        it.gameData.playtime.toString() + " " + resources.getString(R.string.playedCount)
                    txt_game_description.text =
                        Html.fromHtml(it.gameData.description, Html.FROM_HTML_MODE_LEGACY)

                }
                is DetailGameViewModel.State.ShowError -> Snackbar.make(
                    coordinator_layout,
                    "Oops, somethings wrong",
                    Snackbar.LENGTH_LONG
                ).show()
            }
        }
    }
}