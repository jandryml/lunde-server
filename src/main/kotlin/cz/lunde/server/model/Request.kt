package cz.lunde.server.model

class Request(
    var email: String = "",
    var policyNumber: String = "",
    var name: String = "",
    var surname: String = "",
    var requestData: String = "",
    var requestType: RequestType? = null
)