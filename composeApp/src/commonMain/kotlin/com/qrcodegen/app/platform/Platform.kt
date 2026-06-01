package com.qrcodegen.app.platform

expect fun platformName(): String
expect fun copyToClipboard(text: String)
expect class HapticFeedback {
    fun light()
    fun medium()
    fun heavy()
}
expect fun openUrl(url: String)
expect fun shareText(text: String)
