package ar.edu.unlam.mobile2.Tabs.repository

import androidx.compose.runtime.Composable
import ar.edu.unlam.mobile2.R
import ar.edu.unlam.mobile2.mediastackapi.viewmodel.NewsViewModel


typealias miFuncion = @Composable () -> Unit

sealed class Tabs_item(
    var icon: Int,
    var title: String,
    var screen: miFuncion,

) {
    class item_general(viewModel:NewsViewModel) :
        Tabs_item(R.drawable.ic_launcher_foreground, "General", { General(viewModel) })

    object item_politica : Tabs_item(R.drawable.ic_launcher_foreground, "Politica", { Politica () })
    object item_muscia : Tabs_item(R.drawable.ic_launcher_foreground, "Musica", { Musica () })

}
