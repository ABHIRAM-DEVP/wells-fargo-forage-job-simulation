# Wells Fargo Investment Advisor System

A full-stack portfolio management application built with **Spring Boot (Java)** and **React (JavaScript)**. The application allows advisors to register clients and manage their security portfolios.

---

## 🔒 Security Configuration (No Hardcoded Secrets)

All sensitive configuration parameters are managed using local environment variables, ensuring no passwords or database credentials are hardcoded into the source code or pushed to the repository.

1. Create a `.env` file in the root folder of the project.
2. Define the database credentials in the `.env` file:
```env
DB_URL=jdbc:postgresql://localhost:5432/wells_fargo_portfolio
DB_USERNAME=postgres
DB_PASSWORD=your_database_password
```
*(Both `.env` and `.env.example` are ignored by git).*

---

## 🚀 How to Run

### 1. Database Setup
Ensure PostgreSQL is running locally and create the database named `wells_fargo_portfolio`:
```sql
CREATE DATABASE wells_fargo_portfolio;
```

---

### 2. Backend (Spring Boot)
Open a new PowerShell terminal, navigate to the `Backend` directory, configure the environment variables, and launch the application:

```powershell
cd "C:\Users\HP\Desktop\CODING\9-projects\wellsfargo-project-forage-job-simulation\Backend"
$env:JAVA_HOME='C:\Program Files\Java\jdk-24'
$env:PATH="$env:JAVA_HOME\bin;$env:PATH"
$env:DB_URL='jdbc:postgresql://localhost:5432/wells_fargo_portfolio'
$env:DB_USERNAME='postgres'
$env:DB_PASSWORD='your_database_password'
.\mvnw.cmd spring-boot:run
```
*The backend runs on **http://localhost:8080**.*

---

### 3. Frontend (React)
Open a separate terminal window, navigate to the `Frontend` directory, install dependencies if necessary, and run the start script:

```powershell
cd "C:\Users\HP\Desktop\CODING\9-projects\wellsfargo-project-forage-job-simulation\Frontend"
npm install
$env:PORT=3000
npm start
```
*The frontend runs on **http://localhost:3000**.*

---

## 🛠 Features Built

- **Interactive Dashboard**: Side-by-side management panels for Advisors, Clients, and Securities.
- **Advisor Control**: Create and delete active advisors.
- **Client Portfolio Initialization**: Registering a new client automatically initializes an empty asset portfolio.
- **Asset Trading**: Buy/add securities (Equities, Fixed Income, Crypto, Mutual Funds) directly into any client's portfolio, or sell/delete them.
- **Database Auto-Seeding**: Seeds initial test data (default advisor, clients, and assets) on first start if the database is empty.
