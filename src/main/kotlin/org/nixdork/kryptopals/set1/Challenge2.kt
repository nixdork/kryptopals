package org.nixdork.kryptopals.set1

import org.nixdork.kryptopals.Encoding
import org.nixdork.kryptopals.IKryptopal
import org.nixdork.kryptopals.base64Decode
import org.nixdork.kryptopals.base64Encode
import org.nixdork.kryptopals.hexEncode
import org.nixdork.kryptopals.toBytes
import kotlin.experimental.xor

class Challenge2 : IKryptopal {
    override val challengeSet = 1
    override val challenge = 2

    override val description = """
        Fixed XOR

        Write a function that takes two equal-length buffers and produces their XOR combination.

        If your function works properly, then when you feed it the string:

            1c0111001f010100061a024b53535009181c

        ... after hex decoding, and when XOR'd against:

            686974207468652062756c6c277320657965

        ... should produce:

            746865206b696420646f6e277420706c6179
    """.trimIndent()

    override fun solve(): Any =
        "1c0111001f010100061a024b53535009181c"
            .toBytes(Encoding.HEX)
            .let { input ->
                "686974207468652062756c6c277320657965"
                    .toBytes(Encoding.HEX)
                    .zip(input) { i, j ->
                        i xor j
                    }.toByteArray()
            }.base64Encode()
            .base64Decode()
}
