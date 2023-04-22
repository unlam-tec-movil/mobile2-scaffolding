package ar.edu.unlam.mobile2.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import ar.edu.unlam.mobile2.R
import ar.edu.unlam.mobile2.ui.ui.theme.Mobile2_ScaffoldingTheme

class JuegoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Mobile2_ScaffoldingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Row {
                        texto("¿Cuál tiene más capítulos")
                        Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "Opción 1")
                        texto("VS")
                        Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "Opción 2")
                        texto("0")
                    }

                }
            }
        }
    }
}

@Composable
fun texto(texto: String) {
    Text(texto)
}