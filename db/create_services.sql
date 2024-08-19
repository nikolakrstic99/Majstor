-- Services for user_id = 1
INSERT INTO mymaster.service(id, l1Category, l2Category, user_id, description)
VALUES
(1, "Gradjevinski radovi", "Moler", 1, "Kao profesionalni moler, nudim usluge farbanja unutrašnjih i spoljašnjih površina. Cena po kvadratnom metru je 18 EUR, a radim i pripremu površina pre farbanja."),
(2, "Gradjevinski radovi", "Gipsar", 1, "Specijalizovan za postavljanje gipsanih ploča i izradu pregradnih zidova. Cena je 22 EUR po kvadratnom metru, uključuje i završnu obradu."),
(3, "Gradjevinski radovi", "Fasader", 1, "Nudim usluge oblaganja fasada sa različitim materijalima. Cena je 50 EUR po kvadratnom metru, uz mogućnost prilagođavanja materijala i boje."),
(4, "Elektronika", "Elektricar", 1, "Pružam usluge instalacije i popravke električnih sistema. Cena zavisi od kompleksnosti posla i vrsta usluga."),
(5, "Elektronika", "Serviser racunara", 1, "Nudim popravku i optimizaciju računara. Cena je od 40 EUR, uključuje dijagnostiku i popravku hardverskih i softverskih problema."),
(6, "Odrzavanje", "Domar", 1, "Kao domar, nudim usluge održavanja i popravki u objektima. Cena zavisi od vrste posla i složenosti.");

-- Services for user_id = 2
INSERT INTO mymaster.service(id, l1Category, l2Category, user_id, description)
VALUES
(7, "Elektronika", "Elektricar", 2, "Kao električar, nudim instalaciju i popravku električnih sistema. Cena zavisi od vrste posla, a pružam i savete za energetske uštede."),
(8, "Elektronika", "Serviser racunara", 2, "Specijalizovan za popravku i održavanje računara. Cena usluga je od 35 EUR, uključuje podršku za instalaciju softvera i hardverske popravke."),
(9, "Vodovod i sanitarije", "Vodoinstalater", 2, "Pruža usluge instalacije i popravke vodovodnih sistema. Cena zavisi od složenosti posla, nudim i savete za unapređenje vodovodnih instalacija."),
(10, "Vodovod i sanitarije", "Montazer sanitarija", 2, "Specijalizovan za ugradnju sanitarnih uređaja i opreme. Cena zavisi od vrste uređaja i kompleksnosti instalacije."),
(11, "Obrada materijala", "Bravar", 2, "Kao bravar, nudim usluge izrade i popravke metalnih konstrukcija. Cena zavisi od vrste i složenosti rada.");

-- Services for user_id = 3
INSERT INTO mymaster.service(id, l1Category, l2Category, user_id, description)
VALUES
(12, "Vodovod i sanitarije", "Vodoinstalater", 3, "Nudim profesionalne usluge instalacije i popravke vodovodnih sistema. Cena zavisi od složenosti posla, uključuje i savetovanje o poboljšanju sistema."),
(13, "Vodovod i sanitarije", "Montazer grejnih instalacija", 3, "Specijalizovan za instalaciju i popravku grejnih sistema. Cena zavisi od vrste instalacije i složenosti posla."),
(14, "Odrzavanje", "Cistacica", 3, "Nudim usluge čišćenja stambenih i poslovnih prostora. Cena zavisi od veličine prostora i učestalosti čišćenja."),
(15, "Odrzavanje", "Domar", 3, "Kao domar, nudim sve vrste održavanja i popravki u objektima. Cena zavisi od obima posla i složenosti."),
(16, "Obrada materijala", "Tapetar", 3, "Specijalizovan za tapaciranje nameštaja i oblaganje tapetama. Cena zavisi od materijala i površine koju treba obraditi.");

-- Services for user_id = 4
INSERT INTO mymaster.service(id, l1Category, l2Category, user_id, description)
VALUES
(17, "Obrada materijala", "Bravar", 4, "Nudim izradu i popravku metalnih konstrukcija, uključujući vrata i prozore. Cena zavisi od vrste i složenosti konstrukcije."),
(18, "Obrada materijala", "Tapetar", 4, "Pruža usluge tapaciranja i oblaganja nameštaja. Cena zavisi od vrste materijala i obima posla."),
(19, "Vodovod i sanitarije", "Montazer sanitarija", 4, "Specijalizovan za instalaciju sanitarnih uređaja. Cena zavisi od vrste i broja uređaja, kao i složenosti instalacije.");

