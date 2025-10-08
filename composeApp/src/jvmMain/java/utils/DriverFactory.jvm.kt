package utils

import app.cash.sqldelight.db.SqlDriver
import kotlin.Exception

actual class DriverFactory {
    actual fun createDriver(): SqlDriver {
        throw Exception("java createDriver Not implemented")
    }
}