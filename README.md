# FactoryProductionSystem


# Factory Production Optimization System

## Overview


Este projeto é um sistema completo de gerenciamento de produção industrial
desenvolvido para gerenciar matérias-primas e otimizar as decisões de produção com base no
estoque disponível.

O sistema calcula quais produtos devem ser fabricados para maximizar a
receita total, priorizando produtos de maior valor agregado, respeitando as restrições de matéria-prima.

------------------------------------------------------------------------

# Architecture

O projeto está dividido em:

-   Backend (Quarkus + PostgreSQL)
-   Frontend (Vue.js + Vite)
-   Database running in Docker

------------------------------------------------------------------------

# Tech Stack

## Backend

-   Java
-   Quarkus
-   PostgreSQL
-   REST API
-   JUnit (Unit Tests)

## Frontend

-   Vue.js 3
-   Vite
-   Axios
-   Vue Router
-   Custom CSS Styling

## Infrastructure

-   Docker
-   Docker Compose

------------------------------------------------------------------------

# Project Structure

factory-production-system/

│ ├── docker-compose.yml ├── backend/ └── frontend/

------------------------------------------------------------------------

# How to Run the Project

## 1 - Start Database (Docker)
Na raiz do projeto:

docker compose up -d

Isso iniciará o PostgreSQL em:

localhost:5432

Banco de dados: - Nome: factorydb - Usuário: factory - Senha: factory123

------------------------------------------------------------------------

## 2 - Run Backend

Navigate to backend folder:

``cd backend``

Run:

``./mvnw quarkus:dev``

Backend rodando em:

http://localhost:8080

Swagger UI:

http://localhost:8080/q/swagger-ui

------------------------------------------------------------------------

## 3 - Run Frontend

Navigate to frontend folder:

``cd frontend``

Install dependencies:

``npm install``

Run development server:

``npm run dev``

Frontend runs at:

http://localhost:5173

------------------------------------------------------------------------

# Backend Features

## Entities

-   RawMaterial
-   Product
-   ProductMaterial (Product Composition)

## CRUD Operations

Full CRUD for: - Raw Materials - Products - Product Composition

## Production Optimization Algorithm

Endpoint:

GET /production/suggest


O algoritmo:

1. Ordena os produtos por preço (em ordem decrescente).

2. Calcula a produção máxima com base no estoque disponível.

3. Deduz os materiais utilizados.

4. Retorna as quantidades sugeridas e a receita total.

Objetivo:

Maximizar o valor total das vendas utilizando as matérias-primas disponíveis.

------------------------------------------------------------------------

# Frontend Features

## Pages

-   Raw Materials (CRUD)
-   Products (CRUD)
-   Product Composition
-   Production Simulation

## UI Features

-   Responsive layout
-   Styled tables
-   Form validation via basic Vue bindings
-   Navigation bar
-   Production calculation results display

------------------------------------------------------------------------

# Example Workflow

1.  Create Raw Materials
2.  Create Products
3.  Define Product Composition
4.  Navigate to Production page
5.  Click "Calculate Production"
6.  System returns optimized production plan

------------------------------------------------------------------------

# Unit Tests

O backend contém testes unitários para:

-   ProductionService
-   Production calculation validation

Run tests:

./mvnw test

------------------------------------------------------------------------

# API Endpoints Summary

## Raw Materials

GET /materials POST /materials PUT /materials/{id} DELETE
/materials/{id}

## Products

GET /products POST /products PUT /products/{id} DELETE /products/{id}

## Product Composition

GET /product-materials GET /product-materials/product/{productId} POST
/product-materials DELETE /product-materials/{id}

## Production

GET /production/suggest

------------------------------------------------------------------------

