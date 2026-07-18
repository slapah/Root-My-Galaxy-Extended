# Root My Galaxy

Root My Galaxy is a Jetpack Compose one-click installer for explicitly
supported Samsung firmware builds. The application itself is kept separate
from device offsets, native exploit payloads, and KernelSU build artifacts.

The signed device feed and native payloads are maintained in
[Root-My-Galaxy-Payloads](https://github.com/BuSung-dev/Root-My-Galaxy-Payloads).
The standalone CVE proof of concept remains in
[CVE-2026-43499-S25U](https://github.com/BuSung-dev/CVE-2026-43499-S25U).

## Current profiles

```text
Galaxy S25 Ultra / 6.6.98-android15-8-pd6ff1cd-abogkiS938NKSUACZF1-4k
Galaxy S24 FE / 6.1.157-android14-11
```

The app automatically selects an exact signed match for the kernel release,
full build display ID, SDK, ABI, and page size. Advanced mode can select a
profile manually and presents separate kernel-release and build warnings.

## Download model

1. Resolve the current `main` commit of the payload repository.
2. Download the support manifest and Ed25519 signature from that exact commit.
3. Verify the signature with the public key pinned in the APK.
4. Match the kernel release and exact automatic-selection fields.
5. Download the exploit and KernelSU artifacts from the same immutable commit.

Per-artifact SHA-256 fields are intentionally not used. The signed manifest
and immutable Git commit are the trust and consistency boundaries.

## Interface

- Material 3 Expressive UI
- Tonal Spot palettes generated with the Material Color Utilities 2025 spec
- overview and settings navigation
- system dynamic, blue, violet, green, and orange Material palettes
- Korean, English, Japanese, and Simplified Chinese app languages
- dedicated non-dismissible installation screen with live native logs

## Build

Requirements:

- Android Studio JBR 21
- Android SDK 37
- Android NDK 28 or newer
- CMake 3.22.1

```powershell
$env:JAVA_HOME='C:\Program Files\Android\Android Studio\jbr'
.\gradlew.bat :app:assembleDebug
```

Output:

```text
app/build/outputs/apk/debug/app-debug.apk
```

Use only on devices you own or are explicitly authorized to test.
