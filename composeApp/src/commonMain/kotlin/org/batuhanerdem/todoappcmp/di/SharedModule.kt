package org.batuhanerdem.todoappcmp.di

import org.batuhanerdem.todoappcmp.data.repository.ToDoRepository
import org.koin.dsl.module

val sharedModule = module {
    single<ToDoRepository> { ToDoRepository(get()) }
}