# Frontend skeleton for EGWallet

This branch contains a minimal Android project skeleton to start the frontend development.

How to use:
- Open the project in Android Studio (select the frontend/init branch)
- Build and run (Gradle and SDK 35 required)

Mock vs Backend:
- Debug build uses BuildConfig.USE_MOCK = true and default BASE_URL = http://10.0.2.2:8080/api/v1/
- To use a remote backend, change the BASE_URL in buildTypes or set a different build type.

Next steps implemented by the maintainer:
- Fill layouts and viewmodels
- Implement Room entities and DAOs
- Connect ApiService with Retrofit and ApiClient
