package ru.chedmitriy.loops;
/**
 * Class CubeFunctionMain - пример реализации CubeFunction
 * @author dimCher
 * @since 26.05.2016.
 * */
public class CubeFunctionMain {
    public static void main(String[] args) {
		//Создаем объект класса CubeFunction - solution
        CubeFunction solution = new CubeFunction(2, 6, 3);
        solution.diskriminant();
    }
}
