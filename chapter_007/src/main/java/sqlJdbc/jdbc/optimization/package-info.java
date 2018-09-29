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
 * @see sqlJdbc.jdbc.optimization.JDBCOptimization#createTable() - создаем таблицу если не создана еще
 * @see sqlJdbc.jdbc.optimization.JDBCOptimization#clearTable()  - очищаем таблицу,
 * если таблицу не пришлось создавать и в ней могут быть значения
 * @see sqlJdbc.jdbc.optimization.JDBCOptimization#fillData(int)  - заполняем таблицу n элементами
 * @see sqlJdbc.jdbc.optimization.JDBCOptimization#xmlCreator(String) - создаем  файл 1.xml
 * @see sqlJdbc.jdbc.optimization.XMLTransformation#transformXML(org.w3c.dom.Document, java.lang.String)  - заполняем xml
 * документ Тегами и атрибутами,принимаем значения из таблицы в БД
 * @see sqlJdbc.jdbc.optimization.XMLTransformation#applyTransform(String, String, String)
 * преобразуем 1.XML в 2.xml исользем шаблон стилей template.xsl
 * @see sqlJdbc.jdbc.optimization.XmlPars#parser(String) - перебираем значения
 * в файле 2.xml, выводим результат согласно условию
 *
 */



package sqlJdbc.jdbc.optimization;