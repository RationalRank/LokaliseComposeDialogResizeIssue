package com.example.dialogresizingissue.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.dialogresizingissue.LandscapeActivity
import com.example.dialogresizingissue.R
import com.example.dialogresizingissue.TabbedActivity
import com.example.dialogresizingissue.databinding.FragmentTabbedBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

/**
 * A placeholder fragment containing a simple view.
 */
class PlaceholderFragment : Fragment() {

    private lateinit var pageViewModel: PageViewModel
private var _binding: FragmentTabbedBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageViewModel = ViewModelProvider(this).get(PageViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

      _binding = FragmentTabbedBinding.inflate(inflater, container, false)
      val root = binding.root

        val textView: TextView = binding.sectionLabel
        binding.buttonGoToLandscape.setOnClickListener {
            startActivityForResult(
                Intent(requireContext(), LandscapeActivity::class.java),
                100
            )
        }
        pageViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 100) {
            val orientation = resources.configuration.orientation
            Toast.makeText(
                requireContext(),
                "Orientation is $orientation",
                Toast.LENGTH_SHORT
            ).show()
            MaterialAlertDialogBuilder(requireContext())
                .setMessage("Successfully returned from Landscape. Hurrayyy!!! You can proceed dismissing this dialog now")
                .setPositiveButton("Okay") { dialogInterface, _ ->
                    dialogInterface.dismiss()
                }
                .show()
        }
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): PlaceholderFragment {
            return PlaceholderFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}