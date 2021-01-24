package com.worldline.shared.data.model.dto

import kotlinx.serialization.Serializable

@Serializable
data class PoisResponseDto(
    val list: List<PoiDto>
)