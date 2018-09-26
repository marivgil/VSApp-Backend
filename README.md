
# VsappBackend - Vida Solidaria Argentina

[![Build Status](https://travis-ci.org/marivgil/VSApp-Backend.svg?branch=master)](https://travis-ci.org/marivgil/VSApp-Backend)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/83753d2bfff14479a6264cebfcddc211)](https://www.codacy.com/app/marivgil/VSApp-Backend?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=marivgil/VSApp-Backend&amp;utm_campaign=Badge_Grade)

###Servicios REST Publicados

#####GET's
http://localhost:8080/VSApp-BackEnd/rest/servicesUsers/findUserByMail/{mail}

http://localhost:8080/VSApp-BackEnd/rest/receptionCenter/findReceptionCenterByLocation/{nombreLocalidad}

http://localhost:8080/VSApp-BackEnd/rest/streetService/findRequestByRound/{nombreRecorrido}

http://localhost:8080/VSApp-BackEnd/rest/hospitalService/findProductsByHospital/{nombreHospital}

#####POST's
http://localhost:8080/VSApp-BackEnd/rest/receptionCenter/createReceptionCenter

http://localhost:8080/VSApp-BackEnd/rest/servicesUsers/createUser

http://localhost:8080/VSApp-BackEnd/rest/streetService/createRequest

http://localhost:8080/VSApp-BackEnd/rest/hospitalService/createHospitalProduct