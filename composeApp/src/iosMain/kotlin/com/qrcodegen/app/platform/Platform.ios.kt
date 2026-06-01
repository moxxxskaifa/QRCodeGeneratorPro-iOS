package com.qrcodegen.app.platform

import platform.UIKit.UIDevice
import platform.UIKit.UIPasteboard
import platform.Foundation.NSURL
import platform.UIKit.UIApplication
import platform.UIKit.UIActivityViewController

actual fun platformName(): String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion

actual fun copyToClipboard(text: String) {
    UIPasteboard.generalPasteboard.string = text
}

actual class HapticFeedback {
    actual fun light() {}
    actual fun medium() {}
    actual fun heavy() {}
}

actual fun openUrl(url: String) {
    val nsUrl = NSURL.URLWithString(url) ?: return
    UIApplication.sharedApplication.openURL(nsUrl, options = emptyMap<Any?, Any>(), completionHandler = null)
}

actual fun shareText(text: String) {
    val activityVC = UIActivityViewController(
        activityItems = listOf(text),
        applicationActivities = null
    )
    val rootVC = UIApplication.sharedApplication.keyWindow?.rootViewController
    rootVC?.presentViewController(activityVC, animated = true, completion = null)
}
