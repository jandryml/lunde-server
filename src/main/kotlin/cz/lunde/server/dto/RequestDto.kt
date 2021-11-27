package cz.lunde.server.dto

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

class RequestDto(
    var id: Long = -1,

    @field:Email(message = "email: must be in valid email format!")
    @field:Size(max = 255, message = "email: max size is 255!")
    @field:NotBlank(message = "email: can't be blank!")
    var email: String = "",

    @field:Pattern(regexp = "^[A-Za-z0-9]+\$", message = "policyNumber: must be alphanumeric!")
    @field:Size(max = 255, message = "policyNumber: max size is 255!")
    @field:NotBlank(message = "policyNumber: can't be blank!")
    var policyNumber: String = "",

    @field:Pattern(regexp = "^[A-Za-z]+\$", message = "name: must be alphabetic!")
    @field:Size(max = 255, message = "name: max size is 255!")
    @field:NotBlank(message = "name: can't be blank!")
    var name: String = "",

    @field:Pattern(regexp = "^[A-Za-z]+\$", message = "surname: must be alphabetic!")
    @field:Size(max = 255, message = "surname: max size is 255!")
    @field:NotBlank(message = "surname: can't be blank!")
    var surname: String = "",

    @field:Size(max = 5000, message = "requestData: max size is 255!")
    @field:NotBlank(message = "requestData: can't be blank!")
    var requestData: String = "",

    var requestTypeId: Long = -1
)