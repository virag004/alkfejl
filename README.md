# Recipes

## Funkcionális követelmények

- Vendég
  - regisztráció
  - bejelentkezés
- Felhasználó
  - receptek megtekintése
  - saját recept hozzáadása
  - saját recept szerkesztése
  - saját recept törlése
- Adminisztátor
  - receptek megtekintése
  - recept hozzáadása
  - bármely recept szerkesztése
  - bármely recept törlése

## Nem-funkcionális követelmények

- felhasználóbarát
- egyszerű kezelhetőség
- gyors

## Fogalomjegyzék

- recipe: Egy recept, melyhez név, kép, több hozzávaló és többlépéses instrukció tartozik.
- ingredient: Egy hozzávaló, amely több recepthez is tartozhat.
- instruction: Egy instrukció, amely több lépésből áll és csak egy recepthez tartozik.

## Szerepkörök

- Vendég: Az oldal felkeresésekor alapértelmezetten kiadott szerepkör; csak bejelentkezni, vagy regisztrálni tud.
- Felhasználó: Bejelentkezett felhasználó, aki láthatja a feltöltött recepteket, valamint hozzáadhat és a sajátjait szerkesztheti, törölheti.
- Adminisztrátor: Megtekinthet, hozzáadhat receptet és bármelyiket szerkesztheti, törölheti.

## Fejlesztői Környezet / Használt Technológiák

- Fejlesztői környezet
  - Intellij IDEA
- Használt technológiák:
  - Java SE
  - Spring Boot

## Adatbázis-terv

![alt text](https://github.com/virag004/alkfejl/recipes.png)

## Végpont leírások

- GET /recipes: az összes recept kilistázása.
- GET /recipes/{id}: egy recept megtekintése.
- POST /recipes/{id}: egy recept hozzáadása.
- PUT /recipes/{id}: egy recept szerkesztése.
- DELETE /recipes/{id}: egy recept törlése.