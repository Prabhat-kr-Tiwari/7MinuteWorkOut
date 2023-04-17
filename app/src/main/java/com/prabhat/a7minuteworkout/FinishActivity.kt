package com.prabhat.a7minuteworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.prabhat.a7minuteworkout.databinding.ActivityFinishBinding
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class FinishActivity : AppCompatActivity() {

    private var binding:ActivityFinishBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_finish)
        binding=ActivityFinishBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        //for creating toolbar
        setSupportActionBar(binding?.toolbarFinishActivity)
        //for adding back button
        if (supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        binding?.toolbarFinishActivity?.setNavigationOnClickListener{
            onBackPressed()
        }
        binding?.btnFinish?.setOnClickListener{
            finish()

        }

        val dao=(application as WorkOutApp).db.historyDao()
        addDateToDatabase(dao)




    }
    private fun addDateToDatabase(historyDao: HistoryDao){
        val c=Calendar.getInstance()
        val dateTime=c.time
        Log.d("Date",""+dateTime)

        val sdf=SimpleDateFormat("dd MMM yyyy HH:mm:ss", Locale.getDefault())
        val date=sdf.format(dateTime)
        Log.d("FOrmated Date",""+date)



        lifecycleScope.launch{

            historyDao.insert(HistoryEntity(date))
            Log.d(" Date","Added"+date)


        }
    }
}