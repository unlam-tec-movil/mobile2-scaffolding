package ar.edu.unlam.mobile2.detalle

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import ar.edu.unlam.mobile2.mediastackapi.New


class NewDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val new = intent.getSerializableExtra(EXTRA_PARAMS) as New

        setContent {
            PlantDetailScreen(new)
        }
    }

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @Composable
    fun PlantDetailScreen(new: New) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(new.title.toString())
                    },
                    navigationIcon = {
                        IconButton(onClick = { finish() }) {
                            Icon(Icons.Filled.ArrowBack, null)
                        }
                    }
                )
            },
            content = {
                PlantDetail(new)
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

@Composable
private fun PlantDetail(new: New) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "${new.author}",
            style = typography.h6,
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
        )
        Text(
            text = "${new.description}",
            style = typography.body1,
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
        )

    }
}


