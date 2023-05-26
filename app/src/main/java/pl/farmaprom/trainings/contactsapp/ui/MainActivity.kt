package pl.farmaprom.trainings.contactsapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.fragment.app.FragmentActivity
import pl.farmaprom.trainings.contactsapp.R
import pl.farmaprom.trainings.contactsapp.contacts.presentation.detail.DetailsScreen
import pl.farmaprom.trainings.contactsapp.contacts.presentation.list.ContactsScreen

class MainActivity : FragmentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Navigation based on selectedContact in ViewState condition
//        setContent {
//            val viewState = viewModel.viewState.value
//
//            if (viewState.selectedContact == null) {
//                ContactsScreen(
//                    viewState = viewState,
//                    onContactClicked = { id ->
//                        viewModel.onContactSelected(id)
//                    }
//                )
//            } else {
//                DetailsScreen(
//                    contact = viewState.selectedContact,
//                    onNavigateUp = {
//                        viewModel.onNavigateUp()
//                    }
//                )
//            }
//        }
    }
}
