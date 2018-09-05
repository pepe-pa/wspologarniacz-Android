package pl.wspologarniacz.mobile.auth.repository.model

data class User(val email: String,
                var password: String? = null,
                var name: String? = null
)