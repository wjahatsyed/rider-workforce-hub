# 🚴 RiderWorkforceHub

A scalable, event-driven microservices platform that manages rider onboarding, work scheduling, performance incentives, and wallet operations for gig-economy logistics providers. Designed using **Java**, **Kotlin**, **Spring Boot**, **Kafka**, and **Kubernetes**, this project demonstrates full-stack engineering leadership with a focus on real-world logistics and workforce challenges.

---

## 📌 Table of Contents

- [Overview](#overview)
- [Architecture](#architecture)
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Getting Started](#getting-started)
- [Services Overview](#services-overview)
- [Project Structure](#project-structure)
- [Contributing](#contributing)
- [License](#license)

---

## 🔍 Overview

RiderWorkforceHub simulates the core systems used by platforms like Delivery Hero to manage their rider fleet at scale. It covers:

- Rider profile and KYC onboarding
- Work availability and shift scheduling
- Incentive calculation and leaderboard tracking
- Wallet earnings and withdrawal flows
- Metrics exposure, logging, alerting

The system is built as a distributed set of microservices with both **Java** and **Kotlin** implementations, allowing hybrid stack leadership and codebase governance.

---

## 🏗️ Architecture

+----------------+ +---------------------+ +------------------+
| rider-service | --> | schedule-service | --> | incentive-service|
+----------------+ +---------------------+ +------------------+
| | |
| Kafka Events | Kafka Events |
v v v
+----------------+ +--------------------+ +---------------------+
| wallet-service | <-- | api-gateway | --> | admin-ui (optional) |
+----------------+ +--------------------+ +---------------------+

Support: PostgreSQL, Redis, Kafka, JWT Auth, Kubernetes, Helm, Terraform

---

## 🚀 Features

| Domain         | Features Included |
|----------------|-------------------|
| Rider Onboarding | Register rider, upload documents, track status |
| Scheduling       | Set availability, assign shifts, check live status |
| Incentives       | Kafka event-driven points system, goal tracking |
| Wallet           | Earnings history, withdrawal requests, balances |
| Observability    | Prometheus metrics, Grafana dashboards |
| Infrastructure   | Helm charts, Terraform modules, GitHub Actions CI/CD |

---

## 🧰 Tech Stack

- **Languages**: Java 17, Kotlin
- **Frameworks**: Spring Boot, Spring Cloud, gRPC
- **Messaging**: Apache Kafka
- **Database**: PostgreSQL, Redis
- **Authentication**: JWT, API Gateway
- **DevOps**: Docker, Kubernetes, Helm, Terraform
- **Monitoring**: Micrometer, Prometheus, Grafana
- **CI/CD**: GitHub Actions

---

## 🛠️ Getting Started

### 1. Clone the Repository
```bash
git clone https://github.com/your-username/rider-workforce-hub.git
cd rider-workforce-hub
2. Start with Docker Compose (local)
bash
docker-compose up --build
3. Run All Services Individually (for dev)
Each service has a README and application.yml under src/main/resources.

4. Access APIs via Gateway
GET http://localhost:8070/api/riders
POST http://localhost:8070/api/incentives/events
🧩 Services Overview
Service	Language	Purpose
rider-service	Java	Onboarding, profile, documents
schedule-service	Kotlin	Shift assignment, availability
incentive-service	Java	Incentive tracking via Kafka
wallet-service	Kotlin	Earnings, balance, withdrawal
api-gateway	Java	JWT auth, request routing
common-lib	Java/Kotlin	Shared DTOs and configs
infra/	YAML/HCL	Helm charts, Terraform scripts

📁 Project Structure

rider-workforce-hub/
│
├── rider-service/              # Java-based Rider API
├── schedule-service/           # Kotlin-based shift manager
├── incentive-service/          # Kafka consumer and point tracker
├── wallet-service/             # Kotlin-based wallet + payout logic
├── api-gateway/                # Spring Cloud Gateway with JWT auth
├── common-lib/                 # Shared code (DTOs, utils)
├── infra/                      # Terraform modules, Helm charts
├── docker-compose.yml
└── .github/workflows/          # CI/CD pipelines
🤝 Contributing
Contributions are welcome! Please open issues or submit PRs with improvements, bugs, or enhancements.

📄 License
This project is licensed under the MIT License - see the LICENSE file for details.

Built with ❤️ by Wajahat Syed to demonstrate engineering leadership, event-driven architecture, and DevSecOps maturity.


