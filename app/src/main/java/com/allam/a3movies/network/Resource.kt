package com.allam.a3movies.network

import com.google.android.gms.common.api.Status

sealed class Resource<T>{
     class Success<T>( val data: T) : Resource<T>()
     class Failed<T>(val message: String) : Resource<T>()

}
