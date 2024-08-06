package org.haos.app.screens.key

import org.haos.app.core.BaseScreenModel
import org.haos.app.screens.key.models.KeyAction
import org.haos.app.screens.key.models.KeyEvent
import org.haos.app.screens.key.models.KeyViewState


class KeyScreenModel :
    BaseScreenModel<KeyViewState, KeyAction, KeyEvent>(initialState = KeyViewState()) {
    override fun obtainEvent(viewEvent: KeyEvent) {
        when (viewEvent) {

            else -> {}
        }
    }

}