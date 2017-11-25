package spelling;

import java.util.*;
import org.junit.*;

import static org.junit.Assert.*;

public class NearbyWordsTester {
	private String dictFile = "data/words.small.txt"; 
	AutoCompleteDictionaryTrie largeDict;

	@Before
	public void setUp() throws Exception{
		largeDict = new AutoCompleteDictionaryTrie();
		DictionaryLoader.loadDictionary(largeDict, dictFile);
	}
	
	@Test
	public void testInsertion(){
		String sample = "smple";
		List<String> insertions = new LinkedList<String>();
		NearbyWords nw = new NearbyWords(largeDict);
		nw.insertions(sample, insertions, true);
		assertEquals("Check insertion, existing in dictionary words", true, insertions.contains("sample"));
		assertEquals("Check insertion, nonexisting words", false, insertions.contains("sumple"));
	}
	
	@Test
	public void testDeletion() {
		String sample = "taree";
		List<String> deletions = new LinkedList<String>();
		NearbyWords nw = new NearbyWords(largeDict);
		nw.deletions(sample, deletions, true);
		assertEquals("Check deletion, existing in dictionary words", true, deletions.contains("tree"));
		assertEquals("Check deletion, nonexisting words", false, deletions.contains("tare"));
	}
}