-- Services for user_id = 5
INSERT INTO mymaster.service(id, l1Category, l2Category, user_id, description)
VALUES
(20, "Obrada materijala", "Staklorezac", 5, "Kao staklorezac, nudim usluge rezanja i obrade staklenih površina. Cena zavisi od vrste stakla i složenosti obrade."),
(21, "Obrada materijala", "Krojac", 5, "Specijalizovan za krojenje tkanina i drugih materijala. Cena zavisi od vrste i količine materijala koji se kroji.");

-- Services for user_id = 6
INSERT INTO mymaster.service(id, l1Category, l2Category, user_id, description)
VALUES
(22, "Odrzavanje", "Cistacica", 6, "Nudim profesionalne usluge čišćenja za stambene i poslovne prostore. Cena zavisi od veličine prostora i učestalosti čišćenja."),
(23, "Odrzavanje", "Domar", 6, "Kao domar, pružam sve vrste usluga održavanja i popravki. Cena zavisi od vrste posla i složenosti zadatka.");

-- Services for user_id = 7
INSERT INTO mymaster.service(id, l1Category, l2Category, user_id, description)
VALUES
(24, "Automobilska industrija", "Automehanicar", 7, "Nudim sve vrste popravki i održavanja automobila. Cena zavisi od vrste kvara i modela vozila."),
(25, "Automobilska industrija", "Vulkanizer", 7, "Specijalizovan za montiranje i balansiranje pneumatika. Cena usluga zavisi od vrste i broja pneumatika.");

-- Services for user_id = 8
INSERT INTO mymaster.service(id, l1Category, l2Category, user_id, description)
VALUES
(26, "Gradjevinski radovi", "Limar", 8, "Kao limar, nudim izradu i ugradnju limenih konstrukcija. Cena zavisi od složenosti i vrste posla."),
(27, "Gradjevinski radovi", "Izolater", 8, "Specijalizovan za ugradnju termo i zvučne izolacije. Cena zavisi od materijala i površine koja se izoluje.");

-- Services for user_id = 9
INSERT INTO mymaster.service(id, l1Category, l2Category, user_id, description)
VALUES
(28, "Gradjevinski radovi", "Pomocni radnik", 9, "Nudim pomoćne radove u građevini. Cena zavisi od vrste i obima posla."),
(29, "Gradjevinski radovi", "Postavljanje podnih povrsina", 9, "Specijalizovan za postavljanje različitih vrsta podnih površina. Cena zavisi od vrste materijala i složenosti posla.");

-- Services for user_id = 10
INSERT INTO mymaster.service(id, l1Category, l2Category, user_id, description)
VALUES
(30, "Gradjevinski radovi", "Secenje i busenje", 10, "Pruža usluge sečenja i bušenja materijala. Cena zavisi od vrste materijala i složenosti posla."),
(31, "Gradjevinski radovi", "Gradjevinski stolar", 10, "Nudim usluge izrade i ugradnje drvenih konstrukcija. Cena zavisi od vrste i složenosti posla.");

-- Services for user_id = 11
INSERT INTO mymaster.service(id, l1Category, l2Category, user_id, description)
VALUES
(32, "Gradjevinski radovi", "Parketar", 11, "Nudim usluge postavljanja i obnavljanja parketa. Cena je 30 EUR po kvadratnom metru za novo postavljanje, a 25 EUR za obnavljanje."),
(33, "Gradjevinski radovi", "Gipsar", 11, "Specijalizovan za postavljanje gipsanih ploča. Cena je 25 EUR po kvadratnom metru, uključuje i završnu obradu."),
(34, "Gradjevinski radovi", "Fasader", 11, "Nudim oblaganje fasada sa termoizolacijom. Cena je 55 EUR po kvadratnom metru, uz mogućnost prilagođavanja materijala."),
(35, "Vodovod i sanitarije", "Vodoinstalater", 11, "Pruža usluge instalacije i popravke vodovodnih sistema. Cena zavisi od složenosti posla i vrste instalacije."),
(36, "Elektronika", "Serviser racunara", 11, "Specijalizovan za popravku i optimizaciju računara. Cena je od 35 EUR, uključuje dijagnostiku i popravku problema."),
(37, "Odrzavanje", "Domar", 11, "Nudim usluge održavanja i hitnih popravki. Cena zavisi od vrste posla i složenosti zadatka.");


SELECT * FROM mymaster.service;