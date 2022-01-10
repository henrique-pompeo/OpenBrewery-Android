package com.henrique.domain.usecases.base

import com.android.post.domain.usecase.base.UseCaseResponse
import kotlinx.coroutines.*
import java.util.concurrent.CancellationException

abstract class UseCase<Type, in Params>() where Type : Any {

    abstract suspend fun run(params: Params? = null): Type


    fun invoke(scope: CoroutineScope, params: Params?, onResult: UseCaseResponse<Type>?) {

        scope.launch {
            try {
                val result = run(params)
                onResult?.onSuccess(result)
            } catch (e: CancellationException) {
                e.printStackTrace()
                onResult?.onError(Exception(e))
            } catch (e: Exception) {
                e.printStackTrace()
                onResult?.onError(Exception(e))
            }
        }
    }

}