# car-application
Spring Security and Session Management
I have used basic spring security with JWT to manage stateless session.

http://localhost/register -> It will enable user to register in system
http://localhost/autenticate -> Once user is registered,he can fetch JWT token using authenticate

The current token, as per my code, is valid for 5hrs which can be modified as required.
Now, once user has the token he can make api calls to the system by passing the token in request header.
