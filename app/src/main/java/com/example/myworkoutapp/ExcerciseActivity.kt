package com.example.myworkoutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.example.myworkoutapp.databinding.ActivityExcerciseBinding

class ExcerciseActivity : AppCompatActivity() {
    private var binding: ActivityExcerciseBinding? = null

    private var timer: CountDownTimer? = null

    private var rest: Boolean = false
    private var exercise: Boolean = false

    private val restDuration = 10
    private val excerciseDuration = 30

    private var exerciseList: ArrayList<Exercise>? = null
    private var currentExercisePosition = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExcerciseBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setSupportActionBar(binding?.toolbarExcercise)

        if (supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true) // Show the back button in the toolbar (this button is also known as the "up button".
        }

        binding?.toolbarExcercise?.setNavigationOnClickListener {
            onBackPressed() // Same functionality as pressing the back button on the device.
        }

        exerciseList = Constants.defaultExerciseList()

        setUpRestView()
    }

    private fun setUpRestView() { //Makes sure that we always reset and start the timer when we enter the page
        if(timer != null){
            timer?.cancel()
        }
        rest = true
        exercise = false

        binding?.clRest?.visibility = View.VISIBLE
        binding?.clExercise?.visibility = View.GONE

        binding?.tvTitleRest?.text = "Exercise starting in "
        setProgressBar(restDuration, 0, binding?.progressBarRest, binding?.tvTimerRest)
    }

    private fun setUpExerciseView() {
        if(timer != null){
            timer?.cancel()
        }
        exercise = true
        rest = false

        binding?.clExercise?.visibility = View.VISIBLE
        binding?.clRest?.visibility = View.GONE

        val exercise = exerciseList!![currentExercisePosition]

        binding?.tvTitleExercise?.text = exercise.getName()
        binding?.ivExercise?.setImageResource(exercise.getImage())

        setProgressBar(excerciseDuration,0, binding?.progressBarExercise, binding?.tvTimerExercise)
    }

    private fun setUpFinishedExerciseView() {
        Toast.makeText(this@ExcerciseActivity, "Workout finished!", Toast.LENGTH_LONG).show()
    }

    private fun setProgressBar(duration: Int, initProgress: Int, progressBar: ProgressBar?, tvText: TextView?) {
        var progress = initProgress
        progressBar?.max = duration*1000
        progressBar?.progress = initProgress
        tvText?.text = duration.toString()

        timer = object: CountDownTimer(duration.toLong()*1000, 50) { // The countdown interval is not exact at all
            override fun onTick(millisUntilFinished: Long) {
                progress += 50
                progressBar?.progress = duration*1000 - progress
                if(progress % 1000 == 0) {
                    tvText?.text = (duration - progress/1000).toString()
                }
            }

            override fun onFinish() {
                tvText?.text = "0"
                progressBar?.progress = 0
                timerFinished()
            }
        }.start()
    }

    private fun timerFinished() {
        Toast.makeText(this@ExcerciseActivity,"Timer finished", Toast.LENGTH_LONG).show()

        if(rest) {
            if(currentExercisePosition < exerciseList!!.size) {
                currentExercisePosition++
                setUpExerciseView()
            } else {
                setUpFinishedExerciseView()
            }
        } else if(exercise){
            setUpRestView()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if(timer != null) {
            timer?.cancel()
        }
        binding = null
    }
}