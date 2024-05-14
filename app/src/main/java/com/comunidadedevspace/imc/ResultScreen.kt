package com.comunidadedevspace.imc

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ResultScreen(
    result: Float
) {

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

    Surface {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
                .background(Primary900)
        ) {}
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            TopCard(
                title = stringResource(id = R.string.calculadora_imc),
                description = stringResource(id = R.string.confira_o_resultado),
                result = result
            )
            Spacer(modifier = Modifier.weight(0.5f))
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text(
                        text = stringResource(id = R.string.classificacao_imc),
                        color = Color.Gray,
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = classificacao,
                        fontSize = 24.sp,
                        color = Primary900,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}