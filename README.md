## Metode i tehnike testiranja programske podrške - projektni zadataka: Automatizirano testiranje - Selenium  


Projekt je izrađen u InteliJ koristeći selenium WebDriver, Java programski jezik i TestNG testni okvir.
Testirala se je web stranica smite.guru koristeći Google Chrome.


## Korištene tehnologije:

InteliJ IDE-Razvojno okruženje
Java JDK-Razvojni alati kao i kompailer za Java programski jezik
Maven-Alat za automatizaciju buildova i upravljanje dodatnim library-ima ("dependencys managment")
TestNG-Testni okvir za javu, omogućuje testne anotacije kao "@Test", grupiranje i davanje prioriteta testovima
Rest assured-automatizirano testiranje zahtjeva na bazi HTTP (nije bilo moguće koristiti jer testirana web stranica onemogućuje automatizirano testiranje HTTP zahtjeva)
Selenium WebDriver-alat za upravljanje web stranicama programski, omogućuje njihovo automatizirano testiranje
Chrome Driver-izvršna datoteka koja omogućuje web driveru upravljanje Google Chrome aplikacijom
Xpath- 

## Testovi

Prije početka testova otvara se Google Chrome te se odlazi na početni url tj. google.com. Zatim se izvršava glavnih 6 testova.
Napomena za testove: Svi testovi sadrže funkcije "sleep" koje pauziraju daljnje izvršavanje koda dok web preglednik ne učita sve elemente stranice u potpunosti. U slučaju pojave captcha ostavljeno je dovoljno vremena kako bi se ona manualno rješila.

1. GoogleSearchTest
   -Maksimizira se prozor preglednika
   -Traži se element preglednika s imenom q tj. glavna traka za unos i unosi se naziv stranice
   -Klikne se gumb za gašenje prozora za kolačiće
   -Provjerava se dali prvi rezultat pretrage nudi link na stvarnu stranicu smite.guru

2. SiteLoadTest
   -Klikne se na link prvog rezultata prijašnje pretrage i odlazi se na web stranicu smite guru
   -Uklanja se prozor za kolačiće
   -Provjerava se dali je otvorena prava stranica provjerom atributa "title" web stranice

3. SearchPlayerAccountTest
   -U glavno polje za unos imena korisnikovog računa se upisuje poznato točno ime računa
   -Potvrđuje se unos
   -Provjerava se text koliko je računa pronađeno s istim imenom, očekivano je pronači 1 takav račun

4. LoadBuildsTabTest
   -Pritisak na gumb za navigaciju na "Build" tab
   -Provjerava se title stranice kako bi se zaključilo dali je učitanja prava pod stranica 

5. ImageSourceTest
   -Na "Build" tab-u se provjerava prva slika u tablici i dali je uspješno učitana
   -Alternativno ako stranica to dopušta moguće je provjeriti izvor slike s rest.assured plugin-om. Prvo je potrebno putem xpath-a dobiti izvor slike te napravit HTTP zahtjev na tu adresu te provjeriti dali zahtjev vrača kod 200 što znači da je uspješan.
   
6. LoginTest
   -Odlazi se na stranicu za login
   -Odabire se Steam kao vrsta autentifikacije
   -Unose se kriva zaporuka i korisničko ime
   -Provjerava se dali je kao i očekivano login bio ne uspješan

   Nakon svih testova gasi se Google Chrome.


