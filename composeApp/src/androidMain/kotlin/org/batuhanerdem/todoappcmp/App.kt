package org.batuhanerdem.todoappcmp

import android.app.Application
import org.batuhanerdem.todoappcmp.di.databaseModule
import org.batuhanerdem.todoappcmp.di.sharedModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        val module = sharedModule + databaseModule
        startKoin {
            androidContext(this@App)
            modules(module)
        }
    }
}