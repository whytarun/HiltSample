package com.example.hiltexample.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.hiltexample.models.ProductsItem
import com.example.hiltexample.retrofit.FakerApi
import javax.inject.Inject

class ProductRepository @Inject constructor(val fakerApi: FakerApi) {

    private val _products =MutableLiveData<List<ProductsItem>>()

    val products:LiveData<List<ProductsItem>>
    get() = _products

    suspend fun getProducts(){
        val result =fakerApi.getProducts()
        if(result.isSuccessful && result.body() != null)
        {
            _products.postValue(result.body())
        }
    }
}