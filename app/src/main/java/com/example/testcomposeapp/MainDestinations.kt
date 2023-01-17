package com.example.testcomposeapp


sealed class BottomNavItem(var title:String, var icon:Int, var screen_route:String){

    object First : BottomNavItem("First", R.drawable.ic_baseline_list_24,"first")
    object Second: BottomNavItem("Second",R.drawable.ic_baseline_local_florist_24,"second")
    object Third: BottomNavItem("Third",R.drawable.ic_baseline_monetization_on_24,"third")
}