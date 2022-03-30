# Matyi
## Haladási napló
### 2.-ik hétre

- Egyeztettem Ádámmal, kialakítottuk a közös kommunikációs csatornákat. Beléptem a közös discord szerverre, Trelloba illetve létrehoztam a GitHub repositorymat. Ebben a Repositoryban jelenelg egy kiinduló Android projekt van, illetve a dokumentációk.
- Készítettem egy előzetes specifikációt a frontendre, a rajzolt terveket átnéztem, és ennek ismeretében elkészítettem egy előzetes tervet a frontend-re. Itt minden szükséges nézethez rajzoltam egy kis mintarajzot, és átgondoltam, hogy milyen funkciók hova kell kerüljenek és hogyan lehetne megoldani azokat. Ezekhez a nézetekhez magyarázatokat is írtam illetve összefoglaltam, hogy az eredeti tervhez képest milyen eltérések vannak benne.
- Készítettem egy kiinduló Android Projectetet Emty Compose Activity template-val. Elkezdtem ismerkedni a  JetPack-el, úgy döntöttem hogy ebben készítem el a forntendet. Létrehoztam egy első, log in nézetet az alkalmazásnak (JetPack-el).

### 3.-ik hétre
- A hét folyamán készítettem egy architektúra tervet a frontendnek illetve egy magasszintű leírást a RestApi kommunikációnak: 
- Bővebb specifikáció frontendről: [Frontend specifikáció](https://github.com/Matyi98/MSc-Onlab1/blob/main/Dokument%C3%A1ci%C3%B3k/Architekt%C3%BAra_terv.md).
- Ezeken kívül folytattam a JetPack-al való ismerkedést, az alkalmazásomhoz készítettem további 2 nézetet is, egy regisztrációs formot és egy családi menü nézetet. 
- A héten még egyeztettem Ádámmal arról, hogy a múltheti konzultáción megbeszéltek alapján hogyan módosítjuk a kezdeti elképzeléseinket. 

### 4.-ik hétre
- Átolvastam Ádám kommunikációs protokoll leírását
- Refaktoráltam/újragondoltam a projektem felépítését, készítettem egy "komponensek" mappát, és ide kiszerveztem a nézet újrafelhasználható elemeit.
- Készítettem egy CreateFamily nézetet, ide az alapvető adatokon kívül egy fénykép feltöltésére is van lehetőség
- Elkészítettem a család fő nézetének egy "béta" változatát
- Az android programozás közben pedig tovább ismerkedtem a JetPack-el
- Készítettem egy rövid ütemtervet a hónapra: [Ütemterv](https://github.com/Matyi98/MSc-Onlab1/blob/main/Dokument%C3%A1ci%C3%B3k/%C3%9Ctemterv.md)

### 5.-ik hétre
- Ádámmal bemutattuk egymásnak az eddig elkészült munkánkat
- Segítettünk elindítani a Frontend/Backend részt egymásnak
- A LogIn nézetet elkezdtem bekötni a frontendre
- Olvastam az MVVM architektúráról (~~sajnos a raywenderlich.com -os MVVM tutoriál fizetős volt~~)
- Foglalkoztam továbbá a kódom refaktorálásával, illetve próbáltam kitalálni egy MVVM alapú architektúrát a frontendnek, de ez még nem végleges
- Olvastam a LiveData-ról is

### 6.-ik hétre
- Utánaolvastam a kliens oldali Api kommunikcáió generálására a lehetőségeknek.
- [swagger](https://editor.swagger.io/) generate client -> kotlin segítségével kódot generáltattam
- Az így kapott kódot beintegráltam az eddig elkészült frontendes projektbe
- Helyenként hibát/deprecated-et jelölt az Andriod Studio, néhány dependency-t hozzá kellett adni még a projekthez, hogy működjön is a generált komponens
- Teszteltem ezt Ádám projektjét futtatva. 

### 7.-ik hétre
- Swagger generált kódjának javítása;
  Említésre méltó javítások: 
  - az Android Studio javasolt hibamódosításait elfogadtam, ezzel fordíthatóvá vált a generált kód (itt több hiba és deprecated kódrész is módosításra került)
  - DateAndTime-ra fordította a születési dátumot, viszont mivel ez igazából csak simán Date, hibát okozott, hogy a backend nem küldött vissza születési órát, percet, másodpercet, így mindenütt a generált kódban a LocalDate-ra módosítottam a LocalDateAndTimet; Ezenkívül a Json alakításai során szükség volt egy adapter osztályra, amit innen másoltam: [LocalDateAdapter](https://stackoverflow.com/questions/57972766/java-lang-illegalargumentexception-platform-class-java-time-localdatetime-with)
  
