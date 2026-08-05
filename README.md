OrbitBuddy is a full-stack satellite tracking application built using Spring Boot, Angular, and CesiumJS. The goal of this project is to fetch satellite orbital data, expose it through a REST API, and visualiz satellites in real time on a 3D globe. This project is being built incrementally using an MVP(Minimum viable product) approach. The satellite infos, such as velocity, delta v, fuel required for orbit change implementing Hohmann transfer and rocket equation, ground tracks, etc. will be added incrementally.



Current Features:

Spring Boot Rest API, ISS(Zarya) mock TLE data, Scheduled backend updates, Angular frontend, CesiumJS 3d earth visualization, 3d ISS model, Live ISS position updates



Planned Features:

Live TLE retrieval from Celestrak, SGP4 orbital propagation, satellite position tracking, multiple satellite support, search and filtering, pagination, DTOs, Global Exception Handling, Validation, Docker, CI/CD, Authentication, delta V calculator, Hohmann transfer planner, fuel estimation using the rocket equaion

Technology Stack:
Frontend

\-Angular, TypeScript, CesiumJS



Database:

MySQL



Backend:
-Java 17, Spring Boot, Spring Scheduler, Spring Data JPA, Maven



Project Progress:

v0.1: Spring Boot Backend

v0.2: Angular Frontend

v0.3: Cesium Earth Visualization

v0.4: 3d ISS model (NASA)

v0.5: Spring Boot and Angular integration



Running the backend:
bash

cd backend/orbitbuddy-spring
mvn spring-boot:run

runs on: localhost:8080



Running the frontend:
bash

cd frontend/orbitbuddy-ng
npm install

ng serve

runs on: localhost:4200



Next milestones:
-Live Celestrak integration

\-Accurate ISS tracking

\-Adding more satellites

\-Orbital calculations

\-Orbit prediction

\-Mission planning tools



Lessons Learned



Throughout OrbitBuddy I learned:



\- Building software incrementally reduces complexity.

\- Mocking external APIs makes development more reliable.

\- Separating frontend and backend responsibilities simplifies debugging.

\- Documentation and versioning are as important as writing code.



\# Why I build OrbitBuddy:
 OrbitBuddy allows me to get good experience in backend, frontend, RESTAPI, and software architecture while exploring orbital mechanics and space engineering as I am from Aerospace Engineering background. Features are added incrementally



