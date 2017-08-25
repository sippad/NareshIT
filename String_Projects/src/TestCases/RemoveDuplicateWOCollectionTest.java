package TestCases;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;

import org.junit.Test;

import remove_duplicate_words.RemoveDuplicateWordsWithoutCollection;

public class RemoveDuplicateWOCollectionTest {
	RemoveDuplicateWordsWithoutCollection testClass;
	String actual;
	String expected;
	
	@Test(timeout=5000) 
	public void test1(){		
		actual="how are are you you you you you you";
		expected="how are you";		
		assertEquals("Result", expected,testClass.remove(actual));
	}
	
	@Test(timeout=5000)
	public void test2() {
		actual="how are are are are you you you you";
		expected="how are you";		
		assertEquals("Result", expected,testClass.remove(actual));		
	}

	@Test(timeout=5000)
	public void test3(){		
		actual="how are you how do you do";
		expected="how are you do";
		assertEquals("Result", expected,testClass.remove(actual));
	}
	
	@Test(timeout=5000)
	public void test4(){		
		actual="how how how how";
		expected="how";
		assertEquals("Result", expected,testClass.remove(actual));
	}
	
	@Test(timeout=5000)
	public void test5(){		
		actual="how how how how how how how how how how how how how how how how";
		expected="how";
		assertEquals("Result", expected,testClass.remove(actual));
	}
	
	@Test(timeout=5000)
	public void test6(){		
		actual="how how how are are are you you you you";
		expected="how are you";
		assertEquals("Result", expected,testClass.remove(actual));
	}
	

}
