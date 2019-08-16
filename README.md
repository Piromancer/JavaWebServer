# JavaClientServer
An Infotecs testing task

Целевая платформа: Windows (кроссплатформенность будет плюсом)

Разработка клиент-серверного приложения.

Порт 45777 используется для работы с сообщениями.

Клиент - консольное приложение. При старте приложения требуется ввести логин.

Требования к логину:

- максимальная длина 4 символа;

- латиница, буквенный набор символов в нижнем регистре;

После ввода логина, клиенту доступно меню, в котором доступны действия на выбор:

1. Ввести новое сообщение;

2. Показать список своих сообщений;

3. Удалить свое сообщение (по идентификатору);

4. Выход из сессии (предлагается снова ввести логин);

Дополнительное задание:

Реализовать на стороне сервера второй модуль, который будет работать с клиентом через порт 45778. Через этот порт клиент может загружать файлы на сервер и скачивать их. Для этого необходимо в меню клиента добавить возможность загрузки файлов на сервер и их скачивание. При этом закаченные файлы (их имена) должны отображаться в списке сообщений. Добавить в меню клиента пункт с выводом всех сообщений всех пользователей с возможностью группировки и сортировки их по логинам и временам сообщений.

Требования к присылаемым решениям:

· Тестовое задание должно быть выполнено с использованием Java SE 8. Для сборки не должны скачиваться внешние библиотеки, не входящие в состав JDK.

· При работе с сообщениями используется JSON.

· При работе с файлами протокол на выбор.

· Сервер должен быть многопоточным и поддерживать множественные сессии одновременно.

· При выводе сообщений для всех пользователей доступны сортировка по логину и сортировка по времени сообщения.

· Сервер не должен использовать СУБД. Всю информацию необходимо хранить в файле. Формат хранимой информации на выбор разработчика.

Результат предоставить в виде архива с исходными кодами и ссылкой на репозиторий github, где должен быть размещен проект. В архиве также должны находиться скомпилированные исполняемые jar-файлы (клиент и сервер), а также инструкция по сборке проекта и инструкция по работе с приложением.
