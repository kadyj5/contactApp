package pl.farmaprom.trainings.contactsapp.networkstore

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import pl.farmaprom.trainings.contactsapp.API_URL
import retrofit2.Retrofit

val retrofit = Retrofit.Builder()
//    .baseUrl(http://trainingcontactsapp-env.eba-x3t56ejz.eu-central-1.elasticbeanstalk.com/)
    .baseUrl(API_URL)
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .build()
