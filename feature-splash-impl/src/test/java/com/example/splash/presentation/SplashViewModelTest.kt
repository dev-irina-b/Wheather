package com.example.splash.presentation

import com.example.core.session.api.TokenManager
import io.mockk.every
import io.mockk.mockk
import junit.framework.TestCase.assertNull
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class SplashViewModelTest {

    private val tokenManager: TokenManager = mockk()
    private val testDispatcher = StandardTestDispatcher()

    @Test
    fun `when session exists, destination should be Home`() = runTest(testDispatcher) {
        every { tokenManager.hasSession() } returns true

        val viewModel = SplashViewModel(tokenManager, testDispatcher)

        assertNull(viewModel.state.value.destination)
        advanceUntilIdle()
        assertEquals(SplashDestination.Home, viewModel.state.value.destination)
    }

    @Test
    fun `when session does not exist, destination should be Auth`() = runTest(testDispatcher) {
        every { tokenManager.hasSession() } returns false

        val viewModel = SplashViewModel(tokenManager, testDispatcher)

        assertNull(viewModel.state.value.destination)
        advanceUntilIdle()
        assertEquals(SplashDestination.Auth, viewModel.state.value.destination)
    }
}

