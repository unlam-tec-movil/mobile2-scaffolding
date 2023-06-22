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

    class item_business(viewModel: NewsViewModel) :
        Tabs_item(R.drawable.ic_launcher_foreground, "Business", { Business(viewModel) })

    class item_entertainment(viewModel: NewsViewModel) :
        Tabs_item(R.drawable.ic_launcher_foreground, "Entertainment", { Entertainment(viewModel) })
    class item_health(viewModel: NewsViewModel) :
        Tabs_item(R.drawable.ic_launcher_foreground, "Health", { Health(viewModel) })

    class item_science(viewModel: NewsViewModel) :
        Tabs_item(R.drawable.ic_launcher_foreground, "Science", { Science(viewModel) })

    class item_sports(viewModel: NewsViewModel) :
        Tabs_item(R.drawable.ic_launcher_foreground, "Sports", { Sports(viewModel) })

    class item_technology(viewModel: NewsViewModel) :
        Tabs_item(R.drawable.ic_launcher_foreground, "Technology", { Technology(viewModel) })



}
