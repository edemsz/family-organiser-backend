# Frontend specifikáció
## Megvalósitandó funkciók:
- Autentikáció/Regisztráció
- Család létrehozása
- Családtagok felvétele
- Vásárlólista megosztása
- Mások vásárlólistáinak szerkesztése
- Esemény létrehozása
- Mások eseményeinek böngészése/elfogadása
- Profil személyreszabása (becenév adás, családi fotó alkalmazás témának...)

## Felület előzetes terve: 
![scanner_20220221_192645](https://user-images.githubusercontent.com/61094345/155011313-1ac83d23-1431-4a2d-8f99-d90ee1048a72.jpg)

### Felület elemeinek magyarázata (*számozottak az egyes nézetek jobb vagy bal sarokban*):
1. Bejelentkezés: itt lehet bejelentkezni 1) regisztrált felhasználónévvel/emaillel + jelszóval vagy facebookkal vagy google felhasználóval
2. Regisztráció: itt létre lehet hozni felhasználónév vagy emailcímmel + jelszóval egy új accountot
3. Családok listája: itt felvannak sorolva azok a családok, melyeknek tagjai vagyunk, és ezekre kattintva kiválaszthatjuk valamelyiket
4. Új család létrehozása/szerkesztése: itt tudunk egy új családot létrehozni (hasonló ablak jön fel egy meglévő család szerkesztésekor is), itt még csak egy nevet kell megadni a családnak, tagokat később lesz lehetőség hozzáadni.
5. Profil szerkesztése: saját profilt és az ehhez tartozó személyes adatokat lehet itt szerkeszteni
6. Család főmenü: itt vehetünk fel új tagokat a családba illetve innen érjük el a családhoz tartozó eseményeket és bevásárlólistákat
7. Események listája: itt vannak felsorolva a velünk megosztott események illetve az álalunk létrehozott események, illetve itt tudunk új eseményt is létrehozni.
8. Más profiljának a szerkesztése: itt nézhetjük meg más személyes adatait illetve adhatunk neki becenevet/fényképet
9. Új családtag hozzáadása: kereshetünk emberekre az adatbázisból, és találat esetén (ha ezzel a névvel/emailcímmel van regisztrált felhasználó) meghívhatjuk.
10. Bevásárlólisták: itt vannak felsorolva a velünk megosztott bevásárlólisták, a velünk megosztott bevásárlólisták, illetve itt tudunk új listát létrehozni
11. Bevásárlólista szerkesztése/létrehozása: itt adhatjuk meg/nézhetjük meg a vásárlás helyszínét és időpontját (amennyiben más listája, akkor ezeket nem szerkeszthetjük, de a sajátunkét igen), illetve itt vehetünk fel a listára új termékeket (más listájára is), illetve a termékek mellett van egy checkbox, "pipa" azt jelenti, hogy megvéve, "x" azt, hogy nem veszi meg a terméket az illető, üres pedig, hogy még nincs adat erről. 
12. Esemény adatai: itt nézhetjük meg a kiválasztott esemény részleteit (hol, mikor, kikkel) illetve elfogadhatjuk/elutasíthatjuk azt. 
13. Új esemény létrehozása: itt hozhatunk létre új eseményt, megadhatjuk címét, dátumát és leírását, illetve a családtagok listájából kipipálhatjuk azokat, akiket megszeretnénk hívni és elküldhetjük a meghívást, hogy az felkerüljön az ő esemény listájukra is. Hasonlóan néz ki a már létező esemény szerkesztésének is az űrlapja (csak az általunk létrehozott eseményeket szerkeszthetjük, más eseményére kattintva annak részletei jelennek meg szerkesztési lehetőség nélkül)
14. Termék létrehozása/szerkesztése: ezzel a formmal adhatunk hozzá terméket egy listához, itt megadhatjuk a nevét, leíást adhatunk róla illetve az árát is szerkeszthetjük (hasonló az új termék létrehozásának, szerkesztésének és megtekintésének űrlapja, külön nem rajzoltam le mindegyiket)
15. Értesítések:
- Ha valaki nemsokára boltban lesz/esemény kezdődik
- Ha meghívtak egy új családba
- Ha Meghívtak egy új eseményre

## Forstner Bertalan előzetes terve: 
![389200c424264cfcb8752a3b25553d7f-0001](https://user-images.githubusercontent.com/61094345/155015046-e7286749-8a83-4a2b-a5ae-b8e4d3d2da70.jpg)

Néhány dolog, amit másként csinálnék:
- Csak regisztrált személyeket adnék hozzá a családokhoz (tehát nem úgy, hogy először felveszem, bekerül a rendszerbe, majd meghívót küldök neki és végül ha regisztrált, összekapcsolom a kettőt)
- Családtagokat nem kategorizáltam
- Egyszerre több családhoz való tartozást is lehetővé tenném (pl. nagyszülőknek jól jöhet, vagy ha haverokkal is akarsz egy "családot")


