package com.partitionsoft.beintouch.domain.usecases.app_entry

import com.partitionsoft.beintouch.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class RetrieveAppEntry(
    private val localUserManager: LocalUserManager
) {

    operator fun invoke(): Flow<Boolean> {
        return localUserManager.retrieveAppEntry()
    }

}