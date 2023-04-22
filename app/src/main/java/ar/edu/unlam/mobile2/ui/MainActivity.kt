package ar.edu.unlam.mobile2.ui

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.edu.unlam.mobile2.R
import ar.edu.unlam.mobile2.ui.ui.theme.Mobile2_ScaffoldingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Mobile2_ScaffoldingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    bienvenida()

                }
            }
        }
    }
}

@Composable
fun bienvenida() {
    /*Text(
        text = "Hola bienvenido a Nefly",
        color = Color.Black,
        fontSize = 40.sp,
        textAlign = TextAlign.Center,*/

    Column {

        Text(
            text = "Nefly",
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Black,
            fontSize = 40.sp,
            modifier = Modifier
                .padding(10.dp)
                .width(2000.dp),
            textAlign = TextAlign.Center,
            maxLines = 5,
            lineHeight = 50.sp
        )

        Text(
            text = "Seleccione Usuario",
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Thin,
            color = Color.Green,
            fontSize = 40.sp,
            modifier = Modifier
                .padding(40.dp)
                .width(2000.dp),
            textAlign = TextAlign.Center,
            maxLines = 5,
            lineHeight = 50.sp
        )

        val borderWidth = 4.dp
        Image(
            painter = painterResource(id = R.drawable.usuario1),
            contentDescription = stringResource(id = R.string.usuario_uno),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(120.dp)
                .padding(10.dp)
                .align(alignment = CenterHorizontally)
                .border(
                    BorderStroke(borderWidth, Color.Yellow),
                    CircleShape
                )

                .padding(borderWidth)
                .clip(CircleShape)

        )
        Text(
            text = "Usuario1",
            fontSize = 20.sp,
            color = Color.Black,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Image(
            painter = painterResource(id = R.drawable.usuario2),
            contentDescription = stringResource(id = R.string.usuario_dos),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(120.dp)
                .padding(10.dp)
                .align(alignment = CenterHorizontally)
                .border(
                    BorderStroke(borderWidth, Color.Yellow),
                    CircleShape
                )

                .padding(borderWidth)
                .clip(CircleShape)


        )
        Text(
            text = "Usuario2",
            fontSize = 20.sp,
            color = Color.Black,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Image(
            painter = painterResource(id = R.drawable.usuario3),
            contentDescription = stringResource(id = R.string.usuario_tres),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(120.dp)
                .padding(10.dp)
                .align(alignment = CenterHorizontally)
                .border(
                    BorderStroke(borderWidth, Color.Yellow),
                    CircleShape
                )

                .padding(borderWidth)
                .clip(CircleShape)


        )
        Text(
            text = "Usuario3",
            fontSize = 20.sp,
            color = Color.Black,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

    }

}







@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Mobile2_ScaffoldingTheme {
        bienvenida()
    }
}