package dev.busung.s25uroot

import java.security.MessageDigest
import net.i2p.crypto.eddsa.EdDSAEngine
import net.i2p.crypto.eddsa.EdDSAPublicKey
import net.i2p.crypto.eddsa.spec.EdDSANamedCurveTable
import net.i2p.crypto.eddsa.spec.EdDSAPublicKeySpec

internal object Ed25519Verifier {
    private val curve = checkNotNull(EdDSANamedCurveTable.getByName("Ed25519"))

    fun verify(publicKey: ByteArray, message: ByteArray, signature: ByteArray): Boolean {
        if (publicKey.size != PUBLIC_KEY_SIZE || signature.size != SIGNATURE_SIZE) return false

        val verifier = EdDSAEngine(MessageDigest.getInstance(curve.hashAlgorithm))
        verifier.initVerify(EdDSAPublicKey(EdDSAPublicKeySpec(publicKey, curve)))
        verifier.update(message)
        return verifier.verify(signature)
    }

    private const val PUBLIC_KEY_SIZE = 32
    private const val SIGNATURE_SIZE = 64
}
