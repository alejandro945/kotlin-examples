package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import com.example.myapplication.databinding.ActivityMainBinding


/**
 * Main Login Activity that use binding for resources attachments
 * and also provide a launcher for intents communications
 */
class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    /**
     * Principal Function that has the responsability of UI binding and intent
     * creation
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        var launcher = registerForActivityResult(StartActivityForResult(), ::onCallback)

        binding.button.setOnClickListener{
            var email = binding.editTextTextEmailAddress.text.toString()
            var password = binding.editTextTextPassword.text.toString()
            var text = "${email} : ${password}"
            Toast.makeText(this, text, Toast.LENGTH_LONG).show()
            val intent: Intent = Intent(this, CiscoActivity::class.java)
            intent.putExtra("email", email)
            launcher.launch(intent)
        }
    }


    /**
     * Function that receives new name from profile activity
     */
    private fun onCallback(result: ActivityResult){
        if(result.resultCode == RESULT_OK) {
            val name = result.data?.extras?.getString("name")
            Toast.makeText(this, name, Toast.LENGTH_LONG).show()
        }
    }
}