package com.splicer.androidweatherapp.fragments

import android.Manifest
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.splicer.androidweatherapp.R
import com.splicer.androidweatherapp.databinding.FragmentMainBinding


class MainFragment : Fragment() {
    private lateinit var pLauncher: ActivityResultLauncher<String>
    private lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun permissionListener() {
        pLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) {


        }
    }

private fun checkPermission() {
    if(!isPermissionGranted(Manifest.permission.ACCESS_FINE_LOCATION)){
        permissionListener()
        pLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
    }
}

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}
