package com.mirfanrafif.resepku

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.mirfanrafif.resepku.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        binding.btnSubmit.setOnClickListener {
            ambilData()
        }
    }

    private fun ambilData() {
        val nama = binding.edtNama.text.toString()
        if(nama.isBlank()) {
            Snackbar.make(binding.root, "Harap masukkan nama", Snackbar.LENGTH_SHORT).show()
            return
        }

        val telepon = binding.edtNomorHp.text.toString()
        if(telepon.isBlank()) {
            Snackbar.make(binding.root, "Harap masukkan telepon", Snackbar.LENGTH_SHORT).show()
            return
        }

        val username = binding.edtUsername.text.toString()
        if(username.isBlank()) {
            Snackbar.make(binding.root, "Harap masukkan username", Snackbar.LENGTH_SHORT).show()
            return
        }

        val password = binding.edtPassword.text.toString()
        if(password.isBlank()) {
            Snackbar.make(binding.root, "Harap masukkan nama", Snackbar.LENGTH_SHORT).show()
            return
        }

        val confPassword = binding.edtConfPassword.text.toString()
        if(confPassword.isBlank()) {
            Snackbar.make(binding.root, "Harap masukkan password", Snackbar.LENGTH_SHORT).show()
            return
        }
        if(confPassword != password) {
            Snackbar.make(binding.root, "Password tidak sama", Snackbar.LENGTH_SHORT).show()
            return
        }

        val jenisKelamin = when(binding.rgJekel.checkedRadioButtonId) {
            binding.rbPria.id -> "Pria"
            binding.rbWanita.id -> "Wanita"
            else -> {
                Snackbar.make(binding.root, "Pilih jenis kelamin", Snackbar.LENGTH_SHORT).show()
                return
            }
        }

        val setuju = binding.chkSetuju.isChecked
        if(!setuju) {
            Snackbar.make(binding.root, "Tolong anda setuju", Snackbar.LENGTH_SHORT).show()
            return
        }

        val user = User(nama, username, telepon, password, jenisKelamin)
        binding.isiDaftar.text = user.toString()
    }
}