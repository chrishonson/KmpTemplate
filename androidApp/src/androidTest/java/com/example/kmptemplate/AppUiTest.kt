package com.example.kmptemplate
import androidx.compose.ui.test.junit4.createComposeRule

import androidx.activity.compose.setContent
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AppUiTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        Assert.assertEquals("com.adammcneilly.mviexample", appContext.packageName)
    }
    @Test
    fun appLaunchesSuccessfully() {
        // Set the content to the App composable
        composeTestRule.setContent {
            App()
        }

        // Verify that the app title is displayed
        composeTestRule.onNodeWithText("My App").assertIsDisplayed()
    }
}