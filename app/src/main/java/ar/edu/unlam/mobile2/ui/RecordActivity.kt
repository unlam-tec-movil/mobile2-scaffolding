package ar.edu.unlam.mobile2.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.edu.unlam.mobile2.R
import ar.edu.unlam.mobile2.ui.ui.theme.Mobile2_ScaffoldingTheme
import ar.edu.unlam.mobile2.ui.ui.theme.BackgroundColor
import ar.edu.unlam.mobile2.ui.ui.theme.TopBarColor

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
                color = BackgroundColor
            ) {
                Column(
                    modifier = Modifier.fillMaxSize()
                )
                {
                    TopBar()
                    Spacer(Modifier.size(5.dp))
                    Ranking()
                    Spacer(Modifier.size(30.dp))
                }
            }
        }
    }

    @Composable
    private fun TopBar() {
        Row(
            modifier = Modifier
                .background(TopBarColor)
                .fillMaxWidth()
                .height(36.dp)
                .wrapContentHeight()
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_close_24),
                contentDescription = "",
                modifier = Modifier.clickable(enabled = true, onClick = {
                    irAInicio()
                    onStop()
                })
            )
        }
    }

    @Composable
    private fun Ranking() {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .background(TopBarColor),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(text = "Jugador", color = Color.White, fontSize = 30.sp)
            Text(text = "Puntaje", color = Color.White, fontSize = 30.sp)
        }
        Spacer(Modifier.size(10.dp))
        MostrarRanking(ListaDeJuegosPrueba.ordenar() as MutableList<JuegoPrueba>)
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
    }

    private fun irAInicio() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
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
        agregar(JuegoPrueba("Jugador 6", 10))
        agregar(JuegoPrueba("Jugador 7", 30))
        agregar(JuegoPrueba("Jugador 8", 30))
        agregar(JuegoPrueba("Jugador 9", 10))
        agregar(JuegoPrueba("Jugador 10", 30))
        agregar(JuegoPrueba("Jugador 11", 30))
        agregar(JuegoPrueba("Jugador 12", 15))
        agregar(JuegoPrueba("Jugador 13", 200))
        agregar(JuegoPrueba("Jugador 14", 390))
        agregar(JuegoPrueba("Jugador 15", 5))
    }

    fun agregar(juego: JuegoPrueba) {
        juegos.add(juego)
    }

    fun ordenar(): List<JuegoPrueba> {
        return juegos.sortedByDescending { it.puntaje }
    }
}