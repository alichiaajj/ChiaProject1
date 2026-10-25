package com.civicpulse.app.help

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
import com.civicpulse.app.databinding.FragmentHelpBinding

// Modul 7: halaman menggunakan Fragment dan View Binding.
class HelpFragment : Fragment() {
    // Binding hanya digunakan selama tampilan Fragment tersedia.
    private var _binding: FragmentHelpBinding? = null
    private val binding get() = _binding!!

    // Membuat layout halaman dan mengembalikan tampilan utamanya.
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHelpBinding.inflate(inflater, container, false)
        return binding.root
    }

    // Mengisi data dan memasang klik setelah tampilan selesai dibuat.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Custom Adapter menampilkan contoh permintaan bantuan.
        binding.list.adapter = HelpAdapter(requireContext(), helpList)
        binding.resultCount.text = "3 postingan • RW 04"
        // Fitur menambah postingan dan pencarian belum dibuat.
        binding.addHelp.isEnabled = false
        binding.search.isEnabled = false
    }

    // Modul 7: melepas binding ketika tampilan Fragment dihancurkan.
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
