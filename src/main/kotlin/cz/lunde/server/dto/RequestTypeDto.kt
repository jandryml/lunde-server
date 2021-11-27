package cz.lunde.server.dto

import cz.lunde.server.model.RequestType
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

class RequestTypeDto(
    var id: Long = -1,
    @field:Size(max = 255, message = "name: max size is 255!")
    @field:NotBlank(message = "name: must not be blank!")
    var name: String = ""
) {
    fun toModel() = RequestType(id, name)
}