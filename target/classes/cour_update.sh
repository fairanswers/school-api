curl -X PUT http://localhost:8080/api/courses/1 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Math 101 - Updated",
    "description": "Revised description"
  }'

