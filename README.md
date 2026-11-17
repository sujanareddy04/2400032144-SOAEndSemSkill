# Tourist Records API (Spring Boot + JWT + Swagger UI)

## Requirements
- Java 21 or later
- Spring Tool Suite 4/STS with Maven support

## Import into STS
1. Extract this ZIP.
2. Open STS → **File → Import → Maven → Existing Maven Projects**.
3. Browse to the extracted `tourist-records-api` folder and select `pom.xml`.
4. Finish and wait for Maven dependencies to download.
5. Right-click the project → **Run As → Spring Boot App**.

## URLs
- Swagger UI: http://localhost:8080/swagger-ui/index.html
- OpenAPI JSON: http://localhost:8080/v3/api-docs
- H2 console: http://localhost:8080/h2-console (JDBC URL: `jdbc:h2:file:./data/tourists`, user `sa`, blank password)

## Test in Swagger UI
1. Run `POST /api/auth/token` with body:
   `{ "username": "tourism-dashboard" }`
2. Copy the returned `token`.
3. Click **Authorize** in Swagger UI and paste the token only (the UI adds `Bearer`).
4. Call `POST /api/tourists` to create records, then `GET /api/tourists` to retrieve all records.
5. Also test `GET /api/tourists` without authorization: it should return **401 Unauthorized**.
6. Test `GET /api/tourists/{id}`, `PUT /api/tourists/{id}`, and `DELETE /api/tourists/{id}`.

Example tourist JSON:
```json
{
  "fullName": "Aarav Kumar",
  "email": "aarav@example.com",
  "phone": "9876543210",
  "country": "India",
  "preferredDestination": "Araku Valley"
}
```

## Important security note
The token endpoint is intentionally a **demo token issuer** so the project can be tested immediately. It does not authenticate a real account. Before production, replace it with login backed by a user table, password hashing (BCrypt), role/permission checks, secret management, HTTPS, and audit logging. Set a strong `JWT_SECRET` environment variable; never use the demo secret in production.
