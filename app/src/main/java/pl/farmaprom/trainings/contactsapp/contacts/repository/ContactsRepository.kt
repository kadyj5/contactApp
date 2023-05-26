package pl.farmaprom.trainings.contactsapp.contacts.repository

import pl.farmaprom.trainings.contactsapp.contacts.data.Contact

interface ContactsRepository {

    suspend fun getAll(): List<Contact>
}
