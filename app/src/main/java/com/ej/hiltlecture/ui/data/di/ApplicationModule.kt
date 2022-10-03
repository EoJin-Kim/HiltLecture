package com.ej.hiltlecture.ui.data.di

import com.ej.hiltlecture.ui.data.di.qualifier.AppHash
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @AppHash
    @Singleton
    @Provides
    fun provideHash() = hashCode().toString()
}