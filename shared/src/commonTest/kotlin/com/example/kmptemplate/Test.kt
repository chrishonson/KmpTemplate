package com.example.kmptemplate

import Greeting
import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.utils.io.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertTrue

class CommonGreetingTest {

    @Test
    fun testExample() {
        runTest{
            val mockEngine = MockEngine { _ ->
                respond(
                    content = ByteReadChannel("""[{"name":"CTS21","flight_number":42,"success":true,"date_utc":"2021-09-15T00:00:00Z"}]"""),
                    status = HttpStatusCode.OK,
                    headers = headersOf(HttpHeaders.ContentType, ContentType.Application.Json.toString())
                )
            }

            val mockHttpClient = HttpClient(mockEngine) {
                install(ContentNegotiation) {
                    json(Json {
                        prettyPrint = true
                        isLenient = true
                        ignoreUnknownKeys = true
                    })
                }
            }
            assertTrue {
                Greeting(mockHttpClient).greet().contains("Greetings!")
            }
        }
    }
}