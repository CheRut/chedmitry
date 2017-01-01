package ru.chedmitriy.arrays;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DuplicateCleanerTest {
   @Test
	public void duplicateCleanerTesting() {
		//Assign block
		DuplicateCleaner delDup = new DuplicateCleaner();
		String[] values = new String[]{"I","va","li","ke","ja","ke","va","li"};
		String[] expectedValues = new String[]{"I","li","ke","ja","va"};
		
		//Act block
		String[] result = delDup.showArr(values);
		
		//Action block
		assertThat(Arrays.toString(result),is(Arrays.toString(expectedValues)));
	}

}
