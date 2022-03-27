package bme.familyorganiserbackend.dtos


data class RegistrationDTO (
    var uid:String,
    var username:String,
    var password:String
)

data class LoginDTO(
    var username:String,
    var password:String
)