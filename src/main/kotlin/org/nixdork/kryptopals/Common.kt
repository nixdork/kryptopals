@file:Suppress("MatchingDeclarationName")
package org.nixdork.kryptopals

import org.apache.commons.codec.binary.Hex
import org.apache.commons.codec.binary.Base64

interface KryptopalsSolution {
    val challengeSet: Int
    val challenge: Int
    val description: String
    fun solve(): Any
}

typealias IKryptopal = KryptopalsSolution

enum class Encoding {
    BASE64, HEX, TEXT
}

fun String.toBytes(encoding: Encoding): ByteArray =
    when (encoding) {
        Encoding.BASE64 -> Base64.decodeBase64(this)
        Encoding.HEX -> Hex.decodeHex(this.toCharArray())
        Encoding.TEXT -> this.toCharArray().map { it.code.toByte() }.toByteArray()
    }

fun ByteArray.base64Encode(): String = Base64.encodeBase64String(this)
fun ByteArray.hexEncode(): String = Hex.encodeHexString(this)

fun String.base64Decode(): String = Base64.decodeBase64(this).decodeToString()
