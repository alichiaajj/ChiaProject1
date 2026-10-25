package com.civicpulse.app.local

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.civicpulse.app.*
import com.civicpulse.app.databinding.FragmentLocalBinding

// Modul 7: halaman menggunakan Fragment dan View Binding.
class LocalFragment : Fragment() {
    // Binding hanya digunakan selama tampilan Fragment tersedia.
    private var _binding: FragmentLocalBinding? = null
    private val binding get() = _binding!!

    // Membuat layout halaman dan mengembalikan tampilan utamanya.
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentLocalBinding.inflate(inflater, container, false)
        return binding.root
    }

    // Mengisi data dan memasang klik setelah tampilan selesai dibuat.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Daftar tempat memakai Custom Adapter; peta hanya gambar statis.
        binding.list.adapter = PlaceAdapter(requireContext(), placeList)
        binding.resultCount.text = "4 lokasi • RW 04"
        binding.search.isEnabled = false
    }

    // Modul 7: melepas binding ketika tampilan Fragment dihancurkan.
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
