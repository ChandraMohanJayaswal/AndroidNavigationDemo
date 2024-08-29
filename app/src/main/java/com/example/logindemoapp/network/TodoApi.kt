package com.anu.todoretrofit.network

import com.anu.todoretrofit.model.TodoParentRes
import com.anu.todoretrofit.model.TodoPost
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface TodoApi {

    /*
    {
    "code": 200,
    "success": true,
    "timestamp": 1724839035613,
    "message": "Paginated Response",
    "items": [
        {
            "_id": "66cef031b3bbcf2d71f2bb28",
            "title": "123123",
            "description": "desc",
            "is_completed": false,
            "created_at": "2024-08-28T09:38:57.937Z",
            "updated_at": "2024-08-28T09:39:34.598Z"
        }
    ],
    "meta": {
        "total_items": 1,
        "total_pages": 1,
        "per_page_item": 10,
        "current_page": 1,
        "page_size": 1,
        "has_more_page": false
    }
}
    **/
    @GET(value = "/v1/todos")
    suspend fun getTodos(): TodoParentRes

    @POST("/v1/todos")
    suspend fun createTodo(@Body todo: TodoPost)

    @DELETE("/v1/todos/{id}")
    suspend fun deleteTodo(@Path("id") id: String)

    @PUT("v1/todos/{id}")
    suspend fun updateTodo(@Path("id") id: String, @Body todo: TodoPost)
}