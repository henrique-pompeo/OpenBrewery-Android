package com.android.post.domain.usecase.base

interface UseCaseResponse<Type> {

    fun onSuccess(result: Type)

    fun onError(apiError: Exception)
}

