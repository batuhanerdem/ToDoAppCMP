package org.batuhanerdem.todoappcmp.root

import com.arkivanov.decompose.ComponentContext

interface HomeComponent
interface AddEditComponent
interface SettingsComponent

class DefaultHomeComponent(componentContext: ComponentContext) : HomeComponent, ComponentContext by componentContext

class DefaultAddEditComponent(componentContext: ComponentContext) : AddEditComponent, ComponentContext by componentContext

class DefaultSettingsComponent(componentContext: ComponentContext) : SettingsComponent, ComponentContext by componentContext
