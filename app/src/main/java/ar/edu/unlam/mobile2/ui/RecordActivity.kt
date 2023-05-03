package ar.edu.unlam.mobile2.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.edu.unlam.mobile2.ui.ui.theme.Mobile2_ScaffoldingTheme
import ar.edu.unlam.mobile2.ui.ui.theme.OrangeLight
import ar.edu.unlam.mobile2.ui.ui.theme.VioletDark

class RecordActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            content()
        }
    }

    @Preview
    @Composable
    private fun content() {
        Mobile2_ScaffoldingTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = OrangeLight
            ) {
                Column(
                    modifier = Modifier.fillMaxSize()
                )
                {
                    Ranking()
                }

            }
        }
    }

    @Composable
    private fun Ranking() {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .background(VioletDark),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(text = "Puesto", color = Color.White)
            Text(text = "Jugador", color = Color.White)
            Text(text = "Puntaje", color = Color.White)
        }
        Spacer(Modifier.size(10.dp))
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Texto(texto = "1")
            Texto(texto = "Jugador")
            Texto(texto = "100")
        }
        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Texto(texto = "2")
            Texto(texto = "Jugador")
            Texto(texto = "100")
        }
        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Texto(texto = "3")
            Texto(texto = "Jugador")
            Texto(texto = "100")
        }
        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Texto(texto = "4")
            Texto(texto = "Jugador")
            Texto(texto = "100")
        }
        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Texto(texto = "5")
            Texto(texto = "Jugador")
            Texto(texto = "100")
        }
        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Texto(texto = "6")
            Texto(texto = "Jugador")
            Texto(texto = "100")
        }
        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Texto(texto = "7")
            Texto(texto = "Jugador")
            Texto(texto = "100")
        }
        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Texto(texto = "8")
            Texto(texto = "Jugador")
            Texto(texto = "100")
        }
        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Texto(texto = "9")
            Texto(texto = "Jugador")
            Texto(texto = "100")
        }
        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Texto(texto = "10")
            Texto(texto = "Jugador")
            Texto(texto = "100")
        }
    }

    @Composable
    private fun Texto(texto: String) {
        Text(texto, color = Color.Black, fontSize = 30.sp)
    }

    @Composable()
    private fun BotonVolver() {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = { finish()}, contentPadding = PaddingValues(10.dp)) {
                Text(text = "Volver")
            }
        }
    }
}
