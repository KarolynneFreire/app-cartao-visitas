package com.example.cardvisits.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.cardvisits.App
import com.example.cardvisits.R
import com.example.cardvisits.data.BusinessCard
import com.example.cardvisits.databinding.ActivityAddBusinessCardBinding

class AddBusinessCardActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAddBusinessCardBinding.inflate(layoutInflater) }

    private val mainViewModel: MainViewModel by viewModels{
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListeners()
    }
    private fun insertListeners(){
        binding.btnClose.setOnClickListener{
            finish()
        }

        binding.btnConfirme.setOnClickListener{
            val businessCard = BusinessCard(
                nome = binding.tilNome.editText?.text.toString(),
                telefone = binding.tilTelefone.editText?.text.toString(),
                email = binding.tilEmail.editText?.text.toString(),
                empresa = binding.tilNomeEmpresa.editText?.text.toString(),
                fundoPersonalizado = binding.tilCor.editText?.text.toString(),
            )
            mainViewModel.insert(businessCard)
            Toast.makeText( this, R.string.label_show_success,Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}