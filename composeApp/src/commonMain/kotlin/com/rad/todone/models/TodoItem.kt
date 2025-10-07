package com.rad.todone.models

import utils.generateUUID
import kotlin.uuid.ExperimentalUuidApi

data class TodoItem @OptIn(ExperimentalUuidApi::class) constructor(
    val id: String = generateUUID(),
    val text: String,
    val isCompleted: Boolean = false
)