package com.anu.todoretrofit.ui

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.anu.todoretrofit.model.TodoPost

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ToDoView(innerPadding: PaddingValues, viewModel: TodoViewModel) {
    val todoList = viewModel.uiState.todoList
    Log.i("Todo List", todoList.toString())
    Column(modifier = Modifier.padding(vertical = innerPadding.calculateTopPadding(), horizontal = 20.dp)) {
        var taskFieldValue by remember {
            mutableStateOf("")
        }
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = taskFieldValue, maxLines = 1, onValueChange = { taskFieldValue = it }
        )
        Button(onClick = {
            val todo = TodoPost(title = taskFieldValue, description = "Hi", is_completed = false)
            viewModel.createTodo(todo)
            taskFieldValue = ""
        }) {
            Text(text = "Add", maxLines = 1)
        }
        Spacer(modifier = Modifier.height(20.dp))
        LazyColumn(
            modifier = Modifier
        ) {
            items(
                items = todoList
            ) { todo ->
                Log.i("todo todo", todo.toString())
                Row(
                    Modifier
                        .border(width = 1.dp, color = Color.Gray)
                        .fillMaxWidth()
                        .wrapContentSize(unbounded = true),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(Modifier.padding(16.dp)) {
                        var isChecked by remember {
                            mutableStateOf(false)
                        }
                        if (isChecked) {
                            Text(
                                todo.title,
                                style = TextStyle(textDecoration = TextDecoration.LineThrough),
                            )
                        } else {
                            Text(
                                todo.title,
                            )
                        }
                        Checkbox(checked = isChecked, onCheckedChange = {
                            isChecked = it
                            viewModel.updateTodo(
                                TodoPost(
                                    title = todo.title,
                                    description = "desc",
                                    is_completed = it
                                ),
                                id = todo._id
                            )
                        },
                            Modifier.padding(horizontal = 20.dp))
                    }
                    IconButton(onClick = { viewModel.deleteTodo(todo._id) }) {
                        Icon(imageVector = Icons.Filled.Delete, contentDescription = null)
                    }
                }
            }
        }
    }
}