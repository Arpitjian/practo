# Healthcare Platform

## Overview
This is a healthcare platform that allows users to search for doctors, hospitals, and specialties by name, city, and specialty. The platform also provides an interface for admins to manage the data, including adding doctors, hospitals, and specialties. Users can view the profiles of doctors and hospitals, with the ability to book appointments at hospitals.

## Features

### For Users:
- **Search Doctors and Hospitals**: Users can search for doctors and hospitals based on name, city, and specialty.
- **Doctor Profiles**: Users can view the detailed profiles of doctors, including their specialties and qualifications.
- **Hospital Profiles**: Users can view hospital profiles and see a list of doctors associated with the hospital.
- **Book Appointments**: Users can book appointments with doctors at hospitals directly from the hospital profile page.

### For Admins:
- **Add Doctor**: Admins can add new doctors to the platform.
- **Add Hospital**: Admins can add new hospitals to the platform.
- **Add Specialty**: Admins can add new specialties that doctors can be associated with.
  
## Technologies Used
- **Frontend**: Thymeleaf, HTML, CSS
- **Backend**: Spring Boot (Java)
- **Database**: MySQL
- **Search Engine**: Elasticsearch

## Setup Instructions

### Prerequisites
- **Java 17+**: For running the Spring Boot application.
- **MySQL**: For database management.
- **Elasticsearch**: For searching doctors, hospitals, and specialties.


### Elasticsearch setup:
if docker is not installed:
  1. brew install docker colima
  2. docker --version
  3. docker pull docker.elastic.co/elasticsearch/elasticsearch:8.6.0
  4. docker run --name elasticsearch -d \
    -p 9200:9200 \
    -p 9300:9300 \
    -e "discovery.type=single-node" \
    docker.elastic.co/elasticsearch/elasticsearch:8.6.0
    curl http://localhost:9200



### Clone the Repository

Clone the repository to your local machine:
```bash
git clone https://github.com/Arpitjian/practo/
cd healthcare-platform
