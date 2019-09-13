package Driver;

import java.util.List;
import java.util.Arrays;
import java.util.Random;

import io.appium.java_client.AppiumDriver;

public class practice extends desiredCapabilities{

	public static void main(String[] args) {

//		givenList_whenNumberElementsChosen_shouldReturnRandomElementsRepeat();
		
		testMethods();
	}
	
	public static void givenList_whenNumberElementsChosen_shouldReturnRandomElementsRepeat() {
	    Random rand = new Random();
	    List<String> givenList = Arrays.asList("one", "two", "three", "four");
	 
	    int numberOfElements = 2;
	 
	    for (int i = 0; i < numberOfElements; i++) {
	        int randomIndex = rand.nextInt(givenList.size());
	        String randomElement = givenList.get(randomIndex);
	    }
	}
	
	public static void testMethods() {
		
//		int[] arr = {1, 2, 3, 4};
////		int length = arr.length;
//		
//		int[] array = new int[10];
//		array[9] = 1;
//		
//		int length = array.length;
//		
//		System.out.println(array[9]);
		
		int[] arr = new int[] {11, 12, 15, 18};	
		int length = arr.length;
		
		System.out.println(length);
	
	}

}
