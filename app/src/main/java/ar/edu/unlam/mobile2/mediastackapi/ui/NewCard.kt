package ar.edu.unlam.mobile2.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.edu.unlam.mobile2.mediastackapi.New


@Preview(showBackground = true)
@Composable
fun ArticleCard() {
}
@Composable

fun CardContainer(new: New) {
    Card(modifier = Modifier
        .padding(1.dp)
        .clickable { }
        .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp)) {
        Column(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .padding(top = 5.dp)
        ) {
           Row() {
               Text(text = "Categoria: ")
               Text(text = new.category!!)
           } 
            Text(
                text = new.title!!,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(5.dp))
            Divider()
        }
    }
}

