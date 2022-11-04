package com.example.webviewplayground

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.example.webviewplayground.databinding.FragmentWebviewBinding
import com.example.webviewplayground.viewModel.WebViewModel
import java.util.Observer

class WebViewFragment : Fragment() {

    private var _binding: FragmentWebviewBinding? = null
    private val binding get() = _binding!!

    private val sharedViewModel: WebViewModel by activityViewModels()

    val args: WebViewFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWebviewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedViewModel.url.observe(viewLifecycleOwner, androidx.lifecycle.Observer { urlString ->
            binding.webview.loadUrl(urlString)
        })
    }
}