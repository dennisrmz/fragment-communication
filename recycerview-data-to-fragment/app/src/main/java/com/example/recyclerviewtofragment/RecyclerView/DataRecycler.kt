package com.example.recyclerviewtofragment.RecyclerView

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewtofragment.Adapter.DataAdapter
import com.example.recyclerviewtofragment.DataClass.StudentDataClass
import com.example.recyclerviewtofragment.Interface.ClickListener
import com.example.recyclerviewtofragment.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class DataRecycler : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null
    private lateinit var list: RecyclerView
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var adapter: DataAdapter
    private var studentsArray: ArrayList<StudentDataClass> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        addData()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_data_recycler, container, false)
        list = view.findViewById(R.id.recyclerView_data)
        layoutManager = LinearLayoutManager(context)
        adapter = DataAdapter(
            studentsArray,
            object :
                ClickListener {
                override fun dataPosition(position: Int) {
                    Toast.makeText(context, "Cell position $position", Toast.LENGTH_SHORT).show()
                    onCellPressed(studentsArray, position)
                }
            })
        list.layoutManager = layoutManager
        list.adapter = adapter

        adapter.notifyDataSetChanged()
        return view
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onCellPressed(data: ArrayList<StudentDataClass>, num: Int) {
        listener?.onFragmentRecyclerInteraction(data[num].name, data[num].date, data[num].subject, data[num].grade, data[num].age)
    }

    private fun addData() {
        studentsArray.add(0, StudentDataClass("Sofia", "22/11/0/19", "Social Studies", 8.0F, 16))
        studentsArray.add(1, StudentDataClass("Carlos", "18/11/2019", "Economy", 6.5F, 17))
        studentsArray.add(2, StudentDataClass("Valeria", "18/11/2019", "Grammar", 9.05F, 15))
        studentsArray.add(3, StudentDataClass("Jorge", "15/11/2019", "Bible", 4.0F, 16))
        studentsArray.add(4, StudentDataClass("Luis", "16/11/2019", "History", 7.5F, 17))
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentRecyclerInteraction(name: String, date: String, subject: String, grade: Float, age: Int)
    }

    companion object {
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DataRecycler().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
