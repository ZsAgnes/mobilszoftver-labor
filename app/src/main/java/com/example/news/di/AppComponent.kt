package com.example.news.di

import co.zsmb.rainbowcake.dagger.RainbowCakeComponent
import co.zsmb.rainbowcake.dagger.RainbowCakeModule
import com.example.news.data.disk.DiskModule
import com.example.news.data.network.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        DiskModule::class,
        NetworkModule::class,
        RainbowCakeModule::class,
        ViewModelModule::class,
    ]
)
interface AppComponent : RainbowCakeComponent
