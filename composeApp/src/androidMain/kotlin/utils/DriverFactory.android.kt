package utils

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.rad.todone.database.ToDoneDb

actual class DriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(ToDoneDb.Schema, context, RadConsts.DATABASE_FILE_NAME)
    }
}