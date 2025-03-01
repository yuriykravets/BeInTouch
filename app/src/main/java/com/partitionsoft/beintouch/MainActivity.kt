package com.partitionsoft.beintouch

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import com.partitionsoft.beintouch.domain.usecases.AppEntryUseCases
import com.partitionsoft.beintouch.domain.usecases.RetrieveAppEntry
import com.partitionsoft.beintouch.presentation.navigation.NavGraph
import com.partitionsoft.beintouch.presentation.onboarding.OnBoardingScreen
import com.partitionsoft.beintouch.presentation.onboarding.OnBoardingViewModel
import com.partitionsoft.beintouch.ui.theme.BeInTouchTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        installSplashScreen().apply { setKeepOnScreenCondition(viewModel::splashCondition) }

        setContent {
            BeInTouchTheme {
                Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background)) {
                    val startDestination = viewModel.startDestination
                    NavGraph(startDestination = startDestination)
                }
            }
        }
    }
}