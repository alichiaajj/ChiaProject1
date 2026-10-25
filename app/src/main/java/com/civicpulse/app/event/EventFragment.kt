package com.civicpulse.app.event

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
import com.civicpulse.app.databinding.FragmentEventBinding

// Modul 7: halaman menggunakan Fragment dan View Binding.
class EventFragment : Fragment() {
    // Binding hanya digunakan selama tampilan Fragment tersedia.
    private var _binding: FragmentEventBinding? = null
    private val binding get() = _binding!!

    // Membuat layout halaman dan mengembalikan tampilan utamanya.
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentEventBinding.inflate(inflater, container, false)
        return binding.root
    }

    // Mengisi data dan memasang klik setelah tampilan selesai dibuat.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Custom Adapter menampilkan data tetap, tanpa pendaftaran event.
        binding.list.adapter = EventAdapter(requireContext(), eventList)
        binding.resultCount.text = "4 kegiatan • RW 04"
        // Kotak pencarian masih berupa tampilan desain.
        binding.search.isEnabled = false
    }

    // Modul 7: melepas binding ketika tampilan Fragment dihancurkan.
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
