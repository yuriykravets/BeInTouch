package com.partitionsoft.beintouch.domain.manager

import kotlinx.coroutines.flow.Flow

interface LocalUserManager {

    suspend fun saveAppEntry()

    suspend fun retrieveAppEntry(): Flow<Boolean>

}