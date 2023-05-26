package pl.farmaprom.trainings.contactsapp.contacts.repository

import pl.farmaprom.trainings.contactsapp.contacts.data.Contact
import pl.farmaprom.trainings.contactsapp.networkstore.model.ContactApiModel
import pl.farmaprom.trainings.contactsapp.networkstore.retrofit

class ContactsRepositoryBasedOnRetrofit : ContactsRepository {

    override suspend fun getAll(): List<Contact> {
        val contactsFromApi = retrofit.create(ContactsApi::class.java).getAll()
        return contactsFromApi.map { contactApiModel ->
            transformToDomain(contactApiModel)
        }
    }

    private fun transformToDomain(apiModel: ContactApiModel): Contact {
        return Contact(
            id = apiModel.id,
            name = apiModel.name,
            surname = apiModel.surname,
            profileImageUrl = apiModel.imageUrl,
            email = apiModel.email ?: "",
            isFavourite = apiModel.isFavourite
        )
    }
}
