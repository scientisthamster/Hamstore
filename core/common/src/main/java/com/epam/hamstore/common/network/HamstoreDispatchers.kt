package com.epam.hamstore.common.network

import javax.inject.Qualifier
import kotlin.annotation.AnnotationRetention.RUNTIME

@Qualifier
@Retention(RUNTIME)
annotation class Dispatcher(val hamstoreDispatcher: HamstoreDispatchers)

enum class HamstoreDispatchers {
    IO
}