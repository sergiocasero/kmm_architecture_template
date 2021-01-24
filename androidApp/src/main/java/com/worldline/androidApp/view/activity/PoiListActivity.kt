package com.worldline.androidApp.view.activity

import com.worldline.androidApp.R
import com.worldline.shared.data.local.SQLDelightLocal
import com.worldline.shared.data.remote.KtorRemote
import com.worldline.shared.data.repository.CommonPoiRepository
import com.worldline.shared.domain.model.Poi
import com.worldline.shared.ui.executor.Executor
import com.worldline.shared.ui.presenter.PoiListPresenter
import com.worldline.shared.ui.presenter.PoiListView

class PoiListActivity : RootActivity<PoiListView>(), PoiListView {

    override val presenter by lazy {
        PoiListPresenter(
            repository = CommonPoiRepository(local = SQLDelightLocal(), remote = KtorRemote()),
            executor = Executor(),
            view = this
        )
    }

    override val layoutId: Int = R.layout.activity_poi_list

    override fun initializeUI() {
        // Nothing to do
    }

    override fun registerListeners() {
        // Nothing to do
    }

    override fun showPoiList(poiList: List<Poi>) {
        println(poiList)
    }
}