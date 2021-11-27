package cz.lunde.server.model

import cz.lunde.server.dto.RequestTypeDto
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class RequestType(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = -1,
    var name: String = ""
){
    fun toDto() = RequestTypeDto(id, name)
}