package count_char_occurrence;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test_CountCharacterOccurence {

	CountCharacterOccurrence_3 testclass1;
	CountCharacterOccurrence_2 testClass2;
	
	String input;
	String expected;
	@Test
	public void test1() {
		input="how are you";
		expected="h:1 o:2 w:1 a:1 r:1 e:1 y:1 u:1";
		assertEquals("Result", expected, testclass1.count(input));
		assertEquals("Result", expected, testClass2.count(input));
	}
	
	@Test
	public void test2() {
		input="how how how how how";
		expected="h:5 o:5 w:5";
		assertEquals("Result", expected, testclass1.count(input));
	}

}
