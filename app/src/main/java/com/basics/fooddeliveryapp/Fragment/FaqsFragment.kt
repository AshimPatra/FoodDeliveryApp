package com.basics.fooddeliveryapp.Fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.RelativeLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.basics.fooddeliveryapp.Adapter.FaqsAdapter
import com.basics.fooddeliveryapp.Adapter.RestaurantMenuAdapter
import com.basics.fooddeliveryapp.R
import com.basics.fooddeliveryapp.model.FrequentQuestion
import com.basics.fooddeliveryapp.model.RestaurantMenu

class FaqsFragment : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var layoutManager: LinearLayoutManager
    lateinit var restaurantMenuAdapter: RestaurantMenuAdapter
    lateinit var progressLayout: RelativeLayout
    lateinit var progressBar: ProgressBar
    var faqsListInfo = arrayListOf<FrequentQuestion>()

    val questionList = arrayListOf<String>(
        "Q1. I don't remember my password?",
        "Q2. what are your delivery hours?",
        "Q3. How much time it's takes to deliver the order?",
        "Q4. Do you Support bulk orders?"

    )
    val answerList = arrayListOf<String>(
        "A1. You have already created an account but you can't remember your password? Click on 'Login/Sign Up' at the top of the page. Then click on 'Forgot Password?'. Fill out your phone number and a password recovery will be sent to you by phone..",
        "A2.  Our delivery hour is from 10:00 AM to 08:00 PM.",
        "A3. Generally it takes between 45 minutes to 1 hour time to deliver the order. Due to long distance or heavy traffic, delivery might take few extra minutes.",
        "A4. In order to provide all customers with a great selection and to ensure on-time delivery of your meal, we request you to order bulk quantity at least 24 hours in advance."
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_faqs, container, false)

        recyclerView = view.findViewById(R.id.faqsRecyclerView)
        layoutManager = LinearLayoutManager(activity as Context)
        progressLayout = view.findViewById(R.id.progressLayout)
        progressBar = view.findViewById(R.id.progressBar)

        progressLayout.visibility = View.VISIBLE
        progressBar.visibility = View.VISIBLE

        for (i in 0 until questionList.size) {
            val frequentQuestion = FrequentQuestion(
                questionList[i],
                answerList[i]
            )
            faqsListInfo.add(frequentQuestion)
        }
        progressLayout.visibility = View.GONE
        progressBar.visibility = View.GONE


        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = FaqsAdapter(activity as Context, faqsListInfo)
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                DividerItemDecoration.VERTICAL
            )
        )






        return view
    }

}
