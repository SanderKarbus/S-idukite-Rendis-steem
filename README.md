## Funktsionaalsus
- Sõidukite nimekirja kuvamine.
- Vabade sõidukite filtreerimine.
- Sõidukite sorteerimine baashinna järgi.
- Otsing registreerimisnumbri järgi (`HashMap`).
- Sõiduki rentimine (koos polümorfse hinnaarvutusega) ja tagastamine.

## Nõuete täitmine koodis
- **Abstraktsioon:** `Rentable` interface ja `Vehicle` abstraktne klass.
- **Pärilus:** `Car` ja `Motorcycle` pärivad klassist `Vehicle`.
- **Kapseldamine:** Privaatsed väljad ja kontrollitud ligipääsud getterite/setterite kaudu.
- **Polümorfism:** `calculateRentalPrice(int days)` on alamklassides erinevalt üle kirjutatud.
- **Andmestruktuurid:** `ArrayList` sõidukite järjestamiseks ja `HashMap` kiireks otsinguks.

## Käivitamine
1. Veendu, et arvutisse on installitud JDK 17+.
2. Kompileeri kood terminalis:
   ```bash
   javac *.java