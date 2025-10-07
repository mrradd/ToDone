package com.rad.todone

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.rad.todone.models.TodoItem
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import todone.composeapp.generated.resources.Res
import todone.composeapp.generated.resources.compose_multiplatform
import kotlin.uuid.ExperimentalUuidApi

@OptIn(ExperimentalUuidApi::class)
@Composable
@Preview
fun App() {
    var newTodoText: String by remember { mutableStateOf("") }
    var todoList = remember { mutableStateListOf<TodoItem>() }

    MaterialTheme() {
        Column (
            Modifier.fillMaxSize().background(Color.White).padding(16.dp)
        ) {
            Text(text = "ToDone",
                Modifier.padding(16.dp))

            OutlinedTextField(
                value = newTodoText,
                onValueChange = { newTodoText = it },
                label = { Text("New Task") },
                modifier = Modifier.fillMaxWidth())

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    println("derp")
                    if (newTodoText.isNotBlank())
                    {
                        val newItem = TodoItem(text = newTodoText)
                        todoList.add(newItem)
                    }
                }) {
                Text("Add Task")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Column {
                if (todoList.isEmpty()) {
                    Text(text = "No tasks yet. Add one!")
                }
                else
                {
                    todoList.forEach { todo ->
                        Text (
                            text = todo.text,
                            Modifier.padding(vertical = 4.dp))
                    }
                }
            }
        }
    }
}