package ru.chedmitriy.filter;
/**
 * фильтры для всего приложения
 * каждый фильтр выполняет свою, определенную
 * для конкретной ситуации  роль
 * @see ru.chedmitriy.filter.AdminFilter
 * контролирует сессию, а именно: логин и пароль
 * тем самым определяя или запрещая
 * определенные дествия
 * В противном случае фильтр возвращает на
 * страницу логирования
 *
 * */