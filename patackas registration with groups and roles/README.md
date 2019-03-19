Api testing with Postman:

GET http://localhost:8080/login
(should display the login page's HTML)

POST http://localhost:8080/login
Select form-data or params. Enter 2 keys: email, password; and enter their values with your login credentials.

You can now GET http://localhost:8080/admin/home or GET http://localhost:8080/api/notes

You should also be able to POST http://localhost:8080/api/notes and create a new note by typing the title and content of the note using JSON:

e.g.  
{

"title": "new test x ",

"content": " test contemt "

}

this should save it to the "login" database and table "notes"

GET http://localhost:8080/api/notes/6 (6 being the ID of the note in the database) to display a specific note

also

PUT http://localhost:8080/api/notes/[id]
DELETE http://localhost:8080/api/notes/[id]
