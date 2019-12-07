package com.example.recyclerviewtofragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.recyclerviewtofragment.Fragment.DetailFragment
import com.example.recyclerviewtofragment.RecyclerView.DataRecycler

class MainActivity : AppCompatActivity(), DataRecycler.OnFragmentInteractionListener, DetailFragment.OnFragmentRecyclerInteractionListener {

    private val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showFragment(DataRecycler())
    }

    private fun showFragment(name: Fragment) {
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.fragment_container, name)
        transaction.commit()
    }

    private fun showDetailFragment(name: Fragment) {
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.fragment_container, name)
        transaction.addToBackStack("$name")
        transaction.commit()
    }

    override fun onFragmentRecyclerInteraction(name: String, date: String, subject: String, grade: Float, age: Int) {
        showDetailFragment(DetailFragment.newInstance(name, age.toString(), subject, grade.toString(), date))
    }

    override fun onFragmentDetailInteraction() {}
}
