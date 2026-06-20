# Flight Search Backend

Backend aplikacji internetowej umożliwiającej logowanie użytkowników, wyszukiwanie lotów (integracja z AviationStack API) oraz zarządzanie listą ulubionych lotów. Projekt został stworzony w oparciu o framework Spring Boot (Java).

## Technologie
* Java
* Spring Boot: (Web, Data JPA, Security)
* Baza danych: MySQL
* Integracja z zewnętrznym API: AviationStack

---

## Dokumentacja API (Endpointy)

Poniżej znajduje się lista wszystkich dostępnych zapytań HTTP (endpointów) udostępnianych przez aplikację.

### Uwierzytelnianie i Użytkownicy (Auth)
Endpointy odpowiedzialne za rejestrację i logowanie.

| Metoda HTTP | Ścieżka (URL)         | Opis | Wymagane ciało żądania (Body) |
|-------------|-----------------------|------|-------------------------------|
| `POST` | `/api/v1/auth/signup` | Rejestracja nowego użytkownika | Dane użytkownika (email, hasło) |
| `POST` | `/api/v1/auth/login`  | Logowanie użytkownika | Dane logowania (email, hasło) |

### Loty (Flights)
Endpointy służące do wyszukiwania lotów oraz zarządzania bazą lotów.

| Metoda HTTP | Ścieżka (URL) | Opis | Parametry/Body                                                   |
|-------------|---------------|------|------------------------------------------------------------------|
| `GET` | `/api/v1/flights` | Pobranie listy lotów / wyszukiwanie | Opcjonalne parametry filtrowania (np. kod lotniska początkowego) | 

### Ulubione Loty (Favorites)
Endpointy służące do zarządzania ulubionymi lotami konkretnego użytkownika.

| Metoda HTTP | Ścieżka (URL) | Opis | Wymagane ciało żądania (Body) |
|-------------|---------------|------|---------|
| `GET` | `/api/v1/auth/{userId}/favorites` | Pobiera listę wszystkich ulubionych lotów dla danego użytkownika | Brak    |
| `POST` | `/api/v1/auth/{userId}/favorites` | Dodaje nowy lot do ulubionych użytkownika | Id lotu |
| `DELETE` | `/api/v1/auth/{userId}/favorites/{favoriteId}` | Usuwa konkretny wpis z ulubionych (po jego ID) | Brak    |

---

## Konfiguracja i Uruchomienie

1. Skonfiguruj scieżkę do bazy danych w pliku compose.yml
2. Wykonaj `docker-compose up`
3. Wpisz następującą komędę w katalogu Docker aby wgrać bazę danych z pliku sql: ` cmd /c 'docker exec -i mysql-container mysql -uroot -prootpassword flightsearch < flightssearch.sql'` 
4. Dodaj swój klucz API do AviationStack w `application.properties`:
   ```properties
   aviationstack.api.key=TWOJ_KLUCZ_API