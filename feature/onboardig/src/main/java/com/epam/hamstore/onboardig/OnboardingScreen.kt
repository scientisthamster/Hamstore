@file:Suppress("MagicNumber")

package com.epam.hamstore.onboardig

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.epam.hamstore.designsystem.theme.*
import com.epam.hamstore.onboardig.model.OnboardingItem
import com.epam.hamstore.onboardig.model.onboardingItems
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
internal fun OnboardingRoute(
    modifier: Modifier = Modifier,
    navigateToHomeScreen: () -> Unit,
    viewModel: OnboardingViewModel = hiltViewModel()
) {
    OnboardingScreen(
        modifier = modifier,
        items = onboardingItems,
        pagerState = rememberPagerState(),
        coroutineScope = rememberCoroutineScope(),
        onStartUsingClick = {
            viewModel.shouldHideOnboardingScreen()
            navigateToHomeScreen()
        },
    )
}

@ExperimentalPagerApi
@Composable
internal fun OnboardingScreen(
    modifier: Modifier = Modifier,
    items: List<OnboardingItem>,
    pagerState: PagerState,
    coroutineScope: CoroutineScope,
    onStartUsingClick: () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(White100),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        HorizontalPager(
            count = items.size,
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { page ->
            val onboardingItem = items[page]
            with(onboardingItem) {
                OnboardingCarouselItem(
                    image = painterResource(id = image),
                    title = stringResource(id = title),
                    description = stringResource(id = description),
                    position = page,
                    lastIndex = items.lastIndex,
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        SliderIndicator(
            pageSize = items.size,
            modifier = Modifier
                .align(CenterHorizontally),
            selectedPage = pagerState.currentPage
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (pagerState.currentPage < items.lastIndex) {
                    // When Continue button clicked
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(
                            page = pagerState.currentPage + 1,
                            pageOffset = 0f
                        )
                    }
                } else {
                    onStartUsingClick()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 48.dp)
                .padding(bottom = 48.dp)
                .height(56.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(Black100),
            elevation = ButtonDefaults.elevation(1.dp, 4.dp)
        ) {
            val buttonText =
                stringResource(
                    id = if (pagerState.currentPage != items.lastIndex) R.string.button_continue
                    else R.string.start_using_app
                )
            Crossfade(
                targetState = buttonText,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = it,
                    style = buttonTextSmall,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Composable
internal fun SliderIndicator(
    modifier: Modifier = Modifier,
    pageSize: Int,
    selectedPage: Int
) {
    Row(
        modifier = modifier.padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        (0 until pageSize).forEach { position ->
            val width by animateDpAsState(targetValue = if (position == selectedPage) 24.dp else 8.dp)
            Box(
                modifier = Modifier
                    .height(8.dp)
                    .width(width)
                    .clip(CircleShape)
                    .background(if (position == selectedPage) Orange100 else Grey20)
            )
        }
    }
}

@Composable
internal fun OnboardingCarouselItem(
    modifier: Modifier = Modifier,
    image: Painter,
    title: String,
    description: String,
    position: Int,
    lastIndex: Int,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(White100),
        horizontalAlignment = CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .clip(
                    RoundedCornerShape(
                        bottomStartPercent = if (position == 0) 25 else 0,
                        bottomEndPercent = if (position == lastIndex) 25 else 0
                    )
                )
                .background(
                    color = Orange100
                )
                .weight(3f)
                .padding(horizontal = 28.dp),
            alignment = Center
        )

        Spacer(modifier = Modifier.height(24.dp))

        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            Text(
                text = title,
                style = titleMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = description,
                style = subtitleSmall,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
            )
        }
    }
}

@ExperimentalPagerApi
@Preview(showBackground = true)
@Composable
private fun PreviewOnboardingScreen() {
    OnboardingScreen(
        items = onboardingItems,
        pagerState = rememberPagerState(),
        coroutineScope = rememberCoroutineScope(),
        onStartUsingClick = { /*TODO*/ },
    )
}

@Preview(showBackground = true)
@Composable
private fun PreviewOnboardingCarouselItem() {
    with(OnboardingItem.ThirdItem) {
        OnboardingCarouselItem(
            image = painterResource(id = image),
            title = stringResource(id = title),
            description = stringResource(id = description),
            position = 2,
            lastIndex = 2,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewSliderIndicator() {
    SliderIndicator(
        pageSize = 3,
        selectedPage = 1,
    )
}