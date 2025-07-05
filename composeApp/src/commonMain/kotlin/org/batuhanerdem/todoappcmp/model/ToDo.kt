package org.batuhanerdem.todoappcmp.model

data class ToDo(
    val id: String,
    val title: String,
    var isSelected: Boolean = false
)