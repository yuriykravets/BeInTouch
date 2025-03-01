package com.partitionsoft.beintouch.presentation.onboarding

sealed class OnBoardingEvent {

    data object SaveAppEntry : OnBoardingEvent()

}