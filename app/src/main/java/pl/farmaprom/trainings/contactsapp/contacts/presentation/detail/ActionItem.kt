package pl.farmaprom.trainings.contactsapp.contacts.presentation.detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.farmaprom.trainings.contactsapp.ui.theme.ContactsAppTheme

@Composable
fun ActionItem(
    modifier: Modifier = Modifier,
    image: ImageVector,
    onClick: () -> Unit = {}
) {
    Card(
        modifier = modifier.clickable {
            onClick.invoke()
        },
        shape = RoundedCornerShape(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    ) {
        Icon(
            modifier = Modifier.padding(16.dp),
            imageVector = image,
            contentDescription = ""
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ActionItemPreview() {
    ContactsAppTheme {
        ActionItem(image = Icons.Default.Home)
    }
}
