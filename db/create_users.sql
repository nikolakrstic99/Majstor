INSERT INTO mymaster.users(id, first_name, last_name, email, password, status, location, phone)
VALUES 
(1, "Andrej", "Jokic", "andrej@gmail.com", "andrej123", "REGULAR", "Beograd", "0621482242"),
(2, "Jovana", "Petrovic", "jovana.p@gmail.com", "jovana123", "REGULAR", "Beograd", "0651234567"),
(3, "Marko", "Nikolic", "marko.nik@gmail.com", "marko123", "REGULAR", "Beograd", "0633344556"),
(4, "Milica", "Jovanovic", "milica.j@gmail.com", "milica123", "REGULAR", "Beograd", "0601122334"),
(5, "Stefan", "Savic", "stefan.s@gmail.com", "stefan123", "REGULAR", "Beograd", "0645566778"),
(6, "Ana", "Kovacevic", "ana.k@gmail.com", "ana123", "REGULAR", "Beograd", "0657788990"),
(7, "Nikola", "Vukovic", "nikola.v@gmail.com", "nikola123", "REGULAR", "Beograd", "0622233445"),
(8, "Marija", "Ilic", "marija.i@gmail.com", "marija123", "REGULAR", "Novi Sad", "0603344556"),
(9, "Filip", "Stojanovic", "filip.s@gmail.com", "filip123", "REGULAR", "Novi Sad", "0644455667"),
(10, "Lena", "Markovic", "lena.m@gmail.com", "lena123", "REGULAR", "Nis", "0635566778"),
(11, "Nikola", "Krstic", "nikola@gmail.com", "nikola123", "REGULAR", "Beograd", "0631897714"),
(12, "admin", "admin", "admin@gmail.com", "admin", "ADMIN", "Beograd", "0111234567");

UPDATE mymaster.users
SET password = "$2a$10$zF6qEMnYQu/p3FPdTXS9VOnHK1FqU9ZvIPQcZwRpwYbMgZXWu3cdm"
where id = 1;

UPDATE mymaster.users
SET password = "$2a$10$xrjk9Qw9wZMZgNjXp0/sputT8PtP.JneoGhvyzzWIYNbDks/Ke7f."
where id = 2;

UPDATE mymaster.users
SET password = "$2a$10$sRRWwSqUxnwQ3yVMU4i0/.zn.gElB1EcfEqQ8Sht.Lr96cs2FzjoG"
where id = 3;

UPDATE mymaster.users
SET password = "$2a$10$gvaUkRW4RF7oKZzKFlfbMuS6.JTR54bzqfKH4xWCw0h169p9AL5sG"
where id = 4;

UPDATE mymaster.users
SET password = "$2a$10$uAcVcBlXv3OME6fD8ztb4OYNe0Fz1R1pAo373g3LYjkenCtd2yUeO"
where id = 5;

UPDATE mymaster.users
SET password = "$2a$10$MTjd6PrnhhfM/EZEIt05PesqPgNxcaWrPDGJk1KsH7B9lTCbzxd4S"
where id = 6;

UPDATE mymaster.users
SET password = "$2a$10$GLuAnPOnIz/tWUMCc0PbrO8NSj32mCNXc3BwMpcv13E.VvPUjv3JG"
where id = 7;

UPDATE mymaster.users
SET password = "$2a$10$.xyq1ul.9/b54ytJ.NOqeuDfk16e0tRaVfgvlI/M66L6CGGGPhH3y"
where id = 8;

UPDATE mymaster.users
SET password = "$2a$10$ev5dK1XMic.1ZyftxVFbmedrQf1kv9KK75nD.wECLlx4OeFtn1AnW"
where id = 9;

UPDATE mymaster.users
SET password = "$2a$10$N61fKVbv9CbkY37B0CMi0uRO4uyPO2JFyEquViFGtMxouyhtYdMSi"
where id = 10;

UPDATE mymaster.users
SET password = "$2a$10$K/4vEg00pLLtuJierXeLauMOfj.t5cNPIbgIdekuLqIMWBstPcPAG"
where id = 11;

UPDATE mymaster.users
SET password = "$2a$10$QjhAslSvSYYfkYg/6PEw/OB8ZACHWuoGQeB1GA6vKS9N9cuWRxPoO"
where id = 12;

SELECT * FROM mymaster.users