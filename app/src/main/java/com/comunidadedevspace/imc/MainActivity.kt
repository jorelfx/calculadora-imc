package com.comunidadedevspace.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
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
            val pesoStr: String = edtpeso.text.toString()
            val alturaStr: String = edtaltura.text.toString()

                    if (pesoStr == ""|| alturaStr == "") {
                        // mostrar mensagem para o usuario
                        Snackbar.make(
                            edtpeso,
                            "preencha todos os campos",
                            Snackbar.LENGTH_LONG
                        ).show()
                    } else {
                        val peso = pesoStr.toFloat()
                        val altura = alturaStr.toFloat()

                        val alturaQ2 = altura * altura
                        val resultado = peso / alturaQ2

                        // navegar para proxima tela
                        // criar layout da proxima tela
                        //passar dados para proxima tela (resultado)

                        val intent = Intent(this, ResultActivity::class.java)
                        intent.putExtra(KEY_RESULT_IMC, resultado)
                        startActivity(intent)







                        println("willian ação do botão" + resultado)
                    }}}}




















