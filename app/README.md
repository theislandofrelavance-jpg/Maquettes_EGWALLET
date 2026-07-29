# Dashboard notes

This commit implements the Dashboard UI skeleton: header, balance card, quick actions and recent transactions.

How to test (debug):
- Ensure backend or mocks: debug build uses BuildConfig.USE_MOCK=true by default.
- Open app in emulator, skip onboarding, login with PIN 123456 (mock) and the dashboard will show seeded mock data.

Mock data location:
- MockTransactionRepository seeds account and transactions.
- MockAuthRepository contains the test PIN (123456).

Build:
./gradlew assembleDebug

