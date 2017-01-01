package ru.chedmitriy.loops;

/**Factorial - вычисление факториала
 * @author dimCher
 * @since 26.05.2016.
 * */

public class Factorial {
    private int a;
    private Factorial(int a){
        this.a = a;
    }
	/**
	* метод result возвращает результат(целое число) выполнения цикла
	*/
    public int result(){
       int b=1;
        for (int i = 1; i <= a; i++) {
            b = b*i;
        }
        System.out.println(String.format("%s%s%s%s",a,"!"," = ",b));
        return b;
    }
	/**
	*Метод запуска программы
	*/
    public static void main(String[] args) {
        Factorial fact = new Factorial(3);
fact.result();
    }
}

