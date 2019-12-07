package com.example.recyclerviewtofragment.Fragment

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.recyclerviewtofragment.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "name"
private const val ARG_PARAM2 = "age"
private const val ARG_PARAM3 = "subject"
private const val ARG_PARAM4 = "grade"
private const val ARG_PARAM5 = "date"

class DetailFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var param3: String? = null
    private var param4: String? = null
    private var param5: String? = null
    private var listener: OnFragmentRecyclerInteractionListener? = null
    private lateinit var name: TextView
    private lateinit var age: TextView
    private lateinit var subject: TextView
    private lateinit var grade: TextView
    private lateinit var date: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
            param3 = it.getString(ARG_PARAM3)
            param4 = it.getString(ARG_PARAM4)
            param5 = it.getString(ARG_PARAM5)
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        name = view.findViewById(R.id.textView_name)
        age = view.findViewById(R.id.textView_age)
        subject= view.findViewById(R.id.textView_subject)
        grade = view.findViewById(R.id.textView_grade)
        date = view.findViewById(R.id.textView_date)

        name.text = "Student: $param1"
        age.text  = "Age: $param2"
        subject.text = "Subject: $param3"
        grade.text = "Grade: $param4"
        date.text = "Date: $param5"

        return view
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed() {
        listener?.onFragmentDetailInteraction()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentRecyclerInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnFragmentRecyclerInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentDetailInteraction()
    }

    companion object {
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String, param3: String, param4:String, param5: String) =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                    putString(ARG_PARAM3, param3)
                    putString(ARG_PARAM4, param4)
                    putString(ARG_PARAM5, param5)

                    Log.d("DATA_STATUS", "DATA: $param1, $param2, $param3, $param4, $param5")
                }
            }
    }
}
