@file:OptIn(ExperimentalCoroutinesApi::class)

package com.scientisthamsterandsofi.common

import app.cash.turbine.test
import com.scientisthamsterandsofi.common.result.Result
import com.scientisthamsterandsofi.common.result.asResult
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.Assert.*

class ResultKtTest {

    @Test
    fun Result_catches_errors() = runTest {
        flow {
            emit(1)
            throw Exception("Test Done")
        }
            .asResult()
            .test {
                assertEquals(Result.Loading, awaitItem())
                assertEquals(Result.Success(1), awaitItem())

                when (val errorResult = awaitItem()) {
                    is Result.Error -> assertEquals(
                        "Test Done",
                        errorResult.exception?.message
                    )
                    Result.Loading,
                    is Result.Success -> throw IllegalArgumentException(
                        "The flow should have emitted an Error Result"
                    )
                }
                awaitComplete()
            }
    }
}