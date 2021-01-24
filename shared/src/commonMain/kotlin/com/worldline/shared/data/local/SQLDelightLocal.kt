package com.worldline.shared.data.local

import com.worldline.shared.domain.Either
import com.worldline.shared.domain.Result
import com.worldline.shared.domain.model.Poi

class SQLDelightLocal : Local {
    override fun hasPois(): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getPoiList(): Either<Result.Error, List<Poi>> {
        TODO("Not yet implemented")
    }

    override suspend fun savePois(poiList: List<Poi>): Either<Result.Error, Result.Success> {
        TODO("Not yet implemented")
    }
}