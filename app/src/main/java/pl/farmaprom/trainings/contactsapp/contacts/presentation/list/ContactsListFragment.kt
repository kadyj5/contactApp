package pl.farmaprom.trainings.contactsapp.contacts.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.navGraphViewModels
import pl.farmaprom.trainings.contactsapp.R
import pl.farmaprom.trainings.contactsapp.ui.MainViewModel
import pl.farmaprom.trainings.contactsapp.ui.theme.ContactsAppTheme

class ContactsListFragment : Fragment() {

    private val viewModel: MainViewModel by navGraphViewModels(R.id.nav)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contacts_list2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<ComposeView>(R.id.compose_view).apply {
            setContent {
                setViewCompositionStrategy(DisposeOnViewTreeLifecycleDestroyed)
                ContactsAppTheme {
                    ContactsScreen(
                        viewState = viewModel.viewState.value,
                        onContactClicked = { contactId ->
                            findNavController().navigate(
                                ContactsListFragmentDirections.actionContactsListFragmentToDetailFragment(
                                    contactId
                                )
                            )
                        }
                    )
                }
            }
        }
    }
}