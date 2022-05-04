package com.example.android.basicweather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val weatherEntryET = findViewById<EditText>(R.id.et_weather_entry)
        val coordinatorLayout = findViewById<CoordinatorLayout>(R.id.coordinator_layout)

        val weatherListRV = findViewById<RecyclerView>(R.id.rv_weather_list)
        weatherListRV.layoutManager = LinearLayoutManager(this)
        weatherListRV.setHasFixedSize(true)

        val adapter = WeatherAdapter()
        weatherListRV.adapter = adapter


        /*addWeatherBtn.setOnClickListener {
            val newWeather = weatherEntryET.text.toString()
            if (!TextUtils.isEmpty(newWeather)) {
                adapter.addWeather(Weather(newWeather, false))
                weatherEntryET.setText("")
                weatherListRV.scrollToPosition(0)
            }
        }*/


        adapter.addWeather(Weather("","DEC 30","LOW: 30°F","HIGH: 38°F","PRECIP: 11%","MOSTLY CLOUDY","Mainly cloudy with a small chance of rain."))
        adapter.addWeather(Weather("","DEC 29","LOW: 38°F","HIGH: 44°F","PRECIP: 07%","VERY SUNNY","Very sunny with a very small chance for rain."))
        adapter.addWeather(Weather("","DEC 28","LOW: 22°F","HIGH: 32°F","PRECIP: 32%","SLIGHTLY RAINY","High chance for an all day drizzle."))
        adapter.addWeather(Weather("","DEC 27","LOW: 16°F","HIGH: 21°F","PRECIP: 08%","THUNDERSTORMS","Low chance for rain, high chance for thunder."))
        adapter.addWeather(Weather("","DEC 26","LOW: 44°F","HIGH: 49°F","PRECIP: 21%","CHANCE OF SNOW","High chance for either snow or rain."))
        adapter.addWeather(Weather("","DEC 25","LOW: 07°F","HIGH: 21°F","PRECIP: 17%","VERY RAINY","All day rain showers."))
        adapter.addWeather(Weather("","DEC 24","LOW: 18°F","HIGH: 28°F","PRECIP: 03%","EXTREME FOG","Extreme fog conditions all day."))
        adapter.addWeather(Weather("","DEC 23","LOW: 33°F","HIGH: 45°F","PRECIP: 11%","SNOW SHOWERS","High chance for snow downpours all day."))
        adapter.addWeather(Weather("","DEC 22","LOW: 46°F","HIGH: 51°F","PRECIP: 55%","MOSTLY CLOUDY","Very cloudy with a high chance for some rain."))
        adapter.addWeather(Weather("","DEC 21","LOW: 22°F","HIGH: 28°F","PRECIP: 32%","VERY RAINY","Very rainy with very cold temperatures all day."))

        val itemTouchCallback = object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.absoluteAdapterPosition
                val deletedWeather = adapter.deleteWeatherAt(position)
                val snackbar = Snackbar.make(
                    coordinatorLayout,
                    "Deleted: ${deletedWeather.text}",
                    Snackbar.LENGTH_LONG
                )
                snackbar.setAction("UNDO") {
                    adapter.addWeather(deletedWeather, position)
                }
                snackbar.show()
            }

        }

        val itemTouchHelper = ItemTouchHelper(itemTouchCallback)
        itemTouchHelper.attachToRecyclerView(weatherListRV)
    }
}

