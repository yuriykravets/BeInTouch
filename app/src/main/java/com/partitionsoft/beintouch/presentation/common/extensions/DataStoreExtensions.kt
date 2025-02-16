package com.partitionsoft.beintouch.presentation.common.extensions

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.partitionsoft.beintouch.utils.USER_SETTINGS

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = USER_SETTINGS)

