package remove_duplicate_words;

public class RemoveDuplicateWordsWithoutCollection {
	static int len;
	static String words[];
	
	public static void main(String[] args) {
		System.out.println(remove("how are are are you you"));
	}
	public static String remove(String sentence) {		
		StringBuffer sb = new StringBuffer();		
		words = sentence.split(" ");
		len = words.length;

		for (int i=0;  i<len-1;  i++)
			for (int j = i+1;  j<len;  j++)
				if (words[i].equalsIgnoreCase(words[j]))
					words[j] = "";

		for (String word : words)
			if (word != "")
				sb.append(word + " ");

		return sb.toString().trim();
	}
}