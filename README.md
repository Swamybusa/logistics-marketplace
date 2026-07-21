# 🚚 Logistics Marketplace - Real-Time Shipment Tracking Platform

A full-stack logistics marketplace application that connects **Shippers** and **Carriers** through shipment creation, bidding workflow, and real-time GPS tracking.

The platform allows shippers to create shipment requests, carriers to place bids, and both users to monitor shipment progress using live location updates powered by WebSockets.

---

## 📌 Project Overview

The Logistics Marketplace solves the problem of connecting businesses that need transportation services with carriers who can fulfill shipment requirements.

### Main Features

* User authentication with JWT
* Role-based access control (SHIPPER / CARRIER)
* Shipment creation and management
* Carrier shipment discovery
* Bidding system
* Bid acceptance workflow
* Real-time shipment tracking
* Interactive map-based location display
* Automatic WebSocket reconnection
* Responsive dashboards

---

# 🛠 Tech Stack

## Backend

* Java
* Spring Boot
* Spring Security
* JWT Authentication
* Spring WebSocket (STOMP)
* PostgreSQL
* Maven
* REST APIs

## Frontend

* React.js
* React Router
* Axios
* Leaflet Maps
* SockJS
* STOMP Client
* CSS3

---

# 🏗 System Architecture

```
                 React Frontend
                       |
                       |
                 REST APIs
                       |
                       |
              Spring Boot Backend
              /       |        \
             /        |         \
       PostgreSQL   JWT     WebSocket
                              |
                              |
                    Live Shipment Updates
                              |
                              |
                         Leaflet Map
```

---

# 👥 User Roles

## 🚚 Shipper

Features:

* Register/Login
* Create shipments
* View shipment status
* View carrier bids
* Accept bids
* Track shipments
* Cancel shipments

---

## 🚛 Carrier

Features:

* Register/Login
* View available shipments
* Place bids
* Manage assigned shipments
* Update shipment location
* Mark shipments delivered

---

# 📦 Shipment Workflow

```
Shipment Created

        ↓

BIDDING

        ↓

Carrier Places Bid

        ↓

Shipper Accepts Bid

        ↓

AWAITING_PICKUP

        ↓

IN_TRANSIT

        ↓

DELIVERED
```

---

# 💰 Bidding Workflow

1. Carrier views available shipments
2. Carrier submits a bid
3. Shipper reviews bids
4. Shipper accepts one bid
5. Accepted bid becomes active
6. Other bids are automatically rejected
7. Shipment moves to AWAITING_PICKUP

---

# 📍 Real-Time Tracking Architecture

The application uses Spring WebSocket with STOMP messaging.

## Flow

```
Driver Location Update

        ↓

Spring Boot WebSocket Endpoint

        ↓

Shipment Topic

/topic/shipments/{shipmentId}

        ↓

React Tracking Component

        ↓

Leaflet Map Update
```

## WebSocket Features

✅ Shipment-specific topics
✅ Live coordinate updates
✅ React map movement
✅ Automatic reconnect support

Example:

```javascript
reconnectDelay: 5000
```

If the network connection drops, the client automatically attempts reconnection.

---

# 🔐 Security

Implemented using Spring Security and JWT.

Features:

* Token-based authentication
* Protected APIs
* Role-based authorization
* Shipper/Carrier data separation

---

# 🌐 API Overview

## Authentication

```
POST /auth/login
```

---

## Shipments

Create shipment:

```
POST /api/shipments
```

Get shipments:

```
GET /api/shipments
```

Get shipment details:

```
GET /api/shipments/{id}
```

Start shipment:

```
PUT /api/shipments/{id}/start
```

Deliver shipment:

```
PUT /api/shipments/{id}/deliver
```

---

## Bidding

Create bid:

```
POST /api/bids
```

Accept bid:

```
PUT /api/bids/{bidId}/accept
```

---

## Tracking

Update location:

```
POST /api/tracking-locations
```

Latest location:

```
GET /api/tracking-locations/latest/{shipmentId}
```

WebSocket endpoint:

```
/ws
```

Subscription:

```
/topic/shipments/{shipmentId}
```

---

# 🖥 Application Screenshots

Add screenshots here:

* Login Page
* Shipper Dashboard
* Carrier Dashboard
* Shipment Bidding
* Live Tracking Map

Example:

```
/screenshots/login.png
/screenshots/dashboard.png
/screenshots/tracking.png
```

---

# ⚙️ Running the Application

## Backend

Clone repository:

```bash
git clone <repository-url>
```

Navigate:

```bash
cd logistics-marketplace
```

Run:

```bash
mvn spring-boot:run
```

Backend runs on:

```
http://localhost:8080
```

---

## Frontend

Navigate:

```bash
cd logistics-tracking-ui
```

Install dependencies:

```bash
npm install
```

Start application:

```bash
npm start
```

Frontend runs on:

```
http://localhost:3000
```

---

# 📂 Project Structure

```
logistics-marketplace

├── backend
│   ├── controller
│   ├── service
│   ├── repository
│   ├── entity
│   ├── security
│   └── websocket
│
└── frontend
    ├── pages
    ├── components
    ├── services
    └── styles
```

---

# 🚀 Future Enhancements

* Driver mobile application
* Google Maps integration
* Payment gateway
* Email/SMS notifications
* Advanced shipment filtering
* Analytics dashboard

---

# 👨‍💻 Author

**Swamy Busa**

MCA Graduate | Java Full Stack Developer

---

# ⭐ Project Highlights

This project demonstrates:

* Full-stack development
* Spring Boot REST API design
* JWT security implementation
* Real-time WebSocket communication
* React dashboard development
* Map-based tracking system
* Marketplace business workflow
