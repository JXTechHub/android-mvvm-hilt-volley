package com.example.mvvmhiltsample

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    /**
     * Provide NetworkQueue class applicationContext as performing network requests requires a context
     */
    @Singleton
    @Provides
    fun provideNetworkQueue(@ApplicationContext app:Context) = NetworkQueue(app)
}