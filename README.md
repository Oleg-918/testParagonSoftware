# _Тестовая CRUD-таска_

##  Запросы для проверки через потсман:

**Добавление юзера (POST):** http://localhost:8080/user

**Тело запроса:**
{
"email":"oleg@yandex.ru",
"name":"Oleg",
"phoneNumber":"89996667814"
}

**Изменение статуса:**
http://localhost:8080/user/14/status?newUserStatus=ONLINE

# ЗАДАНИЕ
Задача: написать серверную часть Web-приложения согласно следующим требованиям:
Средства разработки: Java 1.7 (или выше), Инструменты: Spring Framework, Протокол: HTTP, База данных: PostgreSQL
Примечание: вместо обращения к реальной базе можно реализовать "заглушку" с имитацией обращения и задержкой по времени 5-10 сек.

Функционал:

•	Добавление нового пользователя. Передаем на сервер данные пользователя (имя пользователя, email, phoneNumber и т.д.). Сохраняем информацию в базе данных. Ответ сервера — уникальный ID нового пользователя

•	Получение информации о пользователе. Передаем на сервер уникальный ID пользователя. Читаем информацию из базы данных. Ответ сервера — данные пользователя.

•	Изменение статуса пользователя (Online, Away, Offline). Передаем на сервер уникальный ID пользователя и новый статус. Изменяем статус пользователя. Ответ сервера — уникальный ID пользователя, новый и предыдущий статус

•	Перевод в статус Away должен делаться автоматически через 5 минут после последнего изменения статуса на online. Таким образом, если “подтверждать” статус online пользователя каждые 5 минут - автоматического перехода в Away не должно быть.

Обязательные требования:

— RESTful, — Все данные в формате JSON, — Обработка ошибок
