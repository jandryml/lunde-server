package cz.lunde.server.repository

import cz.lunde.server.model.RequestType
import org.springframework.data.jpa.repository.JpaRepository

interface RequestTypeRepository: JpaRepository<RequestType, Long> {
}