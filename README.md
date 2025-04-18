# Spring-security-authorization-API

A clean, modular Spring Boot-based authorization system using BCrypt encoder and JWT tokens. Designed for extensibility and security, without OAuth dependencies.

---

##  Features

- User login and registration with hashed passwords
- JWT-based authentication with expiration and refresh support
- Spring Security integration
- Modular folder structure

---

## 🛠️ Tech Stack

- Java 17+
- Spring Boot
- Spring Security
- spring web
- Spring Data JPA 
- PostgreSQL
- JWT (Java Web Token)
- Maven


spring-auth-core/
│
├── src/
│   ├── main/
│   │   ├── java/com/yourname/auth/        # Core backend logic (controllers, services, config)
│   │   └── resources/
│   │       ├── application.yml            # Main configuration (gitignored)
│   │       └── application-example.yml    # Public-safe sample config
│   └── test/
│       └── java/com/yourname/auth/        # Unit and integration tests
│
├── .gitignore                             # Gitignore file to exclude unnecessary files
├── README.md                              # Project documentation
├── pom.xml or build.gradle                # Dependency management
└── LICENSE                                # Open-source license

---

## 📦 Setup
Clone the repo:
   ```bash
   git clone https://github.com/YOUR_USERNAME/spring-auth-core.git
   cd spring-auth-core

