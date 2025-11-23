curl -X PUT http://localhost:8080/students/1 \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "Johnny",
    "lastName": "Doe",
    "email": "johnny.doe@example.com"
  }'

