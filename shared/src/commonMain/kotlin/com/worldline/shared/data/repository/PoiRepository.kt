package com.worldline.shared.data.repository

import com.worldline.shared.domain.Either
import com.worldline.shared.domain.Result
import com.worldline.shared.domain.model.Poi

interface PoiRepository {
    suspend fun getPoiList(force: Boolean = false): Either<Result.Error, List<Poi>>
}