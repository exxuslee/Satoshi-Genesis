package org.haos.app.screens.wallet

import Satoshi_Genesis.composeApp.BuildConfig
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.dp
import org.haos.app.screens.wallet.models.WalletEvent
import org.haos.app.screens.wallet.models.WalletViewState
import org.haos.app.theme.AppTheme
import org.haos.app.ui.*
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import satoshi_genesis.composeapp.generated.resources.*

@Composable
fun WalletView(
    viewState: WalletViewState, eventHandler: (WalletEvent) -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize().background(
            brush = Brush.verticalGradient(
                colors = listOf(
                    MaterialTheme.colorScheme.primaryContainer,
                    MaterialTheme.colorScheme.onPrimaryContainer
                ),
            ),
        ),
        color = Color.Transparent,
    ) {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            RowUniversal(horizontalArrangement = Arrangement.Center) {
                Image(
                    painter = painterResource(Res.drawable.avatar),
                    contentDescription = "avatar",
                    modifier = Modifier.size(100.dp)
                )
            }
            RowUniversal(
                verticalPadding = 0.dp,
                horizontalArrangement = Arrangement.Center
            ) {
                title3_leah(stringResource(Res.string.profile))
            }

            CellUniversalSection(
                listOf(
                    {
                        HsRow(
                            Res.string.election_history,
                            Icons.Outlined.FavoriteBorder,
                            value = "code",
                            onClick = {
                            }
                        )
                    },
                    {
                        HsRow(
                            Res.string.wallet,
                            Res.drawable.ic_account_balance_fill0,
                            value = Locale.current.language,
                            onClick = {
                            }
                        )
                    },
                    {
                        HsRow(
                            Res.string.invite_friends,
                            Icons.Outlined.Call,
                            value = Locale.current.language,
                            onClick = {
                            }
                        )
                    },
                )
            )
            VSpacer(32.dp)

            CellBorderedRowUniversal(borderTop = true, borderBottom = true) {
                headline2_leah(text = BuildConfig.APP_NAME)
                HSpacer(8.dp)
                headline2_leah(text = BuildConfig.APP_VERSION)
            }

        }
    }
}


@Composable
@Preview
fun WalletView_Preview() {
    AppTheme {
        WalletView(viewState = WalletViewState()) {}
    }
}