FE:
https://nodejs.org/en/download/prebuilt-installer
npm install -g @angular/cli@13

to run application, be in myMasterFE folder and run:
      ng serve



BE:
SQL Server 9.0
Java 17

start server: mysql.server start
stop server:  mysql.server stop

insertovanje create_service_image.sql:
	mysql -u root -p mymaster < create_service_image.sql

Mobile:




ZAHTEVI:

Useri i admini.

Useri mogu da kace svoje usluge.
Dodavanje usluge: 1.ime 2.opis 3.tip 4.grad 5.cena 6.telefon 7.slike
Usluge mogu da imaju komentare koji se lajkuju.

Blogovi koje pisu useri.
Blogovi imaju lajkove koje lajkuju useri i komentare koje useri mogu da pisu i lajkuju.
Admini mogu da brisu komentare.
Komentari blogova se vracaju iz baze sortirani po broju lajkova.

Usluge isto kao 
