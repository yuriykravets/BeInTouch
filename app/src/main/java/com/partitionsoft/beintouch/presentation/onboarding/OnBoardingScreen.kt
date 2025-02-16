package com.partitionsoft.beintouch.presentation.onboarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.partitionsoft.beintouch.presentation.Dimens.MediumPadding2
import com.partitionsoft.beintouch.presentation.common.NewsButton
import com.partitionsoft.beintouch.presentation.common.NewsTextButton
import com.partitionsoft.beintouch.presentation.onboarding.components.OnBoardingPage
import com.partitionsoft.beintouch.presentation.onboarding.components.PageIndicator
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun OnBoardingScreen(
    event: (OnBoardingEvent) -> Unit
) {

    Column(modifier = Modifier.fillMaxSize()) {
        val pageState = rememberPagerState(initialPage = 0) {
            pages.size
        }

        val buttonState = remember {
            derivedStateOf {
                when (pageState.currentPage) {
                    0 -> listOf("", "Next")
                    pages.size - 1 -> listOf("Back", "Get Started")
                    else -> listOf("Back", "Next")
                }
            }
        }

        HorizontalPager(state = pageState) { index ->
            OnBoardingPage(page = pages[index])
        }
        Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = MediumPadding2)
                .navigationBarsPadding(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            PageIndicator(
                modifier = Modifier,
                pageSize = pages.size,
                selectedPage = pageState.currentPage
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                val scope = rememberCoroutineScope()

                if (buttonState.value[0].isNotEmpty()) {
                    NewsTextButton(text = buttonState.value[0], onClick = {
                        scope.launch {
                            pageState.animateScrollToPage(page = pageState.currentPage - 1)
                        }
                    })
                }

                NewsButton(text = buttonState.value[1],
                    onClick = {
                        scope.launch {
                            if (pageState.currentPage == 2) {
                                event(OnBoardingEvent.SaveAppEntry)
                            } else {
                                pageState.animateScrollToPage(
                                    page = pageState.currentPage + 1
                                )
                            }
                        }
                    })

                // AutoScroll implemented
                LaunchedEffect(key1 = pageState.settledPage) {
                    delay(3000)
                    val nextPage =
                        if (pageState.currentPage == pageState.pageCount - 1) 0 else pageState.currentPage + 1
                    pageState.animateScrollToPage(nextPage)
                }
            }
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}