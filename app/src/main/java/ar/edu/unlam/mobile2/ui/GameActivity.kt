package ar.edu.unlam.mobile2.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.ui.AppBarConfiguration
import ar.edu.unlam.mobile2.R
import ar.edu.unlam.mobile2.databinding.ActivityMainBinding
import ar.edu.unlam.mobile2.ui.ui.theme.Mobile2_ScaffoldingTheme
import ar.edu.unlam.mobile2.ui.ui.theme.VioletDark
import ar.edu.unlam.mobile2.ui.ui.theme.OrangeLight

class GameActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    var puntaje = 0
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
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = OrangeLight
            ) {
                Column(
                    modifier = Modifier.fillMaxSize())
                {
                    TopBar()
                    Game()
                }//Column

            }//Surface
    }
}
    @Preview(showBackground = true, name = "Top Bar")
    @Composable
    private fun TopBar() {
        Row(
            modifier = Modifier
                .background(VioletDark)
                .fillMaxWidth()
                .height(36.dp)
                .wrapContentHeight()
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_favorite_24),
                contentDescription = "",
                modifier = Modifier.padding(2.dp,0.dp),
                alignment = Alignment.TopStart
            )
            Image(
                painter = painterResource(id = R.drawable.baseline_favorite_24),
                contentDescription = "",
                //Modifier.border(width = 1.dp, color = Color.Black, shape = CircleShape)
            )
            Image(
                painter = painterResource(id = R.drawable.baseline_favorite_24),
                contentDescription = ""
            )
            Image(
                painter = painterResource(id = R.drawable.baseline_close_24),
                contentDescription = "",
                //alignment = Alignment.
            )
        }
    }

    @Composable
    fun Game() {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Texto("Pregunta")
            Image(
                painter = painterResource(id = R.drawable.baseline_favorite_24), modifier = Modifier.width(100.dp).height(100.dp),
                contentDescription = ""
            )
            Text("VS", color = Color.Red)
            Image(
                painter = painterResource(id = R.drawable.baseline_favorite_24), modifier = Modifier.width(100.dp).height(100.dp),
                contentDescription = ""
            )
            Row {
                Text(text = puntaje.toString(),  modifier =
                Modifier
                    .background(Color.Red, RectangleShape)
                    .padding(10.dp), Color.White, textAlign = TextAlign.Center)
                Image(painter = painterResource(id = R.drawable.baseline_replay_24), contentDescription = "")
            }
        }
    }

    @Composable
    fun Texto(texto: String) {
        Text(texto, color = Color.White)
    }
}