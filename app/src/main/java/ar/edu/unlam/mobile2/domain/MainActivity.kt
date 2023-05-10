package ar.edu.unlam.mobile2.domain

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
import ar.edu.unlam.mobile2.domain.ui.theme.Mobile2_ScaffoldingTheme
import ar.edu.unlam.mobile2.news.NewViewModel
import ar.edu.unlam.mobile2.ui.NewsList
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCenter.start(
            application, "719d2c40-5de1-44d8-980d-aded581ac26d",
            Analytics::class.java, Crashes::class.java
        )

        val newViewModel by viewModels<NewViewModel>()

        setContent {
            NewsList(newViewModel)
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Mobile2_ScaffoldingTheme {
    }
}