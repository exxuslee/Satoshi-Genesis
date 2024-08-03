package org.haos.app.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import satoshi_genesis.composeapp.generated.resources.Res
import satoshi_genesis.composeapp.generated.resources.ic_arrow_right

@Composable
fun HsRow(title: StringResource, icon: DrawableResource, value: String? = null, onClick: () -> Unit) {
    RowUniversal(modifier = Modifier.padding(horizontal = 12.dp), onClick = onClick) {
        Image(
            modifier = Modifier.size(30.dp),
            painter = painterResource(icon),
            contentDescription = null
        )
        headline2_leah(
            text = stringResource(title),
            maxLines = 1,
            modifier = Modifier.padding(horizontal = 12.dp)
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
fun HsRow(title: StringResource, icon: ImageVector, value: String? = null, onClick: () -> Unit) {
    RowUniversal(modifier = Modifier.padding(horizontal = 12.dp), onClick = onClick) {
        Icon(icon,
            modifier = Modifier.size(30.dp),
            contentDescription = null
        )
        headline2_leah(
            text = stringResource(title),
            maxLines = 1,
            modifier = Modifier.padding(horizontal = 12.dp)
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