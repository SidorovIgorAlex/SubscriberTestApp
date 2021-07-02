Реализация Subscription.

В качестве бд была использована реализация MySQL.
Чтобы подключить postgresql, необходиом в application.yml заменить
jdbc:mysql://localhost/my_db?useSSL=false&serverTimezone=UTC на 
jdbc:postgresql://localhost/my_db?useSSL=false&serverTimezone=UTC

Зависимость для postgresql была добавлена в maven

Имя базы - my_db

Имена таблиц - PURCHASE и SUBSCRIPTION

Генерация таблиц осуществляться автоматически, все настройки описаны в application.yml

Логирование осуществлялось с помощью сквозного функционала AOP.

Лог файл пишется в корень проекта - log.txt



