package org.batuhanerdem.todoappcmp

import android.app.Application
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {


    }
}