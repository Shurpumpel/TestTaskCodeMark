# TestTaskCodeMark
### Создание базы данных в файле Database_creation.sql


### Для вывода всех пользователей без используется GET:http://localhost:8080/users

### Для вывода одного пользователя с ролями GET:http://localhost:8080/users/{login}

### Добавление или обновление через POST:http://localhost:8080/users

### В теле запроса json наподобие:

```json
{
    "name": "name",
    "login": "login",
    "password": "qwerty",
    "roles": [
        {
            "id": 1,
            "role": "Admin"
        },
        {
            "id": 2,
            "role": "Operator"
        }
    ]
}
```

 ### Удаление через DELETE:http://localhost:8080/users/{login}