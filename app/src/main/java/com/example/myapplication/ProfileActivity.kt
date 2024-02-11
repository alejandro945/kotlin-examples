package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {


    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val email: String? = intent?.extras?.getString("email")

        email?.let {
            binding.profileText.text = it
        }

        binding.editButton.setOnClickListener{
            if(binding.nameEditText.text.toString() !== ""){
                val intent = Intent()
                intent.putExtra("name", binding.nameEditText.text.toString())
                setResult(RESULT_OK, intent)
                finish()
            }else{
                Toast.makeText(this, "Nwe name is empty", Toast.LENGTH_LONG).show()
            }
        }
    }
}