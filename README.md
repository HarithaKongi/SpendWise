# SpendWise

A responsive personal expense tracker built with **React, TypeScript, Vite, Java Spring Boot, and PostgreSQL**.

## Features
- Add income and expense transactions with category, date, payment method, and notes
- Monthly filtering, search, and income/expense type filters
- Monthly balance, income, expenses, and savings-rate cards
- Cash-flow chart and spending overview
- Spring Boot REST API with request validation and persistent database support

## Repository structure
- `frontend/` — React + TypeScript dashboard
- `backend/` — Java 21 + Spring Boot REST API

## Run locally

### 1. Start the backend
Install Java 21 and Maven. From the `backend` directory run:

```bash
mvn spring-boot:run
```

The API starts at `http://localhost:8080`. Local default uses an in-memory H2 database, so data resets when the application restarts.

For PostgreSQL, set:
- `DB_URL=jdbc:postgresql://localhost:5432/spendwise`
- `DB_USERNAME=your_database_user`
- `DB_PASSWORD=your_database_password`
- `DB_DRIVER=org.postgresql.Driver`

### 2. Start the frontend
Install Node.js 20+. From the `frontend` directory run:

```bash
npm install
npm run dev
```

Open `http://localhost:5173`. Copy `.env.example` to `.env` if you need to change `VITE_API_URL`.

## API endpoints
- `GET /api/transactions?month=yyyy-MM` — list transactions, optionally filtered by month
- `POST /api/transactions` — create a transaction
- `PUT /api/transactions/{id}` — update a transaction
- `DELETE /api/transactions/{id}` — delete a transaction
- `GET /api/summary?month=yyyy-MM` — monthly income, expense, and balance

## Deployment
- **Frontend:** deploy `frontend` to Vercel; set `VITE_API_URL` to your deployed API base URL.
- **Backend:** deploy `backend` using its Dockerfile to a Java/Docker host.
- **Database:** use a managed PostgreSQL database and configure the backend environment variables above plus `FRONTEND_URL` with the deployed frontend origin.

Do not commit production credentials. This initial MVP does not include authentication or per-user data isolation, so add those before storing real or sensitive financial records.
