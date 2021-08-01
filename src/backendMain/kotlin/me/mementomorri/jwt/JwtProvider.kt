package me.mementomorri.jwt

import com.auth0.jwt.JWT
import com.auth0.jwt.interfaces.DecodedJWT
import me.mementomorri.model.User
import me.mementomorri.utils.Cipher
import org.springframework.stereotype.Service
import java.util.*

@Service
class JwtProvider {

    fun decodeJWT(token: String): DecodedJWT = JWT.require(Cipher.algorithm).build().verify(token)

    fun createJWT(user: User): String = JWT.create().withIssuedAt(Date()).withSubject(user.username)
        .withExpiresAt(Date(System.currentTimeMillis() + 1 * 24 * 60 * 60 * 1000))
        .sign(Cipher.algorithm)
}
