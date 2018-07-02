# Uzorci_dizajna_ToF_1
Internet of Things aplikacija s komandnom linijom koja koristi različite uzorke dizajna

<br />

ToF sastoji se od uređaja (senzora, aktuatora i sl) koji primaju kontrolne signale (poruke), obavljaju mjerenja i druge aktivnosti (pomicanje mehanizma, npr. otvaranje ili zatvaranje, paljenje ili gašenje i sl), vraćaju informaciju o mjerenim elementima i statusu. U FOI postoji više prostorija, dvorana, područja i sl. (sve njih zovemo mjesta) na kojima se mogu postaviti uređaji. Podaci o mjestima, senzorima i aktuatorima nalaze se u priloženim datotekama. Datoteke su u formatu CSV (točka zarez) tako da prvi redak sadrži opis strukture datoteke a ostali retci su podaci.

<br />

Na početku je potrebno konfigurirati sustav tako da se za sva mjesta postave potrebni uređaji. Svako mjesto ima zadani broj senzora i aktuatora. Temeljem tipa mjesta potrebno je pridružiti potreban broj senzora koji svojim tipom odgovaraju tipu mjesta. Isto i za aktuatore. Generatorom slučajnog broja odabire se pojedini senzor između onih koji odgovaraju tipu.

<br />

Slijedi inicijalizacija sustava tako da se svakom uređaju pošalje inicijalizacijska poruka. Uređaj vraća svoj status (1 - u redu, 0 – pogreška), temeljem generatora slučajnog broja uz prosječnu 90% ispravnost. Ako je pogreška uređaj se ne koristi u nastavku. U nastavku temeljem odabranog algoritma provjere (potrebno je implementirati min 3 različita algoritma) dretva u zadanim ciklusima provjerava po jedno mjesto s time da jedno mjesto ne može biti dva puta provjereno dok nisu sva ostala mjesta provjerena. Provjera mjesta polazi od utvrđivanja statusa njegovih uređaja. Uređaj koji 3 puta u nizu (3 slijedna ciklusa dretve za isto mjesto) vrati pogrešku, označava se kao neispravan te ga je potrebno odmah zamijeniti novim uređajem istog modela i inicijalizirati. Potrebno je ispisati informacije u obavljanim poslovima.

<br />

Nakon provjere (utvrđivanje stanja) od senzora se traži očitanje vrijednosti i ispiše se informacija o tome. Kod aktuatora se prvo traži očitanje vrijednosti a zatim izvršavanje radnje. Kod onih koji ima binarnu vrstu obavlja se suprotna radnja trenutnom stanju. Kod ostalih se generira slučajni broj u intervalu pojedinog aktuatora.Taj broj se dodaje u smjeru prethodne operacije. Prvo se počinje s povećavanjem vrijednosti. Kada se dođe do maksimalne vrijednosti aktuatora tada se mijenja smjer i počinje se sa smanjivanjem vrijednosti. I tako se provodi šetnja od jedne (min) do druge strane vrijednosti (max) i obratno. Ispisuju se informacije o tome. Nakon što prođe zadano vrijeme izvršavanja programa, više se ne izvršava dretva. Slijedi prikaz statističkih podataka i ostalih informacija o svakom mjestu i njegovim uređajima tijekom rada.
