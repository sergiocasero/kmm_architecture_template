package com.worldline.shared.data.local

import com.squareup.sqldelight.db.SqlDriver
import com.worldline.shared.PoiVo
import com.worldline.shared.domain.Either
import com.worldline.shared.domain.Result
import com.worldline.shared.domain.model.Poi
import com.worldline.shared.pois
import com.worldline.shared.withEither

expect class DbDriver {
    fun get(): SqlDriver
}

class SQLDelightLocal(driver: DbDriver) : Local {

    private val db by lazy { pois(driver.get()) }

    override fun hasPois(): Boolean = db.poiQueries.selectAll().executeAsList().isNotEmpty()

    override suspend fun getPoiList(): Either<Result.Error, List<Poi>> = withEither {
        db.poiQueries.selectAll().executeAsList().map { it.toModel() }
    }

    override suspend fun savePois(poiList: List<Poi>): Either<Result.Error, Result.Success> =
        withEither {
            db.poiQueries.transaction {
                poiList.forEach { db.poiQueries.addOrUpdate(it.toVo()) }
            }

            Result.Success
        }
}

fun Poi.toVo() = PoiVo(id, title, latitude, longitude)
fun PoiVo.toModel() = Poi(id ?: "", title ?: "", latitude ?: 0.0, longitude ?: 0.0)