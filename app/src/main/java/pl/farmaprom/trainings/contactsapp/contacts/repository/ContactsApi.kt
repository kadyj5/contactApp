package pl.farmaprom.trainings.contactsapp.contacts.repository

import pl.farmaprom.trainings.contactsapp.networkstore.model.ContactApiModel
import retrofit2.http.GET
import retrofit2.http.Header

interface ContactsApi {

    //http://baseurl.com/contacts/a/b
    //@GET("contacts/a/b")
    @GET("contacts")
    suspend fun getAll(
        @Header("X-Api-Key") apiKey: String = "6bfabbc0f2c7b07ce5a178b5bd9c59069a41b5cb"
    ): List<ContactApiModel>
}