package utils

import app.cash.sqldelight.db.SqlDriver

actual class DriverFactory {
    actual fun createDriver(): SqlDriver {
        throw Exception("web createDriver Not implemented")
    }
}