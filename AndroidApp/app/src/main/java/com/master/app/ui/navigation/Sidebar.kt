package com.master.app.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.master.app.ui.theme.AndroidAppTheme

@Composable
fun Sidebar(
    modifier: Modifier = Modifier
) {
    val items = listOf(
        SidebarItemInfo("Profile", Icons.Filled.Person),
        SidebarItemInfo("Blogs", Icons.Filled.LocationOn),
        SidebarItemInfo("Repairman", Icons.Filled.Build)
    )

    var selected by remember { mutableIntStateOf(0) }

    ModalDrawerSheet {
        for ((i, item) in items.withIndex()) {
            SidebarItem(
                title = item.title,
                icon = item.icon,
                onClick = { selected = i },
                modifier
                    .clip(MaterialTheme.shapes.large)
                    .background(
                        color = if (selected == i) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.background
                    )
            )
        }
    }
}

data class SidebarItemInfo(
    val title: String,
    val icon: ImageVector
)

@Composable
fun SidebarItem(
    title: String,
    icon: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(5.dp)
            .clickable(onClick = onClick)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "Leading icon"
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = title,
            style = MaterialTheme.typography.labelLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SidebarPreview() {
    AndroidAppTheme {
        Sidebar()
    }
}