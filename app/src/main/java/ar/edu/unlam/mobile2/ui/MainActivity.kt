package ar.edu.unlam.mobile2.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.ui.AppBarConfiguration
import ar.edu.unlam.mobile2.R
import ar.edu.unlam.mobile2.databinding.ActivityMainBinding
import ar.edu.unlam.mobile2.ui.ui.theme.BackgroundColor
import ar.edu.unlam.mobile2.ui.ui.theme.ButtonColor
import ar.edu.unlam.mobile2.ui.ui.theme.TextColor
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.internal.wait

@AndroidEntryPoint
class MainActivity : /*AppCompatActivity()*/ ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("MainActivity", "onCreate")

        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = BackgroundColor
            ) {
                content()
            }
        }
    }

    @Preview
    @Composable
    private fun content() {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            nameEditText()
            buttonCustom(text = "Jugar",
                onClick = {
                    irAJuego()
                    onStop()
                })
            buttonCustom(text = "Ajustes",
                onClick = {
                    irAConfiguracion()
                    onStop()
                })
            buttonCustom(text = "Historial",
                onClick = {
                    irAHistorial()
                    onStop()
                })
        }
    }
    @Composable
    fun buttonCustom(text: String, onClick: () -> Unit) {
        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(containerColor = ButtonColor),
        ) {
            Text(text)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("MainActivity", "onStart")

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    /*override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }*/


    private fun irAJuego() {
        val intent = Intent(this, GameActivity::class.java)
        startActivity(intent)
    }

    private fun irAConfiguracion() {
        val intent = Intent(this, ConfiguracionActivity::class.java)
        startActivity(intent)
    }

    private fun irAHistorial() {
        val intent = Intent(this, RecordActivity::class.java)
        startActivity(intent)
    }

    @Composable
    fun Texto(texto: String) {
        Text(texto, color = Color.White)
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun nameEditText() {
        var text by remember { mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text(text = "Nombre") },
            placeholder = { Text(text = "Ingresa tu nombre...") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.White,
                unfocusedBorderColor = TextColor,
                unfocusedLabelColor = TextColor,
                focusedBorderColor = ButtonColor,
                focusedLabelColor = ButtonColor,
                cursorColor = ButtonColor

            ),
            singleLine = true,
            modifier = Modifier.padding(top = 20.dp)
        )
    }
}

