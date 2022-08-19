package com.example.mvvmhiltsample

import android.content.Context
import androidx.room.Room
import com.example.mvvmhiltsample.room.Database
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
     * Provides local room database as a singleton
     */
    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        Database::class.java,
        "SampleDatabase"
    ).build()

    /**
     * Provides dao to be injected into repos
     */
    @Singleton
    @Provides
    fun provideDao(database:Database) = database.getDao()

    /**
     * Provide NetworkQueue class applicationContext as performing network requests requires a context
     */
    @Singleton
    @Provides
    fun provideNetworkQueue(@ApplicationContext app:Context) = NetworkQueue(app)
}