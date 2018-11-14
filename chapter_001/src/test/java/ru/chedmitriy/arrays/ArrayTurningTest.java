package ru.chedmitriy.arrays;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class ArrayTurningTest {
   @Test
	public void arrRotateTest() {
		
		ArrayTurning arrRotate = new ArrayTurning();
		int[][] val = {{1, 2}, {3, 4}};
		int[][] exp = {{3, 1}, {4, 2}};
		
		int[][] result = arrRotate.arrTurnClockwise(val);
		assertThat(Arrays.deepEquals(exp, result), is(true));
	}

}
