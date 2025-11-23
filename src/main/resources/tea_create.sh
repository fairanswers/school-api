curl -X POST http://localhost:8080/teachers \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "Alice",
    "lastName": "Smith",
    "email": "alice.smith@example.com"
  }'

