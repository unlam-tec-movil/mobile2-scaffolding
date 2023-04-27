package ar.edu.unlam.mobile2.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.DropdownMenu
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.edu.unlam.mobile2.R

class PantallaPerfilUsuario : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            perfil()

        }
    }


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @Composable
    fun perfil() {

        val scaffoldState = rememberScaffoldState()
        Scaffold(
            scaffoldState = scaffoldState,
            topBar = { topBarPerfil() },
        ) {
            Column(modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)) {
                Spacer(modifier = Modifier.padding(14.dp))
                nombreRegistro(Modifier.align(Alignment.CenterHorizontally))
                Spacer(modifier = Modifier.padding(8.dp))
                email(Modifier.align(Alignment.CenterHorizontally))
                Spacer(modifier = Modifier.padding(8.dp))
                nacionalidad(Modifier.align(Alignment.CenterHorizontally))
                Spacer(modifier = Modifier.padding(8.dp))
                tomarFoto(Modifier.align(Alignment.CenterHorizontally))
                Spacer(modifier = Modifier.padding(10.dp))
                fotoPerfil(Modifier.align(Alignment.CenterHorizontally))
                Spacer(modifier = Modifier.padding(40.dp))
                botonGuardarCambios(Modifier.align(Alignment.CenterHorizontally))
            }
        }
    }

    @Composable
    fun nombreRegistro(modifier: Modifier) {
        var nombreRegistro by remember {
            mutableStateOf("")
        }
        TextField(value = nombreRegistro, onValueChange = {
            nombreRegistro = it
        },
            modifier = modifier.width(300.dp),
            placeholder = { androidx.compose.material.Text(text = "Nombre") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            singleLine = true,
            maxLines = 1,
            colors = TextFieldDefaults.textFieldColors(textColor = Color(0xFF0F0F0F),
                backgroundColor = Color(0xFF939599)
            )
        )
    }

    @Composable
    fun email(modifier: Modifier) {
        var Email by remember {
            mutableStateOf("")
        }
        TextField(value = Email, onValueChange = {
            Email = it
        },
            modifier = modifier.width(300.dp),
            placeholder = { androidx.compose.material.Text(text = "Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            singleLine = true,
            maxLines = 1,
            colors = TextFieldDefaults.textFieldColors(textColor = Color(0xFF0F0F0F),
                backgroundColor = Color(0xFF939599)
            )
        )
    }

    @Composable
    fun nacionalidad(modifier: Modifier) {
        var nacionalidad by remember {
            mutableStateOf("")
        }
        TextField(value = nacionalidad, onValueChange = {
            nacionalidad = it
        },
            modifier = modifier.width(300.dp),
            placeholder = { androidx.compose.material.Text(text = "Nacionalidad") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            singleLine = true,
            maxLines = 1,
            colors = TextFieldDefaults.textFieldColors(textColor = Color(0xFF0F0F0F),
                backgroundColor = Color(0xFF939599)
            )
        )
    }


    @Composable
    fun tomarFoto(modifier: Modifier) {
        Box(
            modifier = modifier
                .width(300.dp)
                .height(55.dp)
                .background(color = Color(0xFF939599))
                .padding(vertical = 15.dp, horizontal = 10.dp),
        ) {
            Row(modifier = modifier.clickable {
                

            }) {
                androidx.compose.material.Text(text = "Tomar Foto      ( presione aquí )",
                    fontSize = 16.sp, color = Color.DarkGray)

                Spacer(modifier = modifier.padding(horizontal = 80.dp))
            }
        }
    }



    @Composable
    fun fotoPerfil(modifier: Modifier){
        var fotoDePerfil  by remember { mutableStateOf(false) }
      val  imagen = if (fotoDePerfil) R.drawable.avatar  else R.drawable.iconoavatar
        Image(
            painterResource(id = imagen ),
            contentDescription = "",

            modifier = modifier
                .width(150.dp)
                )
    }

    @Composable
    fun botonGuardarCambios(modifier: Modifier) {
        Button(modifier = modifier
            .height(50.dp)
            .width(200.dp),
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF396AE9)),
            onClick = { /*TODO*/ }) {
            androidx.compose.material.Text(text = "Guardar Cambios")
        }

    }

    @Composable
    fun topBarPerfil(
    ) {
        var showMenu by remember {
            mutableStateOf(false)
        }
        TopAppBar(
            title = { androidx.compose.material.Text(text = "Mi Perfil", modifier = Modifier, Color.White,) },
            backgroundColor = Color.Black,
            actions = {
                IconButton(onClick = {   startActivity(
                    Intent(this@PantallaPerfilUsuario,
                    MainActivity::class.java)
                )
                    finish()}) {
                    Image(painter = painterResource(id = R.drawable.ic_baseline_arrow_back_24),
                        contentDescription = "icono menu")
                }
                DropdownMenu(expanded = showMenu, onDismissRequest = { showMenu = false },
                    modifier = Modifier
                        .width(110.dp)
                        .background(color = Color(0xFF335ABD)),)
                {
                }
            }
        )
    }
}




