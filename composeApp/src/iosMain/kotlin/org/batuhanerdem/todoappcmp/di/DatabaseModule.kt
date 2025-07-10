package org.batuhanerdem.todoappcmp.di

import app.cash.sqldelight.db.SqlDriver
import batuhanerdem.todoappcmp.db.ToDoAppCMPDatabase
import org.batuhanerdem.todoappcmp.data.db.DatabaseDriverFactory
import org.koin.dsl.module

val databaseModule = module {
    single<SqlDriver> { DatabaseDriverFactory().createDriver() }
    single<ToDoAppCMPDatabase> { ToDoAppCMPDatabase(get()) }
}