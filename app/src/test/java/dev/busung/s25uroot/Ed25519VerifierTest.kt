package dev.busung.s25uroot

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class Ed25519VerifierTest {
    @Test
    fun verifiesRfc8032TestVector() {
        val publicKey = hex("d75a980182b10ab7d54bfed3c964073a0ee172f3daa62325af021a68f707511a")
        val signature = hex(
            "e5564300c360ac729086e2cc806e828a84877f1eb8e5d974d873e06522490155" +
                "5fb8821590a33bacc61e39701cf9b46bd25bf5f0595bbe24655141438e7a100b",
        )

        assertTrue(Ed25519Verifier.verify(publicKey, byteArrayOf(), signature))

        signature[0] = (signature[0].toInt() xor 1).toByte()
        assertFalse(Ed25519Verifier.verify(publicKey, byteArrayOf(), signature))
    }

    private fun hex(value: String): ByteArray = value.chunked(2)
        .map { it.toInt(16).toByte() }
        .toByteArray()
}
