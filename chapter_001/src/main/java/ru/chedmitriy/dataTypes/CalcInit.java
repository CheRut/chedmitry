package ru.chedmitriy.dataTypes;


/**
 * Class CalcInt реализует арифметческие операции, класса Calculator
 * @author dimCher
 * @since 22.05.2016.
 */
public class CalcInit {

    public static void main(String[] args) {
        /**
         *@param EXP первый аргумент
         *@param pi второй аргумент
         **/
        double exp = 2.71828182845904523536;
        double pi = 3.1415926535;
        Calculator calculator = new Calculator();
        calculator.add(exp,pi);
        System.out.println(String.format("add: %s",calculator.result));
        calculator.substract(exp,pi);
        System.out.println(String.format("substract: %s",calculator.result));
        calculator.div(exp,pi);
        System.out.println(String.format("multiple: %s",calculator.result));
        calculator.multiple(exp,pi);
        System.out.println(String.format("div: %s",calculator.result));

    }
}

