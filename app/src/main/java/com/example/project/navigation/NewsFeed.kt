package com.example.project.navigation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.company.myartist.model.response.EventsResponse
import com.example.project.model.response.ArtistsResponce
import com.example.project.R
import com.example.project.api.ArtistApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsFeed : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val feeds = ArtistApiService.create().getArtistNews()

        feeds.enqueue(object : Callback<EventsResponse> {
            override fun onFailure(call: Call<EventsResponse>?, t: Throwable?) {
                Log.v("retrofit", "call failed")
            }

            override fun onResponse(call: Call<EventsResponse>?, response: Response<EventsResponse>?) {
                val value = response?.body()?.data?.events
            }

        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news_feed, container, false)
    }

}
