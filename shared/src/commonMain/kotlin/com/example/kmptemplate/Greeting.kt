import com.example.kmptemplate.Platform
import com.example.kmptemplate.RocketLaunch
import com.example.kmptemplate.daysUntilNewYear
import com.example.kmptemplate.getPlatformName
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class Greeting(httpClient: HttpClient?) {
    private val platform: Platform = getPlatformName()

    private val httpClient = httpClient ?: HttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
    }
    @Throws(Exception::class)
    suspend fun greet(): List<String> = buildList {
        val rockets: List<RocketLaunch> =
            httpClient.get("https://api.spacexdata.com/v4/launches").body()
        val lastSuccessLaunch = rockets.last { it.launchSuccess == true }
        add("Greetings!")
        add("Guess what it is! > ${platform.name.reversed()}!")
        add("\nThere are only ${daysUntilNewYear()} days left until New Year! 🎆")
        add("\nThe last successful launch was ${lastSuccessLaunch.launchDateUTC} 🚀")
    }
}