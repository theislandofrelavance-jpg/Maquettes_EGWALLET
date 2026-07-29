# Assets to copy into res/drawable

This file lists the image assets used by the frontend and where to source them from your existing repositories. The project currently contains drawable *placeholders* (vector shapes) so the app builds without the real PNG/SVG files. Please copy the real images into app/src/main/res/drawable/ using the exact filenames below so the UI is pixel-perfect.

Dashboard & common:
- logo.png
  - Source: Maquettes_EGWALLET (https://github.com/theislandofrelavance-jpg/Maquettes_EGWALLET/blob/main/logo.png)

Transactions / list / illustrations:
- transaction1.png
- transaction2.png
- transaction3.png
- transaction4.png
  - Source: Maquettes_EGWALLET (transaction1..transaction4) root
  - Examples: https://github.com/theislandofrelavance-jpg/Maquettes_EGWALLET/blob/main/transaction1.png

Onboarding / slides (if needed):
- onbording1.png
- onbording2.png
- onbording3.png
  - Source: Maquettes_EGWALLET (onbording1..3)

Notifications (used by notification screens):
- notification1.png .. notification5.png  (Maquettes_EGWALLET)
- notification6.png .. notification9.png  (EGWALLET_BACKEND)
  - Sources:
    - https://github.com/theislandofrelavance-jpg/Maquettes_EGWALLET/blob/main/notification1.png
    - https://github.com/theislandofrelavance-jpg/EGWALLET_BACKEND/blob/main/notification6.png

Objectives / illustrations (if used later):
- objectif.png / objectif2.png / objectif3.png / objectif4.png
  - Source: Maquettes_EGWALLET

How to copy
1. Download each file from the URLs above (use the raw file link on GitHub)
2. Place them in this repo under app/src/main/res/drawable/ preserving the filename
3. Rebuild the project: ./gradlew clean assembleDebug

Notes
- I added minimal vector placeholders (ic_logo_placeholder.xml & ic_transaction_placeholder.xml) so the project compiles while you copy the real assets.
- After you paste the real images, I will run a pixel-perfect pass (or you can run locally and report layout diffs) and then I will update layouts to reference them explicitly where needed.
