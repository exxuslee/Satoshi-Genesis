package org.haos.app.navigations

import org.jetbrains.compose.resources.StringResource
import satoshi_genesis.composeapp.generated.resources.Res
import satoshi_genesis.composeapp.generated.resources.home
import satoshi_genesis.composeapp.generated.resources.key
import satoshi_genesis.composeapp.generated.resources.wallet

enum class ScreenGraph(val label: StringResource) {
    Home(Res.string.home), Key(Res.string.key), Wallet(Res.string.wallet),
}
