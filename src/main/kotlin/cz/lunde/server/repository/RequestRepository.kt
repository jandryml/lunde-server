package cz.lunde.server.repository

import cz.lunde.server.model.Request
import org.springframework.data.jpa.repository.JpaRepository

interface RequestRepository : JpaRepository<Request, Long>