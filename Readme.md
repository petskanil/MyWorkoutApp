# My workout app

Workout app for Android, created using Kotlin.

## Disclaimer

This App is created by me for my personal use. It has not been, or will not be, distributed on any app stores. The background for this project is to develope my skills as a Android App developer, as well as creating an app I personally have missed from the Play Store.

## Project description

This app is primarily a workout app focusing on building muscles in an effective way. I have a problem structuring my exercises, so this app is made to make sure I can easily find a program. In addition, the app is meant to keep track of the strain on each muscle group, making sure that I am able to get full body workouts focusing on every aspect of my body.

## Structure

When you first enter the app, you have three choices. 
1. You can perform a simple exercise,

2.  workout or 

3. check out your personal page.

### Exercise

A simple activity is simply one exercise that you can choose to do. When you press the button you come to a page where you can choose your activity. You can filter the activity list according to which muscles you want to focus on, and which equipment you have available.

#### Exercise Info

When you select an exercise, you will get to the corresponding info page. Here you will get information about the exercise, such as how to perform it, your record on the exercise, your current max, recomended number of sets and reps (usually 3 sets of 10 reps), which muscle groups the exercise targets and the resulting load score after finishing the recommended exercise. (See [load score](#load-score) for more info.)

## My page
My page is meand to give the user an overview over their high-scores and records, give an overview over their goals and activities, and help the user choose more suitable exercises depending on the load score of different muscle groups. I.e. a more personalized experience.

Here, you can also create your own workouts and create a workout schedule.


## Load score

Load score is a concept describing the accumulated load on a muscle over a periode of time. The load is meant to give a picture of how much load you have put on the muscle relative to your max. The score is calculated as follows:

$LS = \sum_i load_i/max \cdot 10/t_i, \forall t>0$,

where max is the users current max load on that number of repetitions, load_i is the load during exercise i and t_i is the number of days since exercise i.

The load can either be the weight, number of repetitions or duration.

***NOTE:** This formula is purely created for this purpose and has no scientific backing.*


