## SQLDeadline
___
Тестирование входа в систему через веб-интерфейс.

## Руководство к использованию
___
1. БД и приложение находятся в контейнере Docker. Контейнер запускается  либо через терминал IDEA командой `docker-copmose up -d`, либо через файл `docker-compose.yml` в Docker командой `docker-copmose up`.
2. Дождаться развертки контейнера.
3. Открыть DBeaver, выполнить запросы из schema.sql
4. Запустить приложение командой 
```
java -jar app-deadline.jar -P:jdbc.url=jdbc:mysql://185.119.57.164:3306/app -P:jdbc.user=app -P:jdbc.password=pas
s
```

В ходе проведения тестирования выявлена ошибка:
[Система не блокируется при трехкратном вводе пароля](https://github.com/Zumaletto/HW3-2-SQL/issues/1)
