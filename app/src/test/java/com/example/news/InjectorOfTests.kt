package com.example.news

import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.robolectric.shadows.ShadowLog

@ExperimentalCoroutinesApi
val injectorOfTests: TestAppComponent
    get() {
        ShadowLog.stream = System.out
        return DaggerTestAppComponent.builder().build()
    }