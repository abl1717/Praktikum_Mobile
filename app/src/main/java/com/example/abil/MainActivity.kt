package com.example.abil

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.abil.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import com.example.abil.pertemuan_5.LimaActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val user = intent.getStringExtra("username")
        val pass = intent.getStringExtra("password")

        binding.txtUsername.text = user
        binding.txtPassword.setText(pass)

        binding.btnsnackbar.setOnClickListener {
            Snackbar.make(binding.root, "Halo ini snackbar", Snackbar.LENGTH_LONG)
                .setAction("Batal") {
                }
                .show()
        }
        binding.btnAlert.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Hapus data")
                .setMessage(
                    "Data yang dihapus tidak " +
                            "bisa dikembalikan."
                )
                .setNegativeButton("Batal", null)
                .setPositiveButton("Hapus") { dialog, _ ->
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    dialog.dismiss()
                }
                .setCancelable(false)
                .show()
        }
        binding.btnToLima.setOnClickListener {
            val intent = Intent(this, LimaActivity::class.java)
            startActivity(intent)
        }
    }
}