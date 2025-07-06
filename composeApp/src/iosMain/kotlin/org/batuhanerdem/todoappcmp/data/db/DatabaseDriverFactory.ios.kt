package org.batuhanerdem.todoappcmp.data.db

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import batuhanerdem.todoappcmp.db.ToDoAppCMPDatabase

actual class DatabaseDriverFactory() {
    actual fun createDriver(): SqlDriver =
        NativeSqliteDriver(schema = ToDoAppCMPDatabase.Schema, name = "ToDoAppCMP.Database.db")
}