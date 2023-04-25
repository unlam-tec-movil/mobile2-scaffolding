package ar.edu.unlam.mobile2.data

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ar.edu.unlam.mobile2.R
import ar.edu.unlam.mobile2.domain.Cards
import ar.edu.unlam.mobile2.domain.Tabs_Principal

typealias miFuncion = @Composable () -> Unit

sealed class Tabs_item(
    var icon: Int,
    var title: String,
    var screen: miFuncion,
) {
    object item_general : Tabs_item(R.drawable.ic_launcher_foreground, "General", { General () })
    object item_politica : Tabs_item(R.drawable.ic_launcher_foreground, "Politica", {Politica ()})
    object item_muscia : Tabs_item(R.drawable.ic_launcher_foreground, "Musica", { Musica () })

}
