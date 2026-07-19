package dev.busung.s25uroot

import org.bouncycastle.crypto.params.Ed25519PublicKeyParameters
import org.bouncycastle.crypto.signers.Ed25519Signer

internal object Ed25519Verifier {
    fun verify(publicKey: ByteArray, message: ByteArray, signature: ByteArray): Boolean {
        if (publicKey.size != PUBLIC_KEY_SIZE || signature.size != SIGNATURE_SIZE) return false

        val verifier = Ed25519Signer()
        verifier.init(false, Ed25519PublicKeyParameters(publicKey, 0))
        verifier.update(message, 0, message.size)
        return verifier.verifySignature(signature)
    }

    private const val PUBLIC_KEY_SIZE = 32
    private const val SIGNATURE_SIZE = 64
}
