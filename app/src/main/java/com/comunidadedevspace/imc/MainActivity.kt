package com.comunidadedevspace.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // recuperar os componentes EditText
        // criar uma variavel e recuperar um componente de UI<EditText>
        // recuperar o Button
        // colocar ação no botão setOnClickListener
        // recuperar o texto digitado no edtPeso

        val edtPeso = findViewById<TextInputEditText>(R.id.edt_peso)
        val edtAltura = findViewById<TextInputEditText>(R.id.edt_altura)

        val btncalcular = findViewById<Button>(R.id.btn_calcular)

        btncalcular.setOnClickListener {
            val PesoStr: String = edtPeso.text.toString()
            val AlturaStr: String = edtAltura.text.toString()

        if(PesoStr == "" || AlturaStr == "") {
           // mostrar mensagem para o usuário
              Snackbar
              .make(
                 edtPeso,
                  "Preencha todos os campos",
                   Snackbar.LENGTH_LONG
                )
                .show()

        } else {
             val peso = PesoStr.toFloat()
             val altura = AlturaStr.toFloat()

             val alturaQ2 = altura * altura
             val resultado = peso / alturaQ2

            // NAVEGAR PARA A PROXIMA TELA
            // CRIAR O LAYOUT DA PROXIMA TELA
            // PASSAR DADOS (RESULT) PARA A PROXIMA TELA

            // para chamar a proxima tela vamos utilizar o Intent - classe do próprio android

             val intent = Intent (this, ResultActivity::class.java)
              intent.putExtra("KEY_IMC",resultado)
             startActivity(intent)

             println("Jorel ação do botão" + resultado)

            //Cores
            //EditText Bakground
            //Gradiente + icone + titulo + descrição

            }
        }
    }
}