package com.rad.todone

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.rad.todone.database.TodoDatabaseQueries
import com.rad.todone.models.TodoItem
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(todoQueries: TodoDatabaseQueries) {
    var newTodoText: String by remember { mutableStateOf("") }
    val todoList = remember { mutableStateListOf<TodoItem>() }

    MaterialTheme() {
        Column (
            Modifier.fillMaxSize().background(Color.White).padding(16.dp)
        ) {
            Text(text = "ToDone",
                Modifier.padding(16.dp))

            LaunchedEffect(todoQueries){
                val itemsFromDb = todoQueries.selectAllTodos().executeAsList()
                todoList.addAll(itemsFromDb.map { TodoItem(it.id, it.text, it.isCompleted)})
            }

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
                        todoQueries.insertTodo(
                            id = newItem.id,
                            text = newItem.text,
                            isCompleted = newItem.isCompleted)
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