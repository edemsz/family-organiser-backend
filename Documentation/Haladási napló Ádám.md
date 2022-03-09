# Ádám
## 2. hétre
Elkészítettem a GitHub repómat, a Discord szervert, a Trello boardot, egyszóval mindent, ami a szervezéshez kell.

A specifikációval is haladtam, megírtam kezdetleges szinten, közben végiggondoltam, hogy hogy lehetne nagy vonalakban megvalósítani a projektet. A dokumentációkat az én repómba írjuk, hogy egy helyen legyenek.

Az alap backend részt felhúztam. Eldöntendő még, hogy milyen adatbázist használjunk: nekem viszonylagos tapasztalatom a MySQL-lel van, de a BME-s Oracle szerver is felmerült bennem használatra.

Megrajzoltam a specifikáció alapján egy kezdetleges ER-diagramot: ezen az egyedek és kapcsolatok egész jól látszanak, de persze tulajdonságok még bőven hozzáadhatók bárhova (és hozzá is adandók pár helyre). Több egyedet viszont nem találtam a specifikáció alapján. Az ER-diagram alapján könnyen lehet majd táblákat definiálni, csak először legyen meg, hogy tényleg ezeket az egyedeket érdemes-e felvenni.

Kotlin ismereteimet felfrissítettem, ugyanis volt egy lyukasórám, és beültem Ekler Péterhez Androidra, ahol a Kotlinról (is) volt szó. :)

Matyival egyeztettem a kommunikációs protokollról, és természetesen a REST API-ban állapodtunk meg. A konkrét végpontokat majd a későbbiekben egyeztetjük.

## 3. hétre
Megírtam a backend architektúrájának a felépítését. Ehhez leírásokat néztem, hogy hogy kellene egy Spring MVC app architektúráját megtervezni. Ezzel kapcsolatban az még kérdéses bennem, hogy az adatbázishoz kapcsolódáshoz sok repositoryt használjunk vagy egy DAO-t. Saját ábrát is csináltam, hogy hogy képzelem el a komponensek közötti kommunikációt.

Megírtam a FamilyMember osztályait az architektúra alapján. Még nem tökéletes, de már mutatja, hogy hogy kellene kivitelezni a többit is.

Az alkalmazásba sikeresen beimportáltam a Swaggert. Ezekhez útmutatókat néztem. A standard erroros endpointokat (amiket alapból mutat a Swagger) kivettem, most már csak a FamilyMemberService endpointjai látszanak.

Konzultáltam a többiekkel az előző konziról.

Felvettem egy DataLoader osztályt, ami a szükséges adatokkal feltölti induláskor a memóriát.

Konzultátam Matyival a Swaggerről.

## 4. hétre
Megterveztem a REST API végpontokat, hogy melyik funkciót hogyan érdemes elérni a jövőben a frontendről. Erről írtam egy swagger.yaml fájlt is.

A végpontokat leprogramoztam a controllerekbe: a megfelelő függvényeket felvettem a controllerekbe megfelelő paraméterekkel és visszatérési értékekkel.

DTO-kat definiáltam a többféle felhasználási területre, amiket a REST API kidolgozásakor használtam is.