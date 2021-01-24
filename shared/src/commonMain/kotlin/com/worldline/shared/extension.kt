package com.worldline.shared

import com.worldline.shared.domain.Either
import com.worldline.shared.domain.Result

suspend fun <T> withEither(block: suspend () -> T): Either<Result.Error, T> = try {
    Either.Right(block())
} catch (e: Exception) {
    Either.Left(Result.Error.Default)
}