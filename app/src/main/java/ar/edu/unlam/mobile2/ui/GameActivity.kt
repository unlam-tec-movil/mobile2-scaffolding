package ar.edu.unlam.mobile2.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        var puntaje = 0

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
    fun Texto(texto: String) {
        Text(texto, color = Color.White)
    }
}

        /*Mobile2_ScaffoldingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Violet
                ) {
                    TopBar()
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.SpaceAround,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Texto("Pregunta")
                        SubcomposeAsyncImage(
                            model = mainViewModel.getImageRequest(LocalContext.current),
                            // placeholder = painterResource(R.drawable.placeholder),
                            contentDescription = stringResource(R.string.cat_image),
                            contentScale = ContentScale.FillBounds,
                            loading = {
                                CircularProgressIndicator(
                                    modifier = Modifier
                                        .height(50.dp)
                                        .width(50.dp),
                                )
                            },
                            modifier = Modifier
                                .height(300.dp)
                                .width(500.dp),
                            // error = rememberAsyncImagePainter(model = mainViewModel.DEFAULT),
                            onError = { error ->
                                run {
                                    mainViewModel.updateKittyUrl()
                                    Log.e("AsyncImageError", error.result.throwable.message.toString())
                                }
                            },
                            onLoading = { state ->
                                if (BuildConfig.DEBUG) {
                                    Log.i(
                                        "AsyncImageLoading",
                                        state.toString(),
                                    )
                                }
                            },
                        )
                        Text("VS", color = Color.Red)
                        SubcomposeAsyncImage(
                            model = mainViewModel.getImageRequest(LocalContext.current),
                            // placeholder = painterResource(R.drawable.placeholder),
                            contentDescription = stringResource(R.string.cat_image),
                            contentScale = ContentScale.FillBounds,
                            loading = {
                                CircularProgressIndicator(
                                    modifier = Modifier
                                        .height(50.dp)
                                        .width(50.dp),
                                )
                            },
                            modifier = Modifier
                                .height(300.dp)
                                .width(500.dp),
                            // error = rememberAsyncImagePainter(model = mainViewModel.DEFAULT),
                            onError = { error ->
                                run {
                                    mainViewModel.updateKittyUrl()
                                    Log.e("AsyncImageError", error.result.throwable.message.toString())
                                }
                            },
                            onLoading = { state ->
                                if (BuildConfig.DEBUG) {
                                    Log.i(
                                        "AsyncImageLoading",
                                        state.toString(),
                                    )
                                }
                            },
                        )
                        Row {
                            Text(text = puntaje.toString(),  modifier =
                            Modifier
                                .background(Color.Red, RectangleShape)
                                .padding(10.dp), Color.White, textAlign = TextAlign.Center)
                            Image(painter = painterResource(id = R.drawable.baseline_replay_24), contentDescription = "")
                        }
                    }
                }*/
