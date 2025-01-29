package com.salvatoreacademy.sa_android_nativo_iniciante_app1

import retrofit2.Call
import retrofit2.http.GET

interface CreatureApiService {
    @GET("creature")
    fun listCreatures(): Call<List<Creature>>
}
