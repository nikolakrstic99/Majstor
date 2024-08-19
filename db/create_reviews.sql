-- Reviews for rated_user_id = 1
INSERT INTO mymaster.review(id, rated_user_id, creator_user_id, rating, text, created_at)
VALUES
(1, 1, 2, 5, "Izvanredan majstor! Sve je urađeno na vreme i prema dogovoru. Toplo preporučujem.", "2024-08-19 20:03:13"),
(2, 1, 3, 4, "Veoma zadovoljan radom. Majstor je bio tačan i profesionalan. Cena je bila malo viša, ali je kvalitet bio odličan.", "2024-08-19 20:15:30"),
(3, 1, 4, 5, "Fantastičan posao! Majstor je prešao sve moje zahteve i završio rad brže nego što sam očekivao.", "2024-08-19 20:25:42"),
(4, 1, 5, 3, "Rad je bio u redu, ali sam imao problema sa rokovima. Nešto skuplje nego što sam planirao.", "2024-08-19 20:35:56"),
(5, 1, 6, 4, "Kvalitetan rad, ali komunikacija je mogla biti bolja. Sve u svemu, zadovoljan sam rezultatom.", "2024-08-19 20:45:20"),
(6, 1, 7, 5, "Odličan majstor! Brzo i efikasno je obavio posao. Preporučujem ga svima koji traže kvalitetan rad.", "2024-08-19 20:55:35"),
(7, 1, 8, 2, "Usluga nije bila zadovoljavajuća. Rokovi su kasnili, a rad nije bio u skladu sa dogovorom. Cena je bila previsoka.", "2024-08-19 21:05:47");

-- Reviews for rated_user_id = 11
INSERT INTO mymaster.review(id, rated_user_id, creator_user_id, rating, text, created_at)
VALUES
(8, 11, 2, 5, "Majstor je izvrstan! Profesionalan i tačan. Ispunio je sve moje zahteve u zadanom roku.", "2024-08-19 21:15:13"),
(9, 11, 3, 4, "Veoma sam zadovoljan uslugom. Cena je bila prihvatljiva, a kvalitet rada odličan.", "2024-08-19 21:25:30"),
(10, 11, 4, 5, "Odličan rad! Majstor je bio stručan i prijatan. Sve je prošlo bez problema.", "2024-08-19 21:35:42"),
(11, 11, 5, 3, "Usluga je bila u redu, ali sam imao neka manja zapažanja u vezi sa rokovima. Kvalitet je bio dobar.", "2024-08-19 21:45:56"),
(12, 11, 6, 2, "Nisam bio zadovoljan uslugom. Majstor je kasnio, a kvalitet rada nije bio u skladu sa očekivanjima. Cena je bila previsoka.", "2024-08-19 21:55:20");

-- Reviews for rated_user_id in [2..5]
INSERT INTO mymaster.review(id, rated_user_id, creator_user_id, rating, text, created_at)
VALUES
(13, 2, 1, 5, "Izvanredno obavljen posao! Veoma profesionalan pristup i tačnost. Preporučujem.", "2024-08-19 22:05:13"),
(14, 2, 3, 4, "Veoma sam zadovoljan. Majstor je odradio posao kako treba, ali bi mogao biti malo brži.", "2024-08-19 22:15:30"),
(15, 3, 1, 5, "Prezadovoljan sam! Rad je bio brzi i kvalitetan. Majstor je bio veoma profesionalan.", "2024-08-19 22:25:42"),
(16, 3, 4, 4, "Dobro obavljen posao, ali je moglo biti bolje u pogledu komunikacije. Kvalitet je dobar.", "2024-08-19 22:35:56"),
(17, 4, 2, 5, "Fantastičan rad! Majstor je bio veoma efikasan i profesionalan. Svi moji zahtevi su ispunjeni.", "2024-08-19 22:45:20"),
(18, 4, 5, 4, "Veoma zadovoljan radom. Kvalitetan posao, ali su rokovi mogli biti bolji.", "2024-08-19 22:55:35"),
(19, 5, 1, 5, "Majstor je odličan! Brzo i kvalitetno obavljen posao. Preporučujem ga svima.", "2024-08-19 23:05:47"),
(20, 5, 3, 2, "Rad nije bio na nivou. Majstor je kasnio i posao nije bio urađen kako treba. Cena je bila previsoka.", "2024-08-19 23:15:56");

-- Reviews for rated_user_id in [6..8]
INSERT INTO mymaster.review(id, rated_user_id, creator_user_id, rating, text, created_at)
VALUES
(21, 6, 1, 4, "Dobar rad, ali malo sporiji nego što sam očekivao. Kvalitet je bio zadovoljavajući.", "2024-08-19 23:25:13"),
(22, 6, 2, 3, "Usluga je bila okej, ali su rokovi i komunikacija mogli biti bolji.", "2024-08-19 23:35:30"),
(23, 7, 1, 5, "Izvanredan rad! Majstor je bio veoma profesionalan i efikasan. Preporučujem ga svakome.", "2024-08-19 23:45:42"),
(24, 7, 2, 4, "Veoma zadovoljan uslugom. Majstor je odradio posao kvalitetno, ali bi komunikacija mogla biti bolja.", "2024-08-19 23:55:56"),
(25, 8, 3, 5, "Odličan posao! Majstor je bio tačan i profesionalan. Sve je prošlo glatko.", "2024-08-20 00:05:20"),
(26, 8, 4, 3, "Kvalitetan rad, ali su rokovi i cena mogli biti bolji. Imao sam neka zapažanja koja nisu ispravljena.", "2024-08-20 00:15:35");

select * from mymaster.review;