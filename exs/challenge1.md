🔐 Level 1 — Token Lifecycle

POST /refresh — refresh an access token using a refresh token
POST /validate — introspect a token (is it valid? who does it belong to?)

🔑 Level 2 — Password Management

POST /change-password — authenticated user changes their own password
POST /forgot-password — trigger Keycloak's reset-password email flow
POST /reset-password — admin resets a user's password directly

👤 Level 3 — User Management

GET /me — fetch the currently authenticated user's profile
PUT /me — update profile (firstName, lastName, email)
DELETE /me — self-delete account

🛡️ Level 4 — Roles & Authorization

POST /admin/roles — create a realm role
POST /admin/users/{id}/roles — assign a role to a user
GET /admin/users — list users (admin only)

📱 Level 5 — MFA / OTP

POST /otp/setup — configure TOTP for a user
POST /otp/verify — verify an OTP code
DELETE /otp/remove — remove OTP from account

🌐 Level 6 — Social Login / Identity Federation

Google / GitHub OAuth2 login via Keycloak identity providers
Token exchange after social login

🔔 Level 7 — Events & Webhooks

Listen to Keycloak login/register/error events via event listeners


🎯 Your Next Challenge — Level 1, Exercise 1
POST /api/auth/refresh
What it should do: Accept a refresh_token in the request body and return a new TokenResponse (new access token + new refresh token).
Hints:

It's a call to the same Keycloak token endpoint you already use in login
The grant_type changes
You already have everything you need in AuthService

Acceptance criteria:

Returns 200 with a fresh TokenResponse on valid refresh token
Returns an error (don't swallow it) when the refresh token is expired or invalid