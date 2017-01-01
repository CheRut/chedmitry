package ru.chedmitriy.dataTypes;

/**
 * Class Calculator задает алгоритм действий
 * @author dimCher
 * @since 22.05.2016.
 */

 class Calculator {
      double result;

    /**
     * Сложение:
     * @param first первый аргумент
     * @param second второй аргумент
     * @return результат
     */
   public double add(double first,double second){
        result = first + second;
		return result;
    }
    /**
     * Вычитание:
     * @param first первый аргумент
     * @param second второй аргумент
     * @return результат
     */
    public double substract(double first,double second){
        result = first - second;
		return result;
    }
    /**
     * Умножение:
     * @param first первый аргумент
     * @param second второй аргумент
     * @return результат
     */
    public void div(double first,double second){
        result = first / second;
    }
    /**
     * Деление:
     * @param first первый аргумент
     * @param second второй аргумент
     * @return результат
     */
    public void multiple(double first,double second){
        result = first * second;
    }

}