package com.rad.todone

import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import com.rad.todone.database.ToDoneDb
import utils.DriverFactory

fun MainViewController() = ComposeUIViewController {
    // Initialize the database for Android
    val driver = remember {DriverFactory().createDriver()}
    val database = remember { ToDoneDb(driver)}
    val todoQueries = remember { database.todoDatabaseQueries }
    App(todoQueries)
}