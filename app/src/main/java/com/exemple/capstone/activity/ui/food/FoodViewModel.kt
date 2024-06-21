//package com.exemple.capstone.activity.ui.food
//
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//class FoodViewModel : ViewModel() {
//
//    private val _text = MutableLiveData<String>().apply {
//        value = "This is home Fragment"
//    }
//    val text: LiveData<String> = _text
//}
////
////class FoodViewModel : ViewModel() {
////
////    private val _foodItems = MutableLiveData<List<Food>>()
////    val foodItems: LiveData<List<Food>> = _foodItems
////
////    init {
////        // Fetch food data from a data source (API, database, etc.)
////        fetchFoodData()
////    }
////
////    private fun fetchFoodData() {
////        // Example implementation using a mock data source
////        val mockFoodItems = listOf(
////            Food("Pizza", "Delicious Italian pizza with various toppings"),
////            Food("Burger", "Juicy beef burger with all the fixings"),
////            Food("Sushi", "Fresh and flavorful sushi rolls"),
////            // Add more food items here
////        )
////        _foodItems.value = mockFoodItems
////    }
