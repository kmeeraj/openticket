# Open Ticket API

This Api provides the services for the users to book ticket, delete ticket and also enabled the service providers to book the show and delete the show

## Build
Run following command to build this application:
* mvn clean install

## Run
Run Spring boot command to run the application
* mvn spring-boot:run

## Package and run
* mvn clean package spring-boot:repackage
* java -jar path/to/your/jarfile.jar com.example.openticket.OpenTicketApplication

## Test

## Examples for query movies
* http://localhost:8080/schedules
* http://localhost:8080/allcityschedule?movieName=JONNY
* http://localhost:8080/cityschedule?movieName=JONNY&cityName=DELHI
* http://localhost:8080/cityscheduleOnDate?movieName=JONNY&cityName=DELHI&movieDate=2022-01-03
* http://localhost:8080/cityscheduleOnDateTime?movieName=JONNY&cityName=DELHI&movieDate=2022-01-03&movieTimeHour=10&movieTimeMinute=30

## Examples for checking tickets sold for a schedule:
* http://localhost:8080/alltickets/37

## Post Request to book a ticket for a schedule:
* http://localhost:8080/tickets/37/11/

## Shows of a theater

* http://localhost:8080/theater/5

## Create a show:
* http://localhost:8080/newShow

* {
"movieId": 2,
"screenId": 3,
"screenHour": 12,
"screenMinute": 55,
"availableSeats": 100,
"movieDate": "2022-01-04"
}

## Delete a ticket:
* http://localhost:8080/deleteTicket/12
