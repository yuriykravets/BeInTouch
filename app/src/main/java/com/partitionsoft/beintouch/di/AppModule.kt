package com.partitionsoft.beintouch.di

import android.app.Application
import com.partitionsoft.beintouch.data.manager.LocalUserManagerImpl
import com.partitionsoft.beintouch.domain.manager.LocalUserManager
import com.partitionsoft.beintouch.domain.usecases.app_entry.AppEntryUseCases
import com.partitionsoft.beintouch.domain.usecases.app_entry.RetrieveAppEntry
import com.partitionsoft.beintouch.domain.usecases.app_entry.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManager = LocalUserManagerImpl(application)


    @Provides
    @Singleton
    fun provideReadAppEntryUseCase(
        localUserManager: LocalUserManager
    ) = AppEntryUseCases(
        retrieveAppEntry = RetrieveAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )

}