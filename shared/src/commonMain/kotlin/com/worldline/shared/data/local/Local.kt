package com.worldline.shared.data.local

import com.worldline.shared.domain.Either
import com.worldline.shared.domain.Result
import com.worldline.shared.domain.model.Poi

interface Local {
    fun hasPois(): Boolean
    suspend fun getPoiList(): Either<Result.Error, List<Poi>>
    suspend fun savePois(poiList: List<Poi>): Either<Result.Error, Result.Success>
}