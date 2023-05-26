package pl.farmaprom.trainings.contactsapp.networkstore.model

import kotlinx.serialization.Serializable

@Serializable
data class ContactApiModel(
    val id: Long,
    val name: String,
    val surname: String,
    val phoneNumber: String,
    val email: String?,
    val city: String?,
    val birthDate: Long?,
    val imageUrl: String?,
    val isFavourite: Boolean,
    val location: LocationApiModel?
)

@Serializable
data class LocationApiModel(
    val latitude:  Double,
    val longitude: Double
)
