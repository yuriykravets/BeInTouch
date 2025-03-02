package com.partitionsoft.beintouch.domain.usecases.app_entry

import com.partitionsoft.beintouch.domain.manager.LocalUserManager

class SaveAppEntry(
    private val localUserManager: LocalUserManager
) {

    suspend operator fun invoke() {
        localUserManager.saveAppEntry()
    }

}