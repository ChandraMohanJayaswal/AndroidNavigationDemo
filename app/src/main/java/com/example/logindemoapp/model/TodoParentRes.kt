package com.anu.todoretrofit.model

data class TodoParentRes(
    val code: Int = 200,
    val success: Boolean,
    val timestamp: Long,
    val message: String,
    val items : List<Todo>,
    val meta: Meta
)