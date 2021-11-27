package cz.lunde.server.dto

import cz.lunde.server.model.RequestType
import javax.validation.constraints.Size

class RequestTypeDto(
    var id: Long = -1,
    @field:Size(max = 255, message = "Name: max size is 255!")
    var name: String
) {
    fun toModel() = RequestType(id, name)
}