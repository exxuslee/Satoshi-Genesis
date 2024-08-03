package org.haos.app.screens.wallet

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.dp
import org.haos.app.screens.wallet.models.WalletEvent
import org.haos.app.screens.wallet.models.WalletViewState
import org.haos.app.theme.AppTheme
import org.haos.app.theme.ComposeAppTheme
import org.haos.app.ui.*
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import satoshi_genesis.composeapp.generated.resources.*


@Composable
fun WalletView(
    viewState: WalletViewState, eventHandler: (WalletEvent) -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = ComposeAppTheme.colors.andy
    ) {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            AppBar(title = stringResource(Res.string.Settings))
            Spacer(modifier = Modifier.height(12.dp))
            CellUniversalLawrenceSection(
                listOf(
                    {
                        HsSettingCell(
                            Res.string.BaseCurrency,
                            Res.drawable.ic_base_currency,
                            value = "code",
                            onClick = {
                            }
                        )
                    },
                    {
                        HsSettingCell(
                            Res.string.Language,
                            Res.drawable.ic_language,
                            value = Locale.current.language,
                            onClick = {

                            }
                        )
                    },
                )
            )
            VSpacer(32.dp)
            HSSectionRounded{
                headline2_leah(text = "2")
            }

        }
    }
}

@Composable
fun HsSettingCell(title: StringResource, icon: DrawableResource, value: String? = null, onClick: () -> Unit) {
    RowUniversal(modifier = Modifier.padding(horizontal = 16.dp), onClick = onClick) {
        Image(
            modifier = Modifier.size(30.dp),
            painter = painterResource(icon),
            contentDescription = null
        )
        body_leah(
            text = stringResource(title),
            maxLines = 1,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Spacer(Modifier.weight(1f))

        if (value != null) {
            subhead1_grey(
                text = value,
                maxLines = 1,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        }

        Image(
            modifier = Modifier.size(20.dp),
            painter = painterResource(Res.drawable.ic_arrow_right),
            contentDescription = null,
        )
    }
}


@Composable
@Preview
fun WalletView_Preview() {
    AppTheme {
        WalletView(viewState = WalletViewState()) {}
    }
}