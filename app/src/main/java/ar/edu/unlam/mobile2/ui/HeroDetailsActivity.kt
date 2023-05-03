package ar.edu.unlam.mobile2.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import ar.edu.unlam.mobile2.ui.ui.theme.Mobile2_ScaffoldingTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement


import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import ar.edu.unlam.mobile2.R
import ar.edu.unlam.mobile2.domain.hero.Appearance
import ar.edu.unlam.mobile2.domain.hero.Biography
import ar.edu.unlam.mobile2.domain.hero.Connections
import ar.edu.unlam.mobile2.domain.hero.DataHero

import ar.edu.unlam.mobile2.domain.hero.Powerstats
import ar.edu.unlam.mobile2.domain.hero.Work



class HeroDetailsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Mobile2_ScaffoldingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    HeroDetails(dataHero = DataHero())
                }
            }
        }
    }
}

@Composable
fun HeroDetails(dataHero: DataHero, modifier: Modifier = Modifier) {
    var isStatsVisible by rememberSaveable { mutableStateOf(true) }
    var isBiographyVisible by rememberSaveable {mutableStateOf(true)}
    var isAppearanceVisible by rememberSaveable {mutableStateOf(true)}
    var isWorkVisible by rememberSaveable {mutableStateOf(true)}
    var isConnectionsVisible by rememberSaveable {mutableStateOf(true)}

    //modifier = modifier.align(Alignment.CenterHorizontally)

    Column(
        modifier = modifier
            .verticalScroll(state = rememberScrollState())
    ) {

        Image(
            painter = painterResource(id = R.drawable.default_imagen_heroe),
            contentDescription = "Imagen heroe",
            modifier = modifier
                .padding(8.dp)
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
        )
        Button(
            onClick = { isStatsVisible = !isStatsVisible },
            modifier = modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
        ) {
                Text(text = if(isStatsVisible) "Ocultar Stats" else "Mostrar Stats")
        }
        if (isStatsVisible) {
            HeroStats(stats = dataHero.powerstats)
        }

        Button(
            onClick = { isBiographyVisible = !isBiographyVisible },
            modifier = modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
        ) {
            Text(text = if (isBiographyVisible) "Ocultar biografía" else "Mostrar biografía")
        }
        if (isBiographyVisible) {
            HeroBiography(dataHero.biography)
        }

        Button(
            onClick = { isAppearanceVisible = !isAppearanceVisible },
            modifier = modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
        ) {
            Text(text = if(isAppearanceVisible) "Ocultar apariencia" else "mostrar apariencia")
        }
        if(isAppearanceVisible) {
            HeroAppearance(dataHero.appearance)
        }

        Button(
            onClick = { isWorkVisible = !isWorkVisible },
            modifier = modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
        ) {
            Text(text = if(isWorkVisible) "Ocultar profesión" else "Mostrar profesión")
        }
        if(isWorkVisible) {
            HeroWork(heroWork = dataHero.work)
        }

        Button(
            onClick = { isConnectionsVisible = !isConnectionsVisible },
            modifier = modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
        ) {
            Text(text = if(isConnectionsVisible) "Ocultar connecciones" else "Mostrar conecciones")
        }
        if (isConnectionsVisible) {
            HeroConnections(heroConnections = dataHero.connections)
        }

    }
}

@Preview
@Composable
fun HeroDetailsPreview() {
    HeroDetails(dataHero = DataHero())
}

@Composable
fun HeroConnections(heroConnections: Connections, modifier: Modifier = Modifier) {

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column {
            Text(text = "Afiliación grupal: $")
            Text(text = "Parientes: $")
        }
    }






}

@Composable
fun HeroWork(heroWork: Work, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column {
            Text("Profesión: $")
            Text("Base: $")
        }
    }


}

@Composable
fun HeroAppearance(heroAppearance: Appearance, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column {
            Text("Género biológico: $") //lo dejo así para que nadie se ofenda
            Text("Raza: $")
            Text("Altura: $")
            Text("Peso: $")
            Text("Color de ojos: $")
            Text("Color del cabello: $")
        }
    }

}



@Composable
fun HeroBiography(biography: Biography, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column{
            Text("Nombre: ${biography.fullName}")
            Text("Alter-Egos: ${biography.alterEgos}")
            Text(text = "Apodos: ${biography.aliases}")
            Text("Lugar de nacimiento: ${biography.placeOfBirth}")
            Text("Primera aparición: ${biography.firstAppearance}")
            Text("Editorial: ${biography.publisher}")
            Text("Alineación: ${biography.alignment}")
        }
    }


}

@Preview
@Composable
fun HeroBiographyPreview() {
    HeroBiography(biography = Biography())
}


@Composable
fun HeroStats(stats: Powerstats, modifier: Modifier = Modifier) {

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = modifier
                .padding(8.dp)
        ) {
            Column(modifier = modifier.padding(8.dp)) {
                Text("Inteligencia: $")
                Text("Velocidad: $")
                Text("Durabilidad: $")
            }
            Column(modifier = modifier.padding(8.dp)) {
                Text("Fuerza: $")
                Text("Poder: $")
                Text("Combate: $")
            }
        }
    }

}

@Preview
@Composable
fun PreviewHeroStats() {
    HeroStats(stats = Powerstats())
}