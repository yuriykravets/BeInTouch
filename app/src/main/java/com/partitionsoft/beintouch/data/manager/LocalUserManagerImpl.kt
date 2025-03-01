package com.partitionsoft.beintouch.data.manager

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import com.partitionsoft.beintouch.domain.manager.LocalUserManager
import com.partitionsoft.beintouch.presentation.common.extensions.dataStore
import com.partitionsoft.beintouch.utils.APP_ENTRY
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalUserManagerImpl(
    private val context: Context
) : LocalUserManager {
    override suspend fun saveAppEntry() {
        context.dataStore.edit { settings ->
            settings[PreferenceKeys.APPS_ENTRY] = true
        }
    }

    override fun retrieveAppEntry(): Flow<Boolean> {
        return context.dataStore.data.map { preferences ->
            preferences[PreferenceKeys.APPS_ENTRY] ?: false
        }
    }

}

private object PreferenceKeys {
    val APPS_ENTRY = booleanPreferencesKey(name = APP_ENTRY)
}

