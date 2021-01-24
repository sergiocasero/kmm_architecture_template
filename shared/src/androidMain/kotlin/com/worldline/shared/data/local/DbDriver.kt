package com.worldline.shared.data.local

import android.content.Context
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import com.worldline.shared.pois

actual class DbDriver(private val context: Context) {
    actual fun get(): SqlDriver = AndroidSqliteDriver(
        schema = pois.Schema,
        context = context,
        name = "db"
    )

}