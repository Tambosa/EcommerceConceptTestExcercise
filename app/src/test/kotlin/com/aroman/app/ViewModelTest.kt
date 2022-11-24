package com.aroman.app

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.aroman.app.test_utils.EntityProvider.getCart
import com.aroman.app.test_utils.EntityProvider.getHomePage
import com.aroman.app.test_utils.EntityProvider.getPhoneDetails
import com.aroman.app.test_utils.TestCoroutineRule
import com.aroman.domain.model.Cart
import com.aroman.domain.model.HomePage
import com.aroman.domain.model.PhoneDetails
import com.aroman.domain.model.Resource
import com.aroman.domain.use_case.GetCartUseCase
import com.aroman.domain.use_case.GetHomePageUseCase
import com.aroman.domain.use_case.GetPhoneDetailsUseCase
import com.aroman.ecommerceconcepttestexcercise.ui.cart.CartViewModel
import com.aroman.ecommerceconcepttestexcercise.ui.details.DetailsViewModel
import com.aroman.ecommerceconcepttestexcercise.ui.home.HomeViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class ViewModelTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var testCoroutineRule = TestCoroutineRule()

    @Mock
    lateinit var getHomeUseCase: GetHomePageUseCase

    @Mock
    lateinit var getPhoneDetailsUseCase: GetPhoneDetailsUseCase

    @Mock
    lateinit var getCartUseCase: GetCartUseCase

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var cartViewModel: CartViewModel
    private lateinit var detailsViewModel: DetailsViewModel

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        homeViewModel = HomeViewModel(getHomeUseCase)
        cartViewModel = CartViewModel(getCartUseCase)
        detailsViewModel = DetailsViewModel(getPhoneDetailsUseCase)
    }

    @Test
    fun `homeViewModel success result is in livedata value`() {
        testCoroutineRule.runBlockingTest {
            val observer = Observer<HomePage> {}
            Mockito.`when`(getHomeUseCase())
                .thenReturn(flow { emit(Resource.Success<HomePage>(getHomePage())) })

            try {
                homeViewModel.homePageData.observeForever(observer)
                homeViewModel.getHomePage()

                assertNotNull(homeViewModel.homePageData.value)
                assertEquals(getHomePage(), homeViewModel.homePageData.value)
            } finally {
                homeViewModel.homePageData.removeObserver(observer)
            }
        }
    }

    @Test
    fun `cartViewModel success result is in livedata value`() {
        testCoroutineRule.runBlockingTest {
            val observer = Observer<Cart> {}
            Mockito.`when`(getCartUseCase())
                .thenReturn(flow { emit(Resource.Success<Cart>(getCart())) })

            try {
                cartViewModel.cartData.observeForever(observer)
                cartViewModel.getCart()

                assertNotNull(cartViewModel.cartData.value)
                assertEquals(getCart(), cartViewModel.cartData.value)
            } finally {
                cartViewModel.cartData.removeObserver(observer)
            }
        }
    }

    @Test
    fun `detailsViewModel success result is in livedata value`() {
        testCoroutineRule.runBlockingTest {
            val observer = Observer<PhoneDetails> {}
            Mockito.`when`(getPhoneDetailsUseCase(1))
                .thenReturn(flow { emit(Resource.Success<PhoneDetails>(getPhoneDetails())) })

            try {
                detailsViewModel.homeDetailsData.observeForever(observer)
                detailsViewModel.getPhoneDetails(1)

                assertNotNull(detailsViewModel.homeDetailsData.value)
                assertEquals(getPhoneDetails(), detailsViewModel.homeDetailsData.value)
            } finally {
                detailsViewModel.homeDetailsData.removeObserver(observer)
            }
        }
    }
}