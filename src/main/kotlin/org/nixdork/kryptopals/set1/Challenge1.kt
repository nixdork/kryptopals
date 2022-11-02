package org.nixdork.kryptopals.set1

import org.nixdork.kryptopals.Encoding
import org.nixdork.kryptopals.IKryptopal
import org.nixdork.kryptopals.base64Decode
import org.nixdork.kryptopals.base64Encode
import org.nixdork.kryptopals.toBytes

class Challenge1 : IKryptopal {
    override val challengeSet = 1
    override val challenge = 1

    override val description = """
        Convert hex to base64

        The string:
            49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d

        Should produce:
            SSdtIGtpbGxpbmcgeW91ciBicmFpbiBsaWtlIGEgcG9pc29ub3VzIG11c2hyb29t

        So go ahead and make that happen. You'll need to use this code for the rest of the exercises.

        Cryptopals Rule
            Always operate on raw bytes, never on encoded strings. Only use hex and base64 for pretty-printing.
    """.trimIndent()

    override fun solve(): Any =
        "49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d"
            .toBytes(Encoding.HEX)
            .base64Encode()
            .base64Decode()
}
