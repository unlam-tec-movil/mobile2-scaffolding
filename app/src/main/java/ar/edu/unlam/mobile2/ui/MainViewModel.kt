package ar.edu.unlam.mobile2.ui

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.unlam.mobile2.HttpClientModule
import ar.edu.unlam.mobile2.domain.Game
import ar.edu.unlam.mobile2.domain.GetNewKitty
import coil.ImageLoader
import coil.request.ImageRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import java.security.cert.X509Certificate
import javax.inject.Inject
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

data class GameViewModel(
    var question: String,
    var correctAnswer: Int,
    var firstOption: String,
    var secondOption: String,
)

@HiltViewModel
class MainViewModel @Inject constructor(val service: GetNewKitty) : ViewModel() {

    val DEFAULT: String = "https://icons.iconarchive.com/icons/iconsmind/outline/512/Cat-icon.png"

    // Create a LiveData with a String
    val kittyUrl: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val game: MutableLiveData<GameViewModel> by lazy {
        MutableLiveData<GameViewModel>()
    }

    init {
        Log.i("MainViewModel", "init")
        kittyUrl.value = DEFAULT
        updateKittyUrl()
        viewModelScope.launch {
            service.getGame().collect {
                game.value = it.toViewModel()
            }
        }
    }

    fun updateKittyUrl() {
        viewModelScope.launch {
            Log.i("MainViewModel", "updateKittyUrl")
            kittyUrl.value = service.getKitty()
            Log.i("MainViewModel", "updatedKittyUrl:" + kittyUrl.value)
        }
    }

    fun getImageRequest(context: Context): ImageRequest {
        Log.i("MainViewModel", "obteniendo  ImageRequest:" + kittyUrl.value)
        val imageLoader: ImageLoader = initUntrustImageLoader(context)

        // updateKittyUrl()

        val request = ImageRequest.Builder(context)
            .data(kittyUrl.value)
            .crossfade(true)
            .build()

        viewModelScope.launch {
            Log.i("MainViewModel", "Ejecutando  ImageRequest")
            imageLoader.execute(request)
        }
        return request
    }

    private fun initUntrustImageLoader(context: Context): ImageLoader {
        // Create a trust manager that does not validate certificate chains
        val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
            override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String) {}

            override fun checkServerTrusted(chain: Array<X509Certificate>, authType: String) {}

            override fun getAcceptedIssuers(): Array<X509Certificate> {
                return arrayOf()
            }
        })

        // Install the all-trusting trust manager
        val sslContext = SSLContext.getInstance("SSL")
        sslContext.init(null, trustAllCerts, java.security.SecureRandom())

        // Create an ssl socket factory with our all-trusting manager
        val sslSocketFactory = sslContext.socketFactory

        val client = OkHttpClient.Builder()
            .sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
            .hostnameVerifier { _, _ -> true }.build()

        val module = HttpClientModule()

        /*return ImageLoader.Builder(context)
            .okHttpClient(client)
            .build()*/
        return module.imageLoader(context)
    }
}

private fun Game.toViewModel() = GameViewModel(
    question = question,
    correctAnswer = correctAnswer,
    secondOption = secondOption,
    firstOption = firstOption,
)
