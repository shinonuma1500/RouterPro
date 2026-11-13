package com.routerpro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Orange = Color(0xFFFF8500)
private val Dark = Color(0xFF121212)
private val CardDark = Color(0xFF222222)
private val White = Color.White

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RouterProApp()
        }
    }
}

@Composable
fun RouterProApp() {
    var address by remember { mutableStateOf("") }
    var stops by remember { mutableStateOf(listOf<String>()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Dark)
            .padding(20.dp)
    ) {
        Text(
            "ROUTERPRO",
            color = Orange,
            fontSize = 30.sp,
            fontWeight = FontWeight.Black
        )

        Text(
            "PLANIFICA. OPTIMIZA. ENTREGA.",
            color = White,
            fontSize = 11.sp
        )

        Spacer(Modifier.height(28.dp))

        Text(
            "Mi ruta de reparto",
            color = White,
            fontSize = 23.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(18.dp))

        OutlinedTextField(
            value = address,
            onValueChange = { address = it },
            label = { Text("Introduce una dirección") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = White,
                unfocusedTextColor = White,
                focusedBorderColor = Orange,
                focusedLabelColor = Orange,
                unfocusedLabelColor = White
            )
        )

        Spacer(Modifier.height(12.dp))

        Button(
            onClick = {
                if (address.isNotBlank()) {
                    stops = stops + address.trim()
                    address = ""
                }
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Orange,
                contentColor = Dark
            )
        ) {
            Text("＋ AÑADIR PARADA", fontWeight = FontWeight.Bold)
        }

        Spacer(Modifier.height(24.dp))

        Text(
            "MIS ENTREGAS (${stops.size})",
            color = Orange,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(12.dp))

        stops.forEachIndexed { index, stop ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                colors = CardDefaults.cardColors(
                    containerColor = CardDark
                )
            ) {
                Text(
                    "${index + 1}.  $stop",
                    color = White,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }

        Spacer(Modifier.weight(1f))

        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Orange,
                contentColor = Dark
            ),
            shape = RoundedCornerShape(14.dp)
        ) {
            Text(
                "OPTIMIZAR MI RUTA",
                fontWeight = FontWeight.Black
            )
        }
    }
}
