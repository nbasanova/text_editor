/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		System.out.println("Removal. List: "+list1.head.next.data+" "+list1.head.next.next.data);
		System.out.println("Removal. List in reverse order: "+list1.tail.prev.data+" "+list1.tail.prev.prev.data);
		list1.remove(0);
		list1.remove(0);
		assertEquals("Remove: check size is correct after removal of all elements", 0, list1.size());
		try {
			list1.remove(-1);
			fail("Check OutOfBounds");
		}
		catch(IndexOutOfBoundsException e) {
			
		}
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
		// Test if adding a null object throws an exception as expected
		try {
			shortList.add(null);
			fail("Check null pointer");
		} 
		catch (NullPointerException e) {
			
		}
		//Test if boolean returns correctly
		boolean b = emptyList.add(1);
		assertEquals("Check return of the boolean", true, b);
		
		//test adding an element to an empty list
		assertEquals("Check add to empty list", (Integer)1 ,emptyList.get(0));
		
		//test adding an element to a regular list
		emptyList.add(2);
		assertEquals("Check add to regular list", (Integer)2 ,emptyList.get(1));
		
		//see if the size of the list calculates correctly
		assertEquals("Check calculating the size of the list", 2, emptyList.size);
		
		//print list in regular and reverse order
		//using links between nodes
		//to ensure, that all links are done correctly
		System.out.println("The list: "+emptyList.head.next.data+" "+emptyList.head.next.next.data);
		System.out.println("The list in reverse order: "+emptyList.tail.prev.data+" "+emptyList.tail.prev.prev.data);
     
		
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		assertEquals("Check size of empty list", 0, emptyList.size());
		assertEquals("Check size of short list", 2, shortList.size());
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // Test if adding a null object throws an exception as expected
		try {
			emptyList.add(0, null);
			fail("Check NullPointer");
		}
		catch(NullPointerException e){
			
		}
		
		//Test adding an element to bad index
		try {
			emptyList.add(3, 1);
			fail("Check OutOfBounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		//test adding to an empty list
		emptyList.add(0, 1);
		assertEquals("Check adding to an empty list", (Integer)1, emptyList.get(0));
		
		//test adding to regular list at the start
		emptyList.add(0, 2);
		assertEquals("Check adding to a list at the beginning", (Integer)2, emptyList.get(0));
		
		//test adding to a regular list at the end
		emptyList.add(2, 3);
		assertEquals("Check adding to a list at the end", (Integer)3, emptyList.get(2));
		
		//test regular addition
		emptyList.add(1, 4);
		assertEquals("Check regular addition", (Integer)4, emptyList.get(1));
		
		//check if size calculation is correct
		assertEquals("Check size calculation", 4, emptyList.size);
		
		//printout the list in regular and reverse order
		//to check if all the links are done correctly
		LLNode<Integer> temp =  emptyList.head.next;
		while(temp.data!=null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}		
		System.out.print("\n");
		
		temp =  emptyList.tail.prev;
		while(temp.data!=null) {
			System.out.print(temp.data+" ");
			temp = temp.prev;
		}
		System.out.print("\n");
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	   try {
		   emptyList.set(0, (Integer)1);
		   fail("Set: check OutOfBounds");
	   }
	   catch(IndexOutOfBoundsException e) {
		   
	   }
	   try {
		   shortList.set(0, null);
		   fail("Set: check NullPointerException");
	   }
	    catch(NullPointerException e) {
	    	
	    }
	   shortList.set(1, "One");
	   assertEquals("Check set", "One", shortList.get(1));
	}
	
	
	// TODO: Optionally add more test methods.
	
}
