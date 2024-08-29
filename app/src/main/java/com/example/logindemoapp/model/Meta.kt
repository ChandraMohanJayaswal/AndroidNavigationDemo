package com.anu.todoretrofit.model

data class Meta (
    val total_items: Int,
    val total_pages: Int,
    val per_page_item: Int,
    val current_page: Int,
    val page_size: Int,
    val has_more_page: Boolean
)