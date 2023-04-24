package ar.edu.unlam.mobile2.domain


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ar.edu.unlam.mobile2.R
import ar.edu.unlam.mobile2.data.Articulo

private val articulos: List<Articulo> = listOf(
    Articulo(
        1,
        R.drawable.ic_launcher_background,
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
        "Autor",
        "Politica"
    ),
    Articulo(2, R.drawable.ic_launcher_background, "Titulo 2", "Autor", "Musica"),
    Articulo(3, R.drawable.ic_launcher_background, "Titulo 3", "Autor", "Economia"),
    Articulo(4, R.drawable.ic_launcher_background, "Titulo 4", "Autor", "Deporte"),
    Articulo(5, R.drawable.ic_launcher_background, "Titulo 5", "Autor", "Politica"),
    Articulo(6, R.drawable.ic_launcher_background, "Titulo 6", "Autor", "Deporte"),
    Articulo(7, R.drawable.ic_launcher_background, "Titulo 7", "Autor", "Musica"),
    Articulo(8, R.drawable.ic_launcher_background, "Titulo 8", "Autor", "Politica"),
    Articulo(9, R.drawable.ic_launcher_background, "Titulo 9", "Autor", "Economia"),
    Articulo(10, R.drawable.ic_launcher_background, "Titulo 10", "Autor", "Politica"),
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppContainer(articulos)
        }
    }
}


@Preview
@Composable
fun MyFilterList() {

}

@Preview(showSystemUi = true)
@Composable
fun MyApp() {
    AppContainer(articulos)
}

@Composable
fun AppContainer(articulos: List<Articulo>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        items(articulos) { articulo ->
            Cards(articulo)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyToolBar() {
    TopAppBar(
        title = { MyText(text = R.string.app_name.toString()) }
    )
}

@Composable
fun Cards(articulo: Articulo) {
    Card(
        modifier = Modifier
            .height(200.dp)
            .padding(10.dp)
    ) {
        ItemsNews(articulo)
    }
}

@Composable
fun MyText(text: String) {
    Text(text = text)
}

@Composable
fun ItemsNews(articulo: Articulo) {
    Column(modifier = Modifier.padding(10.dp)) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "NewsBackground",
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
        )
        MyText(text = articulo.topic)
        MyText(text = articulo.titulo)
    }


}
/*override fun onSupportNavigateUp(): Boolean {
    val navController = findNavController(R.id.nav_host_fragment_content_main)
    return navController.navigateUp(appBarConfiguration)
            || super.onSupportNavigateUp()
}*/
