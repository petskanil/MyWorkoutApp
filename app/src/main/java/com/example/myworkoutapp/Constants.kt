package com.example.myworkoutapp

object Constants {

    fun defaultExerciseList(): ArrayList<Exercise>{
        val exerciseList = ArrayList<Exercise>()
        val hipThrust = Exercise(
            1,
            "Hip Thrust",
            R.drawable.exercise_hip_thrust,
            false,
            false
        )
        exerciseList.add(hipThrust)

        val bulgarianSquat = Exercise(
            2,
            "Bulgarian Split Squat",
            R.drawable.exercise_bulgarian_split_squat,
            false,
            false
        )
        exerciseList.add(bulgarianSquat)

        val lunges = Exercise(
            3,
            "Lunges",
            R.drawable.exercise_lunges,
            false,
            false
        )
        exerciseList.add(lunges)

        val squat = Exercise(
            4,
            "Squat",
            R.drawable.exercise_squat,
            false,
            false
        )
        exerciseList.add(squat)

        return exerciseList
    }
}