package com.example.hiltexample.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hiltexample.models.ProductsItem
import com.example.hiltexample.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.handleCoroutineException
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val productRepository: ProductRepository) :ViewModel() {

    val productsLiveData :LiveData<List<ProductsItem>>
    get() = productRepository.products

        val handler = CoroutineExceptionHandler { context, throwable -> println(
            "error $throwable")
        }
    init {
        viewModelScope.launch(handler) {
            productRepository.getProducts()
        }
    }
}