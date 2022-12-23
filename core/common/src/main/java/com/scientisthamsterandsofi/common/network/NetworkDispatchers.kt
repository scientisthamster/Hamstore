package com.scientisthamsterandsofi.common.network

import javax.inject.Qualifier
import kotlin.annotation.AnnotationRetention.RUNTIME

@Qualifier
@Retention(RUNTIME)
annotation class Dispatcher(val hamstoreDispatchers: HamstoreDispatchers)

enum class HamstoreDispatchers {
    IO
}