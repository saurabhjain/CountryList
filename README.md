# CountryList Android App
This project follows a MVVM Architecture.

## The Project

This project fetches a list of countries in JSON format from this [endpoint](https://gist.githubusercontent.com/peymano-wmt/32dcb892b06648910ddd40406e37fdab/raw/db25946fd77c5873b0303b858e861ce724e0dcd0/countries.json) and displays all the countries in a RecyclerView ordered by the position they appear in the JSON. In each table cell, shows the country's "name", "region", "code" and "capital" in the following format:

![Screenshot_20240311_175518 copy](https://github.com/saurabhjain/WalmartCountryList/assets/896910/7ab449be-cf15-4899-b847-437f88a5f151)

## Application Video
[Application video link](https://drive.google.com/file/d/1bSIXr3E_8jGEuBDwwSo1EKv7caMQu66k/view?usp=drive_link)

## Project Requirement
If after cloning the project doesn't runs please check the Android Studio version you are trying to run it on, this project uses AGP 8.2.2 and in order to run the project you will need to have [Android Studio Hedgehog or above](https://developer.android.com/build/releases/gradle-plugin#android_gradle_plugin_and_android_studio_compatibility)

## APIs Used
* Android [DiffUtil](https://developer.android.com/reference/androidx/recyclerview/widget/DiffUtil) for optimization
* Android [Fragment](https://developer.android.com/reference/android/app/Fragment)
* Android ListAdapter class and its [submitList API](https://developer.android.com/reference/androidx/recyclerview/widget/ListAdapter#submitList(java.util.List%3CT%3E))
* Uses [Coroutines](https://developer.android.com/kotlin/coroutines)
* Uses [ViewBinding](https://developer.android.com/topic/libraries/view-binding)
* This project also aims to use flat view hierarchy to improve rendering performance by using [Constraint Layout](https://developer.android.com/develop/ui/views/layout/constraint-layout) over something like [Relative layout](https://developer.android.com/develop/ui/views/layout/relative) which can result in multiple passes for view construction. Example: [fragment_countries.xml](https://github.com/saurabhjain/CountryList/blob/main/app/src/main/res/layout/fragment_countries.xml) and [list_item.xml](https://github.com/saurabhjain/CountryList/blob/main/app/src/main/res/layout/list_item.xml)


## Features Supported

* The user is able to scroll through the entire list of countries
* Application supports device rotation and maintains the UI state and data upon Activity recreation

## Error Handling
* Application catches the appropriate network exceptions and lets the user know on the UI if an exception has occured
* Application informs the user upfront if the device does not have a network connection

