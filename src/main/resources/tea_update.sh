curl -X PUT http://localhost:8080/teachers/1 \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "Alice",
    "lastName": "Smith",
    "email": "alice.smith2@example.com"
  }'

