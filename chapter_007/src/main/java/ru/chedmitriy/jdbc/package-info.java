/**
 * chedmitry
 *
 * @author CheDmitry
 * @version 1.0
 * @since 16.12.17
 *
 *
 * /**
 * Метод засекает время выполнения всех операций
 * @see ru.chedmitriy.jdbc.JDBCOptimization#createTable() - создаем таблицу если не создана еще
 * @see ru.chedmitriy.jdbc.JDBCOptimization#clearTable()  - очищаем таблицу,
 * если таблицу не пришлось создавать и в ней могут быть значения
 * @see ru.chedmitriy.jdbc.JDBCOptimization#fillData(int)  - заполняем таблицу n элементами
 * @see ru.chedmitriy.jdbc.JDBCOptimization#xmlCreator(String) - создаем  файл 1.xml
 * @see ru.chedmitriy.jdbc.XMLTransformation#transformXML(org.w3c.dom.Document, java.lang.String)  - заполняем xml
 * документ Тегами и атрибутами,принимаем значения из таблицы в БД
 * @see ru.chedmitriy.jdbc.XMLTransformation#applyTransform(String, String, String)
 * преобразуем 1.XML в 2.xml исользем шаблон стилей template.xsl
 * @see ru.chedmitriy.jdbc.XmlPars#parser(String) - перебираем значения
 * в файле 2.xml, выводим результат согласно условию
 *
 */



package ru.chedmitriy.jdbc;