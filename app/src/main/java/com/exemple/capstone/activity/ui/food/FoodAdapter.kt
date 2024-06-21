//package com.exemple.capstone.ui.food
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.exemple.capstone.databinding.ItemFoodBinding
//
//
//class FoodAdapter(private var foodItems: List<Food>) :
//    RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {
//
//    class FoodViewHolder(val binding: ItemFoodBinding) : RecyclerView.ViewHolder(binding.root)
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
//        val binding = ItemFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return FoodViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
//        val food = foodItems[position]
//        holder.binding.apply {
//            // Bind data to the layout here
//            foodNameTextView.text = food.name
//            foodDescriptionTextView.text = food.description
//            // ... other data bindings based on your Food model
//        }
//    }
//
//    override fun getItemCount(): Int {
//        return foodItems.size
//    }
//
//    fun updateFoodItems(newFoodItems: List<Food>) {
//        foodItems = newFoodItems
//        notifyDataSetChanged()
//    }
//}//package com.exemple.capstone.activity.ui.food
////
////import android.view.LayoutInflater
////import android.view.View
////import android.view.ViewGroup
////import android.widget.TextView
////import androidx.recyclerview.widget.RecyclerView
////import com.exemple.capstone.R
////
////class FoodAdapter(private val foodList: List<String>) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {
////
////    // ViewHolder class
////    class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
////        val foodNameTextView: TextView = itemView.findViewById(
////            R.id.foodNameTextView)
////    }
////
////    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
////        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_detail, parent, false)
////        return FoodViewHolder(itemView)
////    }
////
////    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
////        val foodItem = foodList[position]
////        holder.foodNameTextView.text = foodItem
////    }
////
////    override fun getItemCount(): Int {
////        return foodList.size
////    }
////}
