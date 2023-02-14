package com.example.dogglerapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.dogglerapp.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        SecondFragmentArgs.fromBundle(requireArguments()).selection.let {
            binding.textView2.text = it
            binding.rvdog.layoutManager = when(it){
                "Horizontal" -> LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
                "Grid" -> GridLayoutManager(requireContext(),2)
                "Staggered" -> StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
                else -> LinearLayoutManager(requireContext())
            }
            binding.rvdog.adapter = PlanetAdapter(requireActivity(),resources.getStringArray(R.array.planets))
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}