package remove_duplicate_words;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;

import org.junit.Test;

import remove_duplicate_words.RemoveDuplicateWordsWithoutCollection;

public class TestClass {
	RemoveDuplicateWordsWithoutCollection testClass;
	String sentence;
	String expected;
	
	@Test(timeout=5000) 
	public void test1(){		
		sentence="how are are you you you you you you";
		expected="how are you";		
		assertEquals("Result", expected,testClass.remove(sentence));
	}
	
	@Test(timeout=5000)
	public void test2() {
		sentence="how are are are are you you you you";
		expected="how are you";		
		assertEquals("Result", expected,testClass.remove(sentence));		
	}

	@Test(timeout=5000)
	public void test3(){		
		sentence="how are you how do you do";
		expected="how are you do";
		assertEquals("Result", expected,testClass.remove(sentence));
	}
	
	@Test(timeout=5000)
	public void test4(){		
		sentence="how how how how";
		expected="how";
		assertEquals("Result", expected,testClass.remove(sentence));
	}
	
	@Test(timeout=5000)
	public void test5(){		
		sentence="how how how how how how how how how how how how how how how how";
		expected="how";
		assertEquals("Result", expected,testClass.remove(sentence));
	}
	
	@Test(timeout=5000)
	public void test6(){		
		sentence="how how how are are are you you you you";
		expected="how are you";
		assertEquals("Result", expected,testClass.remove(sentence));
	}
	

}
