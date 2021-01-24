package com.worldline.shared.data.repository

import com.worldline.shared.data.local.Local
import com.worldline.shared.data.remote.Remote
import com.worldline.shared.domain.Either
import com.worldline.shared.domain.Result
import com.worldline.shared.domain.model.Poi

class CommonPoiRepository(private val local: Local, private val remote: Remote) : PoiRepository {

    override suspend fun getPoiList(force: Boolean): Either<Result.Error, List<Poi>> {
        val remoteAndSave = remote.getPoiList().flatMap {
            local.savePois(it.success)
            it
        }
        return when (force) {
            true -> remoteAndSave
            false -> when (local.hasPois()) {
                true -> local.getPoiList()
                false -> remoteAndSave
            }
        }
    }
}