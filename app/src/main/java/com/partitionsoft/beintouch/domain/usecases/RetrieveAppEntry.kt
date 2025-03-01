package com.partitionsoft.beintouch.domain.usecases

import com.partitionsoft.beintouch.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RetrieveAppEntry(
    private val localUserManager: LocalUserManager
) {

    operator fun invoke(): Flow<Boolean> {
        return localUserManager.retrieveAppEntry()
    }

}