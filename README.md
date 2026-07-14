# Logistics Marketplace

A full-stack logistics marketplace application that connects Shippers and Carriers.  
Shippers can create shipments, receive bids from carriers, accept bids, and track shipments in real time.  
Carriers can view available shipments, place bids, manage assigned shipments, and update live shipment locations.

---

## Project Overview

The Logistics Marketplace provides a platform where:

- Shippers create shipment requests with source, destination, weight, and budget details.
- Carriers view available shipments and place competitive bids.
- Shippers accept the best bid and assign the shipment to a carrier.
- Carriers manage shipment movement and update real-time locations.
- Shippers track shipment locations through an interactive map.

---

# Technology Stack

## Backend

- Java
- Spring Boot
- Spring Security
- JWT Authentication
- Spring Data JPA
- PostgreSQL
- WebSocket
- Maven

## Frontend

- React.js
- React Router
- Axios
- Leaflet Maps
- STOMP WebSocket Client

---

# Features Implemented

## Authentication

- JWT based authentication
- Role-based access control

Roles:

- SHIPPER
- CARRIER

---

## Shipment Management

Shipper can:

- Create shipments
- View shipments
- View shipment details
- View received bids
- Accept bids
- Cancel shipments

Shipment lifecycle:


BIDDING
|
↓
AWAITING_PICKUP
|
↓
IN_TRANSIT
|
↓
DELIVERED


---

## Bidding System

Carrier can:

- View available shipments
- Place bids

When a shipper accepts a bid:

- Selected bid becomes ACCEPTED
- Other bids become REJECTED
- Shipment is assigned to the carrier
- Shipment status changes to AWAITING_PICKUP

---

## Live Shipment Tracking

Implemented using:

- Spring WebSocket
- STOMP protocol
- Leaflet Map

Tracking flow:


Carrier
|
| Update GPS Coordinates
↓
Spring Boot WebSocket Server
|
| Broadcast Location
↓
Tracking Page
|
↓
Live Map Marker Update


---

# Application Flow


User Login
|
↓
Role Based Dashboard
|
↓
Create Shipment (Shipper)
|
↓
Available Shipment Board (Carrier)
|
↓
Place Bid
|
↓
Accept Bid
|
↓
Carrier Assigned
|
↓
Start Shipment
|
↓
Update Location
|
↓
Live Tracking
|
↓
Delivery Completed


---

# Backend API Endpoints

## Authentication


POST /auth/login


---

## Shipment APIs

Create Shipment:


POST /api/shipments


Get Shipments:


GET /api/shipments


Get Carrier Shipments:


GET /api/shipments/carrier/{carrierId}


Start Shipment:


PUT /api/shipments/{id}/start


Deliver Shipment:


PUT /api/shipments/{id}/deliver


---

## Bid APIs

Create Bid:


POST /api/bids


Get Shipment Bids:


GET /api/bids/shipment/{shipmentId}


Accept Bid:


PUT /api/bids/{bidId}/accept


---

## Tracking APIs

Update Location:


POST /api/tracking-locations


Get Latest Location:


GET /api/tracking-locations/latest/{shipmentId}


---

# WebSocket Architecture

Endpoint:


/ws


Topic:


/topic/shipments/{shipmentId}


Process:


Carrier sends location
|
↓
Tracking Location API
|
↓
Database Save
|
↓
WebSocket Broadcast
|
↓
Connected Clients Receive Update


---

# How to Run

## Backend

Requirements:

- Java
- PostgreSQL
- Maven

Run Spring Boot application:


mvn spring-boot:run


---

## Frontend

Install dependencies:


npm install


Start React application:


npm start


---

# Database

Database:


PostgreSQL


Main entities:

- User
- Shipment
- Bid
- Location
- TrackingLocation

---

# Future Improvements

- Real GPS integration
- Payment gateway integration
- Notifications
- Advanced shipment analytics
- Route optimization

---

# Author

Swamy Busa

