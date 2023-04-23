package ar.edu.unlam.mobile2.ui

import android.graphics.Paint.Align
import android.icu.text.ListFormatter.Width
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.ui.AppBarConfiguration
import ar.edu.unlam.mobile2.R
import ar.edu.unlam.mobile2.databinding.ActivityMainBinding
import ar.edu.unlam.mobile2.ui.ui.theme.DarkViolet
import ar.edu.unlam.mobile2.ui.ui.theme.Mobile2_ScaffoldingTheme
import ar.edu.unlam.mobile2.ui.ui.theme.Violet
import coil.compose.SubcomposeAsyncImage

class JuegoActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels()

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var puntaje = 0

        setContent {
            Mobile2_ScaffoldingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Violet
                ) {
                    Row(
                        modifier = Modifier.background(DarkViolet)
                    ) {
                        Image(painter = painterResource(id = R.drawable.baseline_favorite_24), contentDescription = "", modifier = Modifier.border(width = 1.dp, color = Color.Black))
                        Image(painter = painterResource(id = R.drawable.baseline_favorite_24), contentDescription = "", modifier = Modifier.border(width = 1.dp, color = Color.Black))
                        Image(painter = painterResource(id = R.drawable.baseline_favorite_24), contentDescription = "", modifier = Modifier.border(width = 1.dp, color = Color.Black))
                        Image(painter = painterResource(id = R.drawable.baseline_close_24), contentDescription = "", alignment = Alignment.CenterEnd)
                    }
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.SpaceAround,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        texto("Pregunta")
                        /*SubcomposeAsyncImage(
                            model = mainViewModel.getImageRequest(LocalContext.current),
                            contentDescription = stringResource(R.string.anime_image1)
                        )*/
                        Text("VS", color = Color.Red)
                        /*SubcomposeAsyncImage(
                            model = mainViewModel.getImageRequest(LocalContext.current),
                            contentDescription = stringResource(R.string.anime_image2)
                        )*/
                        Row {
                            Text(text = puntaje.toString(),  modifier =
                            Modifier
                                .background(Color.Red, RectangleShape)
                                .padding(10.dp), Color.White, textAlign = TextAlign.Center)
                            Image(painter = painterResource(id = R.drawable.baseline_replay_24), contentDescription = "")
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun texto(texto: String) {
        Text(texto, color = Color.White)
    }
}

