Программа по проведению тестирования студентов
Цель: Цель задания: научиться создавать приложение с помощью Spring IoC. Результат: простое приложение, сконфигурированное XML-контекстом.
Описание задание:

В ресурсах хранятся вопросы и различные ответы к ним в виде CSV файла (5 вопрсов).
Программа должна спросить у пользователя фамилию и имя, спросить 5 вопросов из CSV-файла и вывести результат тестирования.
Вопросы могут быть с выбором из нескольких вариантов или со свободным ответом - на Ваше желание и усмотрение.

Все сервисы в программе должны решать строго определённую задачу.
Контекст описывается XML-файлом.
Все зависимости должны быть настроены в IoC контейнере.
Имя ресурса с вопросами (CSV-файла) необходимо захардкодить в XML-файле с контекстом.
CSV с вопросами читается именно как ресурс, а не как файл.
Scanner и стандартные типы в контекст класть не нужно!

*Опционально: сервисы, по возможности, покрыть Unit-тестами.

Код, написанный в данном ДЗ будет использоваться дальше в домашних заданиях №№ 2-5.
Критерии оценки: 5 - работа выполнена отлично, код чист, проект работает при любом пользовательском вводе
4 - код выполнен с некоторыми недочётами и/или не работает в случае некорректного ввода пользователя
3 - код с проблемами дизайна и/или не работает в случае некорректного ввода пользователя
2 (возвращается на доработку) - "грязный код", отсутствие важного функционала
1 (возвращается на доработку) - ужасный код и/или проект не запускается и/или не проходят тесты
Рекомендуем сдать до: 03.09.2019