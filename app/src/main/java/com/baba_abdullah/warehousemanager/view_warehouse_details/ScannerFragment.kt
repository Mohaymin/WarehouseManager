package com.baba_abdullah.warehousemanager.view_warehouse_details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.baba_abdullah.warehousemanager.databinding.FragmentScannerBinding

class ScannerFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding = FragmentScannerBinding.inflate(inflater, container, false)
        return binding.root
//        return inflater.inflate(R.layout.fragment_scanner, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ScannerFragment().apply {
                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
                }
            }
    }
}