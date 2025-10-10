package com.rad.todone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rad.todone.database.ToDoneDb
import utils.DriverFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        val driver = DriverFactory(this).createDriver() //'this' is the Activity Context
        val database = ToDoneDb(driver)
        val todoQueries = database.todoDatabaseQueries

        setContent {
            MaterialTheme {
                App(todoQueries)
            }
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    //App() //todo ch  need to implement a mock db to use preview.
}