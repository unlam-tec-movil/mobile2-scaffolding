package ar.edu.unlam.mobile2.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ar.edu.unlam.mobile2.R


class PantallaVersus : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            pantallaInicio()

        }
    }

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @Preview
    @Composable
    fun pantallaInicio() {
        val scaffoldState = rememberScaffoldState()
        Scaffold(
            scaffoldState = scaffoldState,
            topBar = { topBarVersus() },
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black)
            )

            {
                Spacer(modifier = Modifier.padding(100.dp))
                ScanearQR(Modifier.align(Alignment.CenterHorizontally))
                Spacer(modifier = Modifier.padding(100.dp))
                MostrarQR(Modifier.align(Alignment.CenterHorizontally))

            }
        }
    }

    @Composable
    fun ScanearQR(modifier: Modifier) {
        Button(
            modifier = modifier
                .height(50.dp)
                .width(180.dp),
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF396AE9)),

            onClick = { /*aca cambiaria a la pantalla del juego solitario*/ }) {
            Text(text = "Scanear QR")

        }
    }
    @Composable
    fun MostrarQR(modifier: Modifier) {
        Button(
            modifier = modifier
                .height(50.dp)
                .width(180.dp),
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF396AE9)),

            onClick = {
                startActivity(Intent(this@PantallaVersus, PantallaQR::class.java))
                finish()
            }) {
            Text(text = "Mostrar QR")

        }
    }
    @Composable
    fun topBarVersus(
    ) {
        var showMenu by remember {
            mutableStateOf(false)
        }
        TopAppBar(
            title = { Text(text = "                        Partida Versus", modifier = Modifier, Color.White) },
            backgroundColor = Color.Black,
            actions = {
                IconButton(onClick = {   startActivity(Intent(this@PantallaVersus,
                    MainActivity::class.java))
                    finish()}) {
                    Image(painter = painterResource(id = R.drawable.ic_baseline_arrow_back_24),
                        contentDescription = "icono menu")
                }
                DropdownMenu(expanded = showMenu, onDismissRequest = { showMenu = false },
                    modifier = Modifier
                        .width(110.dp)
                        .background(color = Color(0xFF335ABD)),)
                {
                }
            }
        )
    }

}