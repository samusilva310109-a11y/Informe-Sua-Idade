package com.example.informesuaidade

import android.os.Bundle
import androidx.compose.material3.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.drawable.toDrawable
import com.example.informesuaidade.ui.theme.InformeSuaIdadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InformeSuaIdadeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                        ,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    )
                    {
                        TitleContainer()
                        ButtonsContainer()
                    }
                }
            }
        }
    }
}

@Composable
fun TitleContainer(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Qual a sua Idade?",
            fontSize = 24.sp,
            color = Color(0xFF4857AF)
        )

        Text(
            text = "Aperte os botões para informar a sua idade",
            fontSize = 14.sp
        )
    }
}

@Composable
fun ButtonsContainer(modifier: Modifier = Modifier){
    var idade by remember {
        mutableStateOf(0)
    }

    var menorOrMaior by remember {
        mutableStateOf("")
    }

    val buttonsColors = Color(0xFF4A59AF)

    Column(
        modifier = modifier
            .size(180.dp)
        ,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {

        Spacer(Modifier.size(20.dp))

        Text(
            text = "${idade}",
            fontSize = 45.sp
        )

        Spacer(Modifier.size(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        )
        {
            Button(
                modifier = Modifier.size(80.dp),
                onClick = {
                    if (idade > 0)
                        idade--
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = buttonsColors,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(15.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.baseline_remove),
                    contentDescription = "Botão de subtrair idade"
                )
            }

            Button(
                modifier = Modifier.size(80.dp),
                onClick = {
                    if (idade < 180)
                        idade ++
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = buttonsColors,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(15.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Botão de adicionar idade"
                )
            }
        }
    }

    Spacer(Modifier.size(20.dp))

    if (idade < 18)
        menorOrMaior = "Menor"
    else
        menorOrMaior = "Maior"

    Text(
        text = "Você é ${menorOrMaior.uppercase()} de idade",
        fontSize = 20.sp,
        color = buttonsColors,
        fontWeight = FontWeight.Bold
    )
}