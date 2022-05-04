package com.example.android.basicweather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.widget.CheckBox
import android.widget.TextView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager



class WeatherAdapter : RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {
    val weathers: MutableList<Weather> = mutableListOf()

    override fun getItemCount() = this.weathers.size

    fun addWeather(weather: Weather, position: Int = 0) {
        this.weathers.add(position, weather)
        this.notifyItemInserted(position)
    }

    fun deleteWeatherAt(position: Int): Weather {
        val weather = this.weathers.removeAt(position)
        this.notifyItemRemoved(position)
        return weather
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.weather_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(this.weathers[position])
    }



    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val weatherTextTV: TextView = view.findViewById(R.id.tv_weather_text)
        private val weatherDateTV: TextView = view.findViewById(R.id.tv_date_text)
        private val weatherLowTV: TextView = view.findViewById(R.id.tv_low_text)
        private val weatherHighTV: TextView = view.findViewById(R.id.tv_high_text)
        private val weatherPrecipitationTV: TextView = view.findViewById(R.id.tv_precipitation_text)
        private val weathersmallDescriptionTV: TextView = view.findViewById(R.id.tv_smallDescription_text)
        private val weatherbigDescriptionTV: TextView = view.findViewById(R.id.tv_bigDescription_text)

        init {
            view.setOnClickListener{
                Snackbar.make(view, weathers[position].bigDescription, Snackbar.LENGTH_LONG).show()
            }
        }

        fun bind(weather: Weather) {
            this.weatherTextTV.text = weather.text
            this.weatherDateTV.text = weather.date
            this.weatherLowTV.text = weather.low
            this.weatherHighTV.text = weather.high
            this.weatherPrecipitationTV.text = weather.precipitation
            this.weathersmallDescriptionTV.text = weather.smallDescription
            this.weatherbigDescriptionTV.text = weather.bigDescription
        }
    }
}