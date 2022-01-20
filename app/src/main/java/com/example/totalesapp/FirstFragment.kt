package com.example.totalesapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.totalesapp.model.TotalsViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val totalsViewModel = ViewModelProvider(requireActivity())[TotalsViewModel::class.java]
        totalsViewModel.getTotal().observe(viewLifecycleOwner, {
            //TODO update interface
            updateUI(it)
        })
        val btnInc =view.findViewById<Button>(R.id.button)
        btnInc.setOnClickListener {
            totalsViewModel.incrementTotal()
        }
    }

    private fun updateUI(total: Int){
        view?.findViewById<TextView>(R.id.textviewinfo)?.text = "Total ${total}"
    }


}