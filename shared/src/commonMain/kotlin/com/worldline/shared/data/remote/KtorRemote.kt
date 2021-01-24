package com.worldline.shared.data.remote

import com.worldline.shared.data.model.dto.PoisResponseDto
import com.worldline.shared.data.model.dto.toModel
import com.worldline.shared.domain.Either
import com.worldline.shared.domain.Result
import com.worldline.shared.domain.model.Poi
import com.worldline.shared.withEither
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*

class KtorRemote : Remote {

    private val client = HttpClient {
        defaultRequest {
            val endpointBuilder = URLBuilder("https://t21services.herokuapp.com/")
            url {
                protocol = endpointBuilder.protocol
                host = endpointBuilder.host
            }
        }

        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
    }

    override suspend fun getPoiList(): Either<Result.Error, List<Poi>> = withEither {
        val response = client.get<PoisResponseDto> { url { encodedPath = "points" } }
        response.list.map { it.toModel() }
    }
}