package com.comunidadedevspace.imc

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalculateScreen() {

    val weight = remember { mutableStateOf("") }
    val height = remember { mutableStateOf("") }

    Surface {
        Box(
            modifier = Modifier.fillMaxWidth()
                .height(20.dp)
                .background(Primary900)
        ) {}
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            TopCard(
                title = stringResource(id = R.string.calculadora_imc),
                description = stringResource(id = R.string.preencha_os_campos)
            )
            IMCInput(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 24.dp,
                        start = 16.dp,
                        end = 16.dp,
                        bottom = 12.dp
                    ),
                hint = stringResource(id = R.string.digite_seu_peso),
                icon = R.drawable.ic_weight
            ) {
                weight.value = it
            }
            IMCInput(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 16.dp,
                        end = 16.dp
                    ),
                hint = stringResource(id = R.string.digite_sua_altura),
                icon = R.drawable.ic_height
            ) {
                height.value = it
            }
            Spacer(modifier = Modifier.weight(1f))
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.BottomCenter
            ) {
                Button(modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Primary400
                    ),
                    onClick = {}
                ) {
                    Text(text = "Calcular")
                }
            }
        }
    }
}

@Composable
fun TopCard(
    title: String,
    description: String,
    modifier: Modifier = Modifier
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
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IMCInput(
    hint: String,
    @DrawableRes icon: Int,
    modifier: Modifier,
    onValueChange: (String) -> Unit
) {
    val text = remember { mutableStateOf( TextFieldValue("")) }
    OutlinedTextField(
        value = text.value,
        onValueChange = {
            text.value = it
            onValueChange(it.text)
        },
        modifier = modifier,
        singleLine = true,
        placeholder = { Text(text = hint) },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = InputGrey,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Password
        ),
        shape = RoundedCornerShape(50),
        trailingIcon = {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "Icon"
            )
        }
    )
}

@Composable
@Preview
fun CalculateScreenPreview() {
    IMCTheme {
        CalculateScreen()
    }
}