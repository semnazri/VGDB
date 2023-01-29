package com.semnazri.vgdb.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.DisplayMetrics
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.tabs.TabLayout
import kotlin.math.roundToInt

inline fun <T> LifecycleOwner.subscribeState(
    liveData: LiveData<StateWrapper<T>>,
    crossinline onEventUnhandled: (T) -> Unit
) {
    liveData.observe(this) {
        it?.getEventIfNotHandled()?.let(onEventUnhandled)
    }
}

inline fun <reified T : AppCompatActivity> Activity.startActivity(
    vararg params: Pair<String, *> = arrayOf(),
    actionIntent: Intent.() -> Unit = {}
) {
    val intent = IntentHelper.createIntent(this, T::class.java, params).apply(actionIntent)
    startActivity(intent)
}

fun RecyclerView.onScrolledToLastChild(scrolledToLastChild: () -> Unit) {

    addOnScrollListener(object : RecyclerView.OnScrollListener() {

        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            val itemCount = recyclerView.adapter?.itemCount ?: 0
            val layoutManager = recyclerView.layoutManager as LinearLayoutManager
            val lastItemPosition = layoutManager.findLastCompletelyVisibleItemPosition().plus(1)
            if (dy > 0 && lastItemPosition == itemCount) {
                scrolledToLastChild.invoke()
            }
        }
    })
}

fun Context.convertDpToPx(dp: Int): Int {
    val displayMetrics: DisplayMetrics = resources.displayMetrics
    return dp.times(displayMetrics.xdpi.div(DisplayMetrics.DENSITY_DEFAULT)).roundToInt()
}

fun View.gone() {
    this.visibility = View.GONE
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun ShapeableImageView.loadImageShape(url: String) {
    Glide.with(context).load(url).into(this)
}

fun AppCompatImageView.loadImage(url: String) {
    Glide.with(context).load(url).into(this)
}