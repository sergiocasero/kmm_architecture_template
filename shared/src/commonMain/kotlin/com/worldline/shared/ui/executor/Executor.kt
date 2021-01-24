package com.worldline.shared.ui.executor

import kotlinx.coroutines.CoroutineDispatcher

expect class Executor {
    val main: CoroutineDispatcher
    val io: CoroutineDispatcher
}