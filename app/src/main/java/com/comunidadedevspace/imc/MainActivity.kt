package com.comunidadedevspace.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // recuperar os componentes EditText
        //criar uma variavel e associar o componente de ui (EditText)
        // recuperar o botao da tela
        //colocar ação no botão

        val edtpeso = findViewById<TextInputEditText>(R.id.edt_peso)
        val edtaltura = findViewById<TextInputEditText>(R.id.edt_altura)

        val edtbutton = findViewById<Button>(R.id.edt_Calcular)

        edtbutton.setOnClickListener {
         val peso1 = edtpeso.text
            val altura1 = edtaltura.text

            println("willian" + altura1)

        }




    }
}