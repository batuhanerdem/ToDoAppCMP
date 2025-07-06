package org.batuhanerdem.todoappcmp.data.db

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import batuhanerdem.todoappcmp.db.ToDoAppCMPDatabase

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver = AndroidSqliteDriver(
        schema = ToDoAppCMPDatabase.Schema, context = context, name = "ToDoAppCMP.Database.db"
    )
}