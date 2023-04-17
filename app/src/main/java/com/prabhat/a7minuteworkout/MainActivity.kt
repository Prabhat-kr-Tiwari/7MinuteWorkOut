package com.prabhat.a7minuteworkout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toast
import com.prabhat.a7minuteworkout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    //
    private var binding:ActivityMainBinding?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //use this activity main file called ActivityMainBinding and
        //inflate with layout inflator and store it inside of the binding object
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)//and use root of this binding object which is mainactivity xml file




        //val flStartButton:FrameLayout=findViewById(R.id.flStart)
        //binding object is nullable so we need question mark
        //framelayout is nullable
        binding?.flStart?.setOnClickListener{
            val intent=Intent(this,ExerciseActivity::class.java)
            startActivity(intent)
           /* Toast.makeText(this@MainActivity,
                "Here we will start the the exercise" ,Toast.LENGTH_SHORT
                    ).show()*/
        }
        binding?.flBMI?.setOnClickListener{
            val intent=Intent(this,BMIActivity::class.java)
            startActivity(intent)
            /* Toast.makeText(this@MainActivity,
                 "Here we will start the the exercise" ,Toast.LENGTH_SHORT
                     ).show()*/
        }
        binding?.flHistory?.setOnClickListener{
            val intent=Intent(this,HistoryActivity::class.java)
            startActivity(intent)
            /* Toast.makeText(this@MainActivity,
                 "Here we will start the the exercise" ,Toast.LENGTH_SHORT
                     ).show()*/
        }
    }

    //to avoid binding to memory leak
    override fun onDestroy() {
        super.onDestroy()
        binding=null
    }
}
//--Importance of viewbinding
/*
1.Shorter and consise
2.Faster and more efficient during compile time
3.It is a safer alternative because it ensures
only the views interconnecting lay out are being referenced

because otherwise what could happen is, let's say we have an I.D. We call it flstart.
But then in another XML file, we also have, I feel, start and then by accident, we are
 accessing

the wrong Flstart and this would crash our application.

But now, with view binding, we are making sure that we are only specifically accessing the items.

The IDs of the file that fits to our exome L fits to our class.

So our main activity has an example assigned to it.

And only of that example, we can now access the IDs, which we now do because find view by ID works

throughout all files.

It doesn't just work for this particular file.

So if we had an file start in another XML file that has nothing to do with our activity in our application

would crash.*/
