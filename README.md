# _Тестовая CRUD-таска_

## Пояснения:
1. Не стал писать юнит-тесты на все методы, тк затратно по времени да и в целом неразумно для такого маленького проекта с несложной логикой.
Написал один, чтобы показать валдение навыком.
2. База - PostreSQL
3. Запросы для проверки через потсман приведу ниже

**Добавление юзера (POST):** http://localhost:8080/user
**Тело запроса:** {
"email":"oleg@yandex.ru",
"name":"Oleg",
"phoneNumber":"89876027415"
}
**Изменение статуса:**http://localhost:8080/user/14/status?newUserStatus=ONLINE

# ЗАДАНИЕ
![img.png](img.png)