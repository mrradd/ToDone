package utils

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.rad.todone.database.ToDoneDb

actual class DriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(ToDoneDb.Schema, RadConsts.DATABASE_FILE_NAME)
    }
}