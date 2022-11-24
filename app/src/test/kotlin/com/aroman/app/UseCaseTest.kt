package com.aroman.app

import com.aroman.app.test_utils.EntityProvider.getCart
import com.aroman.app.test_utils.EntityProvider.getHomePage
import com.aroman.app.test_utils.EntityProvider.getPhoneDetails
import com.aroman.domain.model.HomePage
import com.aroman.domain.model.Resource
import com.aroman.domain.repository.MockyRepository
import com.aroman.domain.use_case.GetCartUseCase
import com.aroman.domain.use_case.GetHomePageUseCase
import com.aroman.domain.use_case.GetPhoneDetailsUseCase
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@RunWith(JUnit4::class)
class UseCaseTest {
    @Mock
    lateinit var repository: MockyRepository

    private lateinit var getHomeUseCase: GetHomePageUseCase
    private lateinit var getPhoneDetailsUseCase: GetPhoneDetailsUseCase
    private lateinit var getCartUseCase: GetCartUseCase

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        getHomeUseCase = GetHomePageUseCase(repository)
        getPhoneDetailsUseCase = GetPhoneDetailsUseCase(repository)
        getCartUseCase = GetCartUseCase(repository)
    }

    @Test
    fun `usecase getHomeUseCase return success value`() {
        runBlocking {
            Mockito.`when`(repository.getHomePage()).thenReturn(getHomePage())
            var response: Resource<HomePage>
            getHomeUseCase().onEach { result ->
                response = result
                assertEquals(getHomePage(), response.data)
            }
        }
    }

    @Test
    fun `usecase getCartUseCase return success value`() {
        runBlocking {
            Mockito.`when`(repository.getCartContents()).thenReturn(getCart())
            var response: Resource<HomePage>
            getHomeUseCase().onEach { result ->
                response = result
                assertEquals(getCart(), response.data)
            }
        }
    }

    @Test
    fun `usecase getPhoneDetailsUseCase return success value`() {
        runBlocking {
            Mockito.`when`(repository.getPhoneDetails(1)).thenReturn(getPhoneDetails())
            var response: Resource<HomePage>
            getHomeUseCase().onEach { result ->
                response = result
                assertEquals(getPhoneDetails(), response.data)
            }
        }
    }
}