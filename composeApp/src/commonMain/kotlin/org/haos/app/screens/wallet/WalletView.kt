package org.haos.app.screens.wallet

import Satoshi_Genesis.composeApp.BuildConfig
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Send
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.dp
import org.haos.app.screens.wallet.models.WalletEvent
import org.haos.app.screens.wallet.models.WalletViewState
import org.haos.app.theme.AppTheme
import org.haos.app.theme.LocalLocale
import org.haos.app.theme.LocalThemeIsDark
import org.haos.app.ui.*
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import satoshi_genesis.composeapp.generated.resources.*

@Composable
fun WalletView(
    viewState: WalletViewState, eventHandler: (WalletEvent) -> Unit
) {
    Surface(
        modifier = Modifier.background(
            brush = Brush.verticalGradient(
                colors = listOf(
                    MaterialTheme.colorScheme.primary, MaterialTheme.colorScheme.scrim
                ),
            ),
        ),
        color = Color.Transparent,
    ) {
        val scrollState = rememberScrollState()
        Column(modifier = Modifier.verticalScroll(scrollState)) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(Res.drawable.avatar),
                    contentDescription = "avatar",
                    modifier = Modifier.size(128.dp).align(Alignment.Center)
                )
                var isDark by LocalThemeIsDark.current
                val icon = remember(isDark) {
                    if (isDark) Res.drawable.ic_light_mode
                    else Res.drawable.ic_dark_mode
                }

                HsIconButton(
                    modifier = Modifier.align(Alignment.TopEnd).padding(vertical = 12.dp),
                    onClick = {
                        isDark = !isDark
                    }) {
                    Icon(vectorResource(icon), contentDescription = null)
                }
            }

            RowUniversal(
                verticalPadding = 0.dp, horizontalArrangement = Arrangement.Center
            ) {
                title3_tyler(stringResource(Res.string.profile))
            }
            VSpacer(8.dp)

            CellUniversalSection(
                listOf(
                    {
                        HsRow(icon = Icons.Outlined.FavoriteBorder, titleContent = {
                            headline2_tyler(
                                text = stringResource(Res.string.election_history),
                                maxLines = 1,
                                modifier = Modifier.padding(horizontal = 12.dp)
                            )
                        }, onClick = {}, arrowRight = true, valueContent = {})
                    },
                    {
                        HsRow(icon = Res.drawable.ic_account_balance_fill0, titleContent = {
                            Column(modifier = Modifier.padding(horizontal = 12.dp)) {
                                headline2_tyler(text = stringResource(Res.string.wallet))
                                subhead1_grey(text = viewState.wallet)
                            }
                        }, arrowRight = false, valueContent = {
                            ButtonPrimaryGrey(
                                title = stringResource(if (viewState.wallet.isBlank()) Res.string.connect else Res.string.disable),
                                onClick = {
                                    if (viewState.wallet.isBlank()) eventHandler.invoke(WalletEvent.ConnectTon)
                                    else eventHandler.invoke(WalletEvent.DisconnectTon)
                                })
                        })
                    },
                    {
                        HsRow(icon = Icons.Outlined.Call, titleContent = {
                            Column(modifier = Modifier.padding(horizontal = 12.dp)) {
                                headline2_tyler(text = stringResource(Res.string.invite_friends))
                                subhead1_grey(text = "И получить BONES")
                            }
                        }, arrowRight = false, valueContent = {
                            ButtonPrimaryGrey(title = stringResource(Res.string.invite), onClick = {})
                        })
                    },
                )
            )
            HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
            headline1_tyler(
                stringResource(Res.string.about_game),
                Modifier.padding(horizontal = 24.dp, vertical = 8.dp),
            )
            CellUniversalSection(
                listOf(
                    {
                        HsRow(
                            icon = Icons.Outlined.Info,
                            titleContent = {
                                headline2_tyler(
                                    text = stringResource(Res.string.game_rules),
                                    maxLines = 1,
                                    modifier = Modifier.padding(horizontal = 12.dp)
                                )
                            },
                            onClick = {},
                            arrowRight = true,
                        )
                    },
                    {
                        HsRow(
                            icon = Icons.Outlined.Star,
                            titleContent = {
                                headline2_tyler(
                                    text = stringResource(Res.string.how_are_the_prizes_distributed),
                                    maxLines = 1,
                                    modifier = Modifier.padding(horizontal = 12.dp)
                                )
                            },
                            onClick = {},
                            arrowRight = true,
                        )
                    },
                )
            )
            HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
            headline1_tyler(
                stringResource(Res.string.community),
                Modifier.padding(horizontal = 24.dp, vertical = 8.dp),
            )
            CellUniversalSection {
                HsRow(
                    icon = Icons.AutoMirrored.Outlined.Send,
                    titleContent = {
                        headline2_tyler(
                            text = stringResource(Res.string.chat), modifier = Modifier.padding(horizontal = 12.dp)
                        )
                    },
                    onClick = {},
                    arrowRight = true,
                )
            }
            HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
            headline1_tyler(
                stringResource(Res.string.language),
                Modifier.padding(horizontal = 24.dp, vertical = 8.dp),
            )
            var localLocale by LocalLocale.current

            CellUniversalSection(listOf({
                HsRow(
                    icon = painterResource(
                        if (Locale.current.language == "en") Res.drawable.ic_check_box_24dp
                        else Res.drawable.ic_check_box_blank_24dp
                    ),
                    titleContent = {
                        headline2_tyler(
                            text = stringResource(Res.string.en), modifier = Modifier.padding(horizontal = 12.dp)
                        )
                    },
                    onClick = {
                        eventHandler(WalletEvent.Locale("en"))
                        localLocale = Locale("en")
                    },
                    arrowRight = false,
                )
            }, {
                HsRow(
                    icon = painterResource(
                        if (Locale.current.language == "ru") Res.drawable.ic_check_box_24dp
                        else Res.drawable.ic_check_box_blank_24dp
                    ),
                    titleContent = {
                        headline2_tyler(
                            text = stringResource(Res.string.ru), modifier = Modifier.padding(horizontal = 12.dp)
                        )
                    },
                    onClick = {
                        eventHandler(WalletEvent.Locale("ru"))
                        localLocale = Locale("ru")
                    },
                    arrowRight = false,
                )
            }))

            VSpacer(32.dp)
            CellBorderedRowUniversal(borderTop = true, borderBottom = true) {
                headline2_leah(text = BuildConfig.APP_NAME)
                HSpacer(8.dp)
                headline2_leah(text = BuildConfig.APP_VERSION)
            }
            VSpacer(64.dp)

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