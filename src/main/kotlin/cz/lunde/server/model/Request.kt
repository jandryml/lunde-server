package cz.lunde.server.model

import javax.persistence.*

@Entity
class Request(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = -1,
    var email: String = "",
    var policyNumber: String = "",
    var name: String = "",
    var surname: String = "",
    var requestData: String = "",
    @ManyToOne
    @JoinColumn(name = "request_type_id")
    var requestType: RequestType? = null
)