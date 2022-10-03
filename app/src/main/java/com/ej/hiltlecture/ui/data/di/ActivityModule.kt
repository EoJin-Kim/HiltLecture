package com.ej.hiltlecture.ui.data.di

import com.ej.hiltlecture.ui.data.di.qualifier.ActivityHash
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ActivityModule {

    @ActivityHash
    @Singleton
    @Provides
    fun provideHash() = hashCode().toString()
}