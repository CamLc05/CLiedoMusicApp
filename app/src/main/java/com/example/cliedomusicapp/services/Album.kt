package com.example.cliedomusicapp.services

import com.example.cliedomusicapp.models.Album
import retrofit2.http.GET
import retrofit2.http.Path

interface AlbumService {
    @GET("api/albums")
    suspend fun getAllAlbums(): List<Album>

    @GET("api/albums/{id}")
    suspend fun getAlbumById(@Path("id") id: String): Album
}