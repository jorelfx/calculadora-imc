package com.comunidadedevspace.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result_main)

        val result = intent.getFloatExtra("bmi_result", 0.1f)

        val tvResultado = findViewById<TextView>(R.id.tv_resultado)
        val tvClassificacao = findViewById<TextView>(R.id.tv_classificacao)

        tvResultado.text = result.toString()

        val classificacao = if (result < 18.5f) {
            "ABAIXO DO PESO"
        } else if (result in 18.5f..24.9f) {
            "NORMAL"
        } else if (result in 25f..29.9f) {
            "SOBREPESO"
        } else if (result in 30f..39.9f) {
            "OBESIDADE"
        } else {
            "OBESIDADE GRAVE"
        }

        tvClassificacao.text = classificacao
    }
}