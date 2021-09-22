# dept_user_service
Department is mapped to User . 
Postman Collection link:

https://www.getpostman.com/collections/38a2ed062141ced3c4e3

Post request for Department creation:
http://localhost:9191/departments/
{
	"depName":"IT" ,
	"depAddress":"Bangalore",
	"depCode":"IT-006"
}

Post request for User creation:
http://localhost:9191/users/
{
	"firstName" : "Bodhisatya",
	"lastName" : "Chatterjee",
	"email" : "bodhi14688@gmail.com",
	"depId" : "1"
}

Get request to review actuator health conditions:
http://localhost:9191/actuator/health
