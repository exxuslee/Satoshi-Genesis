package org.haos.app.navigations

import org.jetbrains.compose.resources.StringResource
import satoshi_genesis.composeapp.generated.resources.Res
import satoshi_genesis.composeapp.generated.resources.puzzle
import satoshi_genesis.composeapp.generated.resources.settings
import satoshi_genesis.composeapp.generated.resources.wallet

enum class ScreenGraph(val label: StringResource) {
    Wallet(Res.string.wallet), Puzzle(Res.string.puzzle), Settings(Res.string.settings),
}
