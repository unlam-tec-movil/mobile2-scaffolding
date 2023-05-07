package ar.edu.unlam.mobile2.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun ArticleCard() {
    CardContainer()
}

@Composable
fun CardContainer() {
    Column(
        modifier = Modifier.padding(horizontal = 4.dp)
    ) {
        Text(text = "Topic")
        Text(
            text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
            )
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = "1/1/1")
    }
}
