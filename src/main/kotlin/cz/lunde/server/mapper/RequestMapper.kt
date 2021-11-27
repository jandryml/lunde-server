package cz.lunde.server.mapper

import cz.lunde.server.dto.RequestDto
import cz.lunde.server.manager.RequestTypeManager
import cz.lunde.server.model.Request
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RequestMapper(
    @Autowired var requestTypeManager: RequestTypeManager
) {
    fun toModel(requestDto: RequestDto) = requestDto.run {
        Request(id, email, policyNumber, name, surname, requestData, requestTypeManager.getById(requestTypeId))
    }

    fun toDto(request: Request) = request.run {
        RequestDto(id, email, policyNumber, name, surname, requestData, requestType!!.id)
    }
}