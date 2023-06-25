package ar.edu.unlam.mobile2.detalle

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ar.edu.unlam.mobile2.mediastackapi.New
import ar.edu.unlam.mobile2.theme.Mobile2_ScaffoldingTheme


class NewDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val new = intent.getSerializableExtra(EXTRA_PARAMS) as New

        setContent {
            Mobile2_ScaffoldingTheme {
                PlantDetailScreen(new)
            }

        }
    }

    @SuppressLint(
        "UnusedMaterialScaffoldPaddingParameter",
        "UnusedMaterial3ScaffoldPaddingParameter"
    )
    @Composable
    fun PlantDetailScreen(new: New) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                    },
                    navigationIcon = {
                        IconButton(onClick = { finish() }) {
                            Icon(
                                Icons.Filled.ArrowBack,
                                null,
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                    },
                    backgroundColor = MaterialTheme.colorScheme.background
                )
            },
            backgroundColor = MaterialTheme.colorScheme.background,
            content = {
                NewDetail(new)
            }
        )
    }

    companion object {
        const val EXTRA_PARAMS = "EXTRA_PLANT_DETAIL_PLANT"

        fun start(context: Context, new: New) {
            val intent = Intent(context, NewDetailActivity::class.java)
            intent.putExtra(EXTRA_PARAMS, new)
            context.startActivity(intent)
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
private fun NewDetail(new: New) {
    val context = LocalContext.current
    Mobile2_ScaffoldingTheme {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            item {
                androidx.compose.material3.Text(
                    text = new.title!!,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            item { Spacer(modifier = Modifier.height(5.dp)) }
            item {
                Row {
                    androidx.compose.material3.Text(
                        text = new.source!!,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.secondary,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    androidx.compose.material3.Text(
                        text = new.category!!,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.secondary,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            item { Spacer(modifier = Modifier.height(15.dp)) }
            item {
                androidx.compose.material3.Text(
                    text = new.description!!,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.tertiary
                )
            }
            item { Spacer(modifier = Modifier.height(10.dp)) }
            item {
                Button(
                    onClick = { abrirLink(context, new.url!!) },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colorScheme.primary)
                ) {
                    Text(
                        text = "Para ver la noticia completa, haga click aquí",
                        color = MaterialTheme.colorScheme.tertiary
                    )
                }
            }


        }
    }
}

private fun abrirLink(context: Context, link: String){
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
    context.startActivity(intent)
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview(showSystemUi = false)
@Composable
fun PlantDetailScreen() {
    val mockItem = New(
        1, "Author",
        "Sports",
        "Argentina",
        "Eum facilis voluptatem ut aliquid dolorem quo sint assumenda non odit laudantium qui dolor dolores in reiciendis aliquam et nobis corrupti! Ab enim delectus est voluptatem nulla ut molestiae omnis non nesciunt sint qui commodi ipsam qui consequatur temporibus. Id rerum quia ea temporibus facere et possimus dolor et dolorum maxime ut fugiat recusandae. Eos doloremque quia in quia dolorum non debitis totam et dolore laudantium rem quibusdam reiciendis eum labore praesentium quo nostrum labore. Eum facilis voluptatem ut aliquid dolorem quo sint assumenda non odit laudantium qui dolor dolores in reiciendis aliquam et nobis corrupti! Ab enim delectus est voluptatem nulla ut molestiae omnis non nesciunt sint qui commodi ipsam qui consequatur temporibus. Id rerum quia ea temporibus facere et possimus dolor et dolorum maxime ut fugiat recusandae. Eos doloremque quia in quia dolorum non debitis totam et dolore laudantium rem quibusdam reiciendis eum labore praesentium quo nostrum labore. Eum facilis voluptatem ut aliquid dolorem quo sint assumenda non odit laudantium qui dolor dolores in reiciendis aliquam et nobis corrupti! Ab enim delectus est voluptatem nulla ut molestiae omnis non nesciunt sint qui commodi ipsam qui consequatur temporibus. Id rerum quia ea temporibus facere et possimus dolor et dolorum maxime ut fugiat recusandae. Eos doloremque quia in quia dolorum non debitis totam et dolore laudantium rem quibusdam reiciendis eum labore praesentium quo nostrum labore.",
        "##",
        "Esp",
        "XX",
        "Source",
        "Lorem Ipsum Generated Text",
        "www.google.com",
        false
    )
    Mobile2_ScaffoldingTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                    },
                    navigationIcon = {
                        IconButton(onClick = {}) {
                            Icon(
                                Icons.Filled.ArrowBack,
                                null,
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                    },
                    backgroundColor = MaterialTheme.colorScheme.background
                )
            },
            backgroundColor = MaterialTheme.colorScheme.background,
            content = {
                NewDetail(mockItem)
            }
        )
    }

}



