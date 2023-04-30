# Java API Project

An application in java which provides a REST API with endpoints for searching, creating and deleting “server” objects:
	● GET servers. Returns all the servers if no parameters are passed. When server id is passed as a parameter - returns a single server or 404 if there’s no such a server.
	● PUT a server. The server object is passed as a json-encoded message body. Here’s an example:
	{
	“name”: ”my centos”, “id”: “123”, “language”:”java”, “framework”:”django”
	}
	● DELETE a server. The parameter is a server ID.
	● GET (find) servers by name. The parameter is a string. Must check if a server name contains this string and return one or more servers found. Returns 404 if nothing is found. “Server” objects are stored in MongoDB database.

Postman collection for the above operations are included in a json file in the API-Test-Application folder.
