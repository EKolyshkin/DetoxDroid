package com.flx_apps.digitaldetox.ui.screens.feature.disable_apps

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.flx_apps.digitaldetox.R
import com.flx_apps.digitaldetox.system_integration.OverlayContent
import com.flx_apps.digitaldetox.system_integration.OverlayService
import com.flx_apps.digitaldetox.ui.theme.*


class AppDisabledOverlayService : OverlayService(OverlayContent { AppDisabledOverlay() })

/**
 * The overlay that is displayed when the user tries to open a disabled app.
 * When closed, the user will be redirected to the home screen.
 */
@Preview
@Composable
fun AppDisabledOverlay() {
    val context = androidx.compose.ui.platform.LocalContext.current
    DetoxDroidTheme(darkTheme = true) {
        // Overlay content
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black) // Semi-transparent overlay background
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 1f))
                    .padding(horizontal = 32.dp), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.weight(2f))
                /* Display name of application being blocked.
                Text(
                    text = OverlayService.EXTRA_RUNNING_APP_PACKAGE_NAME,
                    textAlign = TextAlign.Center,
                    color = PurpleGrey40
                )
                */
                Text(
                    text = stringResource(id = R.string.feature_disableApps_overlay_title),
                    style = MaterialTheme.typography.displayLarge,
                    color = Color.White,
                    modifier = Modifier.padding(vertical = 16.dp)
                )
                Text(
                    text = stringResource(id = R.string.feature_disableApps_overlay_message),
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Center,
                    color = Color.White,
                )
                OutlinedButton(modifier = Modifier
                    .padding(top = 32.dp)
                    .scale(1.5f), onClick = {
                    (context as OverlayService).closeOverlay()
                }) {
                    Text(
                        text = stringResource(id = R.string.action_close),
                        color = Purple80
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground_cropped),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .size(196.dp)
                        .offset(y = 32.dp)
                )
            }

        }
    }
}