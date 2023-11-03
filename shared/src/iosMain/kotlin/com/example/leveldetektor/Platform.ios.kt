package com.example.kmptemplate

import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIDevice

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}
fun MainViewController() = ComposeUIViewController { App() }
actual fun getPlatformName(): Platform = IOSPlatform()