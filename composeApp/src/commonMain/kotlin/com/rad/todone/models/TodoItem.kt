package com.rad.todone.models

import utils.generateUUID

data class TodoItem (
    val id: String = generateUUID(),
    val text: String,
    val isCompleted: Long? = 0 //Treat this as a boolean. 1 = true. 0 = false. For some reason SQLDelight made it a long.
)