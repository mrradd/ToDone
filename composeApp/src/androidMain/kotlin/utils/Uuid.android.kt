package utils

actual fun generateUUID(): String {
    return java.util.UUID.randomUUID().toString()
}