package ar.edu.unlam.mobile2

import ar.edu.unlam.mobile2.data.KittiesRepo
import ar.edu.unlam.mobile2.data.KittiesRestRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
/*import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes*/
<<<<<<< Updated upstream

@Module
@InstallIn(ViewModelComponent::class)
abstract class MainModule {
   /* override fun onCreate(savedInstanceState: Bundle?) {
=======
//en main Activity
@Module
@InstallIn(ViewModelComponent::class)
abstract class MainModule {
    /*  override fun onCreate(savedInstanceState: Bundle?) {
>>>>>>> Stashed changes
        super.onCreate(savedInstanceState)
        AppCenter.start(
            application, "719d2c40-5de1-44d8-980d-aded581ac26d",
            Analytics::class.java, Crashes::class.java
        )*/

    @Binds
    abstract fun bindKittiesRepo(kittiesRestRepo: KittiesRestRepo): KittiesRepo
}
