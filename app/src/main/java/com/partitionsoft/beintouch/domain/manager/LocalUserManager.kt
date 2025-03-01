package com.partitionsoft.beintouch.domain.manager

import kotlinx.coroutines.flow.Flow

interface LocalUserManager {

    suspend fun saveAppEntry()

    fun retrieveAppEntry(): Flow<Boolean>

}