package com.master.app.ui.user

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.master.app.common.UserType
import com.master.app.data.model.User
import com.master.app.ui.component.LabelValue
import com.master.app.ui.repairment.RepairmanRatings
import com.master.app.ui.theme.AndroidAppTheme

@Composable
fun UserProfile(
    user: User,
    modifier: Modifier = Modifier
) {
    val containerModifier = Modifier
        .fillMaxWidth()
        .clip(MaterialTheme.shapes.small)
        .background(MaterialTheme.colorScheme.onPrimary)
        .border(
            1.0.dp,
            Color.Gray,
            MaterialTheme.shapes.small
        )
        .padding(15.dp)

    Column(
        verticalArrangement = Arrangement.spacedBy(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)
            .verticalScroll(rememberScrollState())
    ) {
        UserInfo(
            user = user,
            modifier = containerModifier
        )
        UserServices(
            modifier = containerModifier
        )
    }
}

@Composable
fun UserInfo(
    user: User,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = "${user.firstName} ${user.lastName}",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(10.dp))
        LabelValue(
            label = "Email",
            value = user.email
        )
        LabelValue(
            label = "User type",
            value = user.type.toString(),
        )
        LabelValue(
            label = "Password",
            value = "*".repeat(user.password.length),
        )
        Spacer(modifier = Modifier.height(15.dp))
        RepairmanRatings(
            ratings = listOf(1, 2, 3, 3, 3)
        )
    }
}

@Composable
fun UserServices(
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = "My Services",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Preview(showBackground = true)
@Composable
fun UserProfilePreview() {
    AndroidAppTheme {
        UserProfile(
            User(
                1,
                "Andrej",
                "Jokic",
                "andrejjokic00@gmail.com",
                "andrej123",
                UserType.REGULAR,
                null
            )
        )
    }
}