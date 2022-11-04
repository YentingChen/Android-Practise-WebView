package com.example.webviewplayground

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.webviewplayground.databinding.FragmentFillingUrlBinding
import com.example.webviewplayground.viewModel.WebViewModel

class FillingURLFragment : Fragment() {
    private var _binding: FragmentFillingUrlBinding? = null
    private val binding get() = _binding!!

    lateinit var textView: TextView

    private val sharedViewModel: WebViewModel by activityViewModels()

    val defaulURL = "https://www.vouchercodes.co.uk/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFillingUrlBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            viewModel = sharedViewModel
        }

        binding.buttonWebView.setOnClickListener {
            val direction = FillingURLFragmentDirections.actionFillingURLFragmentToWebViewFragment(textView.text.toString())
            sharedViewModel.setUrl(textView.text.toString())
            findNavController().navigate(direction)
        }

        binding.buttonBrowser.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse(textView.text.toString())
            startActivity(openURL)
        }

        textView = binding.editTextInput
        textView.text = defaulURL
    }

}