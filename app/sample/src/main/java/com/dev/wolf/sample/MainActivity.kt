package com.dev.wolf.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.dev.wolf.monthandyearpicker.MonthPickerDialog
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val today = Calendar.getInstance()
        findViewById<Button>(R.id.month_picker).setOnClickListener {
            MonthPickerDialog.Builder(this, object : MonthPickerDialog.OnDateSetListener{
                override fun onDateSet(selectedMonth: Int, selectedYear: Int) {
                    Log.d("MainActivity", "selectedMonth : " + selectedMonth + " selectedYear : " + selectedYear);
                    Toast.makeText(this@MainActivity, "Date set with month" + selectedMonth + " year " + selectedYear, Toast.LENGTH_SHORT).show();
                }
            }, today.get(Calendar.YEAR), today.get(Calendar.MONTH))
                .setMinYear(1990)
                .setActivatedYear(2017)
                .setMaxYear(2030)
                .setMinMonth(Calendar.FEBRUARY)
                .setTitle("Select trading month")
                .setMonthRange(Calendar.FEBRUARY, Calendar.NOVEMBER)
                .setOnMonthChangedListener(object : MonthPickerDialog.OnMonthChangedListener {
                    override fun onMonthChanged(selectedMonth: Int) {
                        Log.d("MainActivity", "Selected month : " + selectedMonth)
                    }
                })
                .setOnYearChangedListener(object : MonthPickerDialog.OnYearChangedListener {
                    override fun onYearChanged(year: Int) {
                        Log.d("MainActivity", "Selected year : " + year)
                    }
                })
                .build()
                .show()
        }
    }
}