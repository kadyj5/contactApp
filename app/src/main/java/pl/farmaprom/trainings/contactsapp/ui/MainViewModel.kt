package pl.farmaprom.trainings.contactsapp.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pl.farmaprom.trainings.contactsapp.contacts.data.Contact
import pl.farmaprom.trainings.contactsapp.contacts.presentation.ContactsViewState
import pl.farmaprom.trainings.contactsapp.contacts.repository.ContactsRepository
import pl.farmaprom.trainings.contactsapp.contacts.repository.ContactsRepositoryBasedOnRetrofit

class MainViewModel : ViewModel() {

    private val repository: ContactsRepository = ContactsRepositoryBasedOnRetrofit()

    var viewState = mutableStateOf(ContactsViewState())
        private set

    init {
        viewModelScope.launch {
            viewState.value = ContactsViewState(
                contacts = repository.getAll()
            )
        }
    }

    fun getContactById(id: Long): Contact {
        return viewState.value.contacts.first { singleListItem ->
            singleListItem.id == id
        }
    }
}
