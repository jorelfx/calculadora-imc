package com.comunidadedevspace.imc

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@SuppressLint("DefaultLocale")
@Composable
fun TopCard(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    result: Float? = null,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Primary900,
                        Primary400
                    )
                ),
                shape = RoundedCornerShape(16.dp)
            )
    ) {
        Column {
            Icon(
                modifier = modifier
                    .padding(
                        start = 16.dp,
                        top = 48.dp
                    )
                    .size(32.dp),
                painter = painterResource(R.drawable.ic_weight),
                contentDescription = "Weight Icon",
                tint = Color.White
            )
            Text(
                modifier = modifier.padding(16.dp),
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color.White
            )
            Text(
                modifier = modifier.padding(
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 48.dp
                ),
                text = description,
                color = Color.White,
                fontSize = 14.sp
            )
            if(result != null) {
                Text(
                    modifier = modifier.padding(
                        start = 16.dp,
                        end = 16.dp,
                        bottom = 48.dp)
                        .fillMaxWidth(),
                    text = String.format("%.2f", result),
                    fontSize = 64.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}