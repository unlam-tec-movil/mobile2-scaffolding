package ar.edu.unlam.mobile2.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
                    Spacer(Modifier.size(30.dp))
                    BotonVolver()
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
            Text(text = "Jugador", color = Color.White, fontSize = 30.sp)
            Text(text = "Puntaje", color = Color.White, fontSize = 30.sp)
        }
        Spacer(Modifier.size(10.dp))
        MostrarRanking(ListaDeJuegosPrueba.juegos)
        /*Row (
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
        }*/
    }

    @Composable
    private fun Texto(texto: String) {
        Text(texto, color = Color.Black, fontSize = 30.sp)
    }

    @Composable
    private fun MostrarRanking(datos: MutableList<JuegoPrueba>) {
        LazyColumn (
            modifier = Modifier.fillMaxWidth(),
        ) {
            items(datos) { item -> ListItemRow(item) }
        }
    }

    @Composable
    private fun ListItemRow(item: JuegoPrueba) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
        ){
            Texto(item.jugador)
            Texto(item.puntaje.toString())
        }

        /*Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row {
                Text(item.jugador)
                Text(item.puntaje.toString())
            }

        }*/
    }

    @Composable
    private fun BotonVolver() {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = { finish()}, contentPadding = PaddingValues(10.dp)) {
                Text(text = "VOLVER", fontSize = 30.sp)
            }
        }
    }
}

class JuegoPrueba(
    val jugador: String,
    val puntaje: Int
)

object ListaDeJuegosPrueba {
    val juegos = mutableListOf<JuegoPrueba>()

    init {
        agregar(JuegoPrueba("Jugador 1", 100))
        agregar(JuegoPrueba("Jugador 2", 50))
        agregar(JuegoPrueba("Jugador 3", 70))
        agregar(JuegoPrueba("Jugador 4", 25))
        agregar(JuegoPrueba("Jugador 5", 30))
    }
    fun agregar(juego: JuegoPrueba) {
        juegos.add(juego)
    }

    fun ordenar() {
        juegos.sortedByDescending { it.puntaje }
    }
}