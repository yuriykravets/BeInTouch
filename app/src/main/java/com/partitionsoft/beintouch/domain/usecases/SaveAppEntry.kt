package com.partitionsoft.beintouch.domain.usecases

import com.partitionsoft.beintouch.domain.manager.LocalUserManager

class SaveAppEntry(
    private val localUserManager: LocalUserManager
) {

    suspend operator fun invoke() {
        localUserManager.saveAppEntry()
    }

}