package com.master.app.ui.repairment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.master.app.common.UserType
import com.master.app.data.model.Service
import com.master.app.data.model.User
import com.master.app.ui.component.Base64Image
import com.master.app.ui.theme.AndroidAppTheme

@Composable
fun RepairmanServices(
    providedServices: List<Service>,
    loggedUser: User?,
    onDeleteServiceClicked: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        for (service in providedServices.sortedBy { it.topLevelCategory }) {
            ServiceInfo(
                service = service,
                onDeleteServiceClicked = onDeleteServiceClicked,
                loggedUser = loggedUser
            )
        }
    }
}

@Composable
fun ServiceInfo(
    service: Service,
    loggedUser: User?,
    onDeleteServiceClicked: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.small)
            .background(MaterialTheme.colorScheme.inverseOnSurface)
            .padding(10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(
                text = service.category,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = service.topLevelCategory,
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.secondary
            )
        }
        Divider()
        Box(
            modifier = modifier
                .fillMaxWidth()
                .clip(MaterialTheme.shapes.small)
                .background(MaterialTheme.colorScheme.onPrimary)
                .padding(10.dp)
        ) {
            Text(
                text = service.description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.secondary
            )
        }
        if (service.images.isNotEmpty()) {
            LazyRow{
                items(
                    items = service.images
                ) {
                    Base64Image(
                        base64Str = it.data,
                        modifier = Modifier
                            .padding(10.dp)
                            .size(100.dp)
                            .clip(MaterialTheme.shapes.medium)
                    )
                }
            }
        } 
        else {
            Row(
                modifier = Modifier.padding(10.dp)
            ) {
                Text(
                    text = "No pictures attached",
                    color = MaterialTheme.colorScheme.secondary,
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
        if (loggedUser?.id == service.user.id || loggedUser?.type == UserType.ADMIN) {
            Box(
                contentAlignment = Alignment.BottomEnd,
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(
                    onClick = { onDeleteServiceClicked(service.id) }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Delete,
                        contentDescription = "Delete service"
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RepairmanServicesPreview() {
    AndroidAppTheme {
        RepairmanServices(
            providedServices = listOf(
                Service(1, "Gradjevinski radovi", "Parketar", "Neki opis otkud znam bratee", User(1, "Andrej", "Jokic", "s", "s", UserType.REGULAR, "s", "s", "s", 5.0))
            ),
            User(1, "Andrej", "Jokic", "s", "s", UserType.REGULAR, "s", "s", "s", 5.0),
            { _ -> }
        )
    }
}