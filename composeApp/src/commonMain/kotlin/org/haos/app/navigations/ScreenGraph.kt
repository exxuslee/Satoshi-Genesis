package org.haos.app.navigations

import org.jetbrains.compose.resources.StringResource
import satoshi_genesis.composeapp.generated.resources.*

enum class ScreenGraph(val label: StringResource) {
    Wallet(Res.string.wallet), Puzzle(Res.string.puzzle), Qubit(Res.string.qubit), Settings(Res.string.settings),
}
