package pl.farmaprom.trainings.contactsapp.contacts.presentation.list

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import pl.farmaprom.trainings.contactsapp.R
import pl.farmaprom.trainings.contactsapp.contacts.data.Contact
import pl.farmaprom.trainings.contactsapp.contacts.presentation.ContactsViewState
import pl.farmaprom.trainings.contactsapp.ui.theme.ContactsAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactsScreen(
    viewState: ContactsViewState,
    onContactClicked: (id: Long) -> Unit = {}
) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary),
                title = {}
            )
        }
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize().padding(it)) {
            item {
                HeaderItem(text = stringResource(id = R.string.contacts))
            }

            items(items = viewState.contacts) { singleItem ->
                ContactsItem(
                    id = singleItem.id,
                    profileImageUrl = singleItem.profileImageUrl,
                    name = "${singleItem.name} ${singleItem.surname}" ,
                    isFavourite = singleItem.isFavourite,
                    onContactClicked = onContactClicked
                )
                Divider()
            }
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun ContactsScreenPreview() {
    ContactsAppTheme {
        ContactsScreen(
            viewState = ContactsViewState(
                contacts = listOf(
                    Contact(id = 1L, name = "name 1", profileImageUrl = null, isFavourite = true),
                    Contact(id = 2L, name = "name 2", profileImageUrl = null, isFavourite = false),
                    Contact(id = 3L, name = "name 3", profileImageUrl = null, isFavourite = false)
                )
            )
        )
    }
}
