package com.worldline.shared.data.remote

import com.worldline.shared.domain.Either
import com.worldline.shared.domain.Result
import com.worldline.shared.domain.model.Poi

interface Remote {
   suspend fun getPoiList(): Either<Result.Error, List<Poi>>
}