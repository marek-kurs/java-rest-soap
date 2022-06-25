### REST - CRUD
- Stamp
- createStamp - bad solutions

- resource can have at least one uri
- resources are hierarchical
- resources are plural!!!
- Read collection - GET - /stamps - 
  - 200 (body - result)
- Read one item - GET - /stamps/{id} eg. /stamps/110101010 
  - result: 200 - if found (body contains found item), 404 if not found (empty body)
- Create item - POST - /stamps
  - positive: result: 201 + content (inside body) (header location)
  - positive - alternate: result: 201 + no content (header location)
  - negative case (not valid reservation - in past) - 400 - bad request (no body / errors in response)
- Delete item - DELETE - /stamps/{id} eg. /stamps/111145
- Update item - PUT - replace object - /stamps/{id}
- Update partial - PATCH - partial update - /stamps/{id}
