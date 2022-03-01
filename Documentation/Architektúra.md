# Architektúra
A backend architektúrája az MVC elvet követi.

Az alkalmazás architektúrájának váza itt látható:

Ahogy látható, az alkalmazásban az egyedek (**Entity**) építik fel a modellt. Ezek egymással különféle kapcsolatban lehetnek (dependencia, tartalmazás, öröklés stb.), ezeknek a modellezése későbbi feladat UML-ben. Azt azonban biztosan tudjuk, hogy egymással össze vannak kötve, ahogy az a rajzon látszik is: _Entity1_ és _Entity2_ között kapcsolat van (hogy milyen, az a modellezés ezen szakaszában mindegy is). 

A kapcsolatok leírására navigation propertyt használunk, ezek lényegében referenciák a másik hivatkozott objektumre. Ezen kapcsolatok nem ritkán lehetnek (lesznek) körkörösek, amik nehezen sorosíthatók pl. JSON-be. Ennek elhárítására **DTO**-kat használ a program, amik azonos vagy kevesebb tartalommal bírnak, mint az egyedek, viszont nincs köztük körkörös függőség, így egyszerűen sorosíthatók.

Az adatokat (az egyedek reprezentációját) **adatbázis**ban tároljuk. Ez a projektben Oracle vagy MySQL adatbázis lesz. Az adatbázisban az ORM szabályok szerint tárolunk táblákban egyedeket. Az adatbázis feladata a perzisztens adattárolás.

Az adatbázissal a DAL (data access layer) kommunikál. A DAL-t a projektben a **repository**k valósítják meg. Ezen osztályok feladatai az ORM-leképezések az adatb