package com.worldline.androidApp.view.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.worldline.androidApp.R
import com.worldline.shared.ui.presenter.Presenter
import com.worldline.shared.ui.presenter.View as PresenterView

abstract class RootActivity<out V : PresenterView> : AppCompatActivity(), PresenterView {

    abstract val presenter: Presenter<V>

    abstract val layoutId: Int

    private val progress: View by lazy { findViewById(R.id.layoutProgress) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(layoutId)

        initializeUI()
        registerListeners()

        presenter.attach()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detach()
    }

    abstract fun initializeUI()

    abstract fun registerListeners()

    override fun showProgress() {
        progress.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress.visibility = View.GONE
    }

}