package ar.edu.unlam.mobile2.mediastackapi.ui


import android.content.ClipData.Item
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ar.edu.unlam.mobile2.R
import ar.edu.unlam.mobile2.mediastackapi.New

import ar.edu.unlam.mobile2.mediastackapi.viewmodel.NewsViewModel

@Composable
fun newListDetail(viewModel: NewsViewModel){

   Card(modifier = Modifier
       .padding(1.dp)
       .clickable { }
       .fillMaxWidth(),
       shape = RoundedCornerShape(8.dp)) {
   
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement =  Arrangement.End
            ){
        Image(painter = painterResource(id = R.drawable.iconopage),
            contentDescription = "Noticia",
        modifier = Modifier.size(100.dp),
        )

        Column(modifier = Modifier.padding(16.dp)) {
        NewsList(viewModel = viewModel, numero = 1 )

        }

         }
    }
}




