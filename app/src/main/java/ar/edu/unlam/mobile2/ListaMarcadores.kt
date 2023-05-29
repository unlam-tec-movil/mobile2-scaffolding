package ar.edu.unlam.mobile2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ar.edu.unlam.mobile2.mediastackapi.ui.MarcadoresList
import ar.edu.unlam.mobile2.mediastackapi.ui.viewmodel.NewsViewModel
import ar.edu.unlam.mobile2.ui.theme.Mobile2_ScaffoldingTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListaMarcadores : ComponentActivity() {
    private val mediaViewModel by viewModels<NewsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Mobile2_ScaffoldingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MarcadoresList(mediaViewModel)
                }
            }
        }
    }
}

