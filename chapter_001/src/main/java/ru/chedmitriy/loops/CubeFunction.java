package ru.chedmitriy.loops;
/**
 * Class CubeFunction - пример решения квадратного уравнения
 * @author dimCher
 * @since 26.05.2016.
 *
 */

 class CubeFunction {
    private float y,a,b,c,d;
    private double squareRoot1;
    private double squareRoot2;
/**
 * Создадим конструктор CubeFunction,
 * куда будем заносить значения коэффициентов
 * */
   CubeFunction(float a,float b,float c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    /**
     * Метод calculate, проверяет условие: если а не равно 0,-
     * решаем уравнение,подставим вместо аргумента корни уравнения.
     * аргумент передается в метод как целое число!
     * */
    private float calculate(int x){
                y = (float)(a * Math.pow(x,2) + b * x + c);
        return y;
    }
    /**
     * Метод rounding нужен лишь для того,чтобы передать округленное целое число
     * методу calculate(int x)
     * Однако,в данном примере округление работать не будет!
     * */
    private int rounding(double result){
        return (int)Math.round(result);
    }
    /**
     * Метод diskriminant, проверяет условия:
     * если d = 0,- мы получим только один корень
     * если d > 0,- получим два корня.
     * остальные случаи- решений нет!
     * Каждому условию соответствует определенное решение
     * */
    void diskriminant() {
        d = (float)Math.pow(b,2) - 4 * a * c;
              if (a!=0 && d == 0) {
                squareRoot1=(-b / (2 * a));
               System.out.println(String.format("Уравнение имеет 1 корень: %s",squareRoot1));
               System.out.println(String.format("y = %s",calculate(rounding(squareRoot1))));
            } else if (a!=0 && d > 0) {
                squareRoot1=((-b - Math.sqrt(d)) / (2 * a));
                squareRoot2=((-b + Math.sqrt(d)) / (2 * a));
                System.out.println(String.format("Уравнение имеет 2 корня: x1 = %s; x2 = %s",
                        squareRoot1,squareRoot2));
               System.out.println(String.format("При x = x1\ny = %s",calculate(rounding(squareRoot1))));
               System.out.println(String.format("При x = x2\ny = %s",calculate(rounding(squareRoot2))));
            }else{
               System.out.println("Решений нет");
              }
    }
}
