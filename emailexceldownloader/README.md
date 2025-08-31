# Email Excel Downloader

A Spring Boot application to download Excel attachments from emails (Gmail) and save them to a local directory. Users can trigger the download with a **single button click** from a web UI.

---

## Features

- Connects to Gmail using **IMAP**.
- Fetches the latest email with `.xlsx` attachment.
- Saves Excel files to a **local directory**.
- Simple **Thymeleaf-based UI** with a download button.
- Displays success/error messages after download.

---

## Project Structure
emailexceldownloader/
│
├─ src/main/java/com/example/emailexceldownloader/
│ ├─ controller/
│ │ └─ EmailController.java
│ ├─ service/
│ │ └─ EmailService.java
│ ├─ config/
│ │ └─ MailConfig.java
│ └─ EmailExceldownloaderApplication.java
│
├─ src/main/resources/
│ ├─ templates/
│ │ └─ index.html
│ ├─ application.properties
│
└─ pom.xml

---

## Prerequisites

- Java 17+
- Maven
- Gmail account with **App Password** (required if 2FA is enabled)
- Internet connection to access Gmail IMAP

---

## Setup Instructions

1. **Clone the project** or create a new Spring Boot project with the same structure.
2. **Configure `application.properties`**:

```properties
spring.mail.host=imap.gmail.com
spring.mail.port=993
spring.mail.username=your_email@gmail.com
spring.mail.password=your_app_password
spring.mail.properties.mail.store.protocol=imaps

file.save-dir=C:/excel-downloads

Ensure the save directory exists or will be auto-created.

Build and run the project:
mvn clean install
mvn spring-boot:run

Open your browser at http://localhost:8080/.

Click Download Latest Excel to fetch the latest Excel attachment from your inbox.
