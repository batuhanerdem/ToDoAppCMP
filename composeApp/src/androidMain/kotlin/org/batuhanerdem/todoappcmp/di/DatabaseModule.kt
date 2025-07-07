package org.batuhanerdem.todoappcmp.di

import app.cash.sqldelight.db.SqlDriver
import batuhanerdem.todoappcmp.db.ToDoAppCMPDatabase
import org.batuhanerdem.todoappcmp.data.db.DatabaseDriverFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single<SqlDriver> { DatabaseDriverFactory(androidContext()).createDriver() }
    single<ToDoAppCMPDatabase> { ToDoAppCMPDatabase(get()) }
}