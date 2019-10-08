package ch.ffhs.dua.permutations;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PermTest 
{
	
	
	@Test 
	public void testPerm0()
	{
		int[][] result = Permutations.permutations(0);
		assertSame(0, result.length, "Test for empty permutations");
	}
	
	@Test 
	public void testPerm1()
	{
		testPerm(1);
	}
	
	@Test 
	public void testPerm4()
	{
		testPerm(4);
	}
	
	private void testPerm(int n)
	{
		int[][] result = Permutations.permutations(n);
		assertSame(fak(n), result.length);
		HashSet<List<Integer>> perms = new HashSet<>();
		
		for (int[] perm : result)
		{
			assertSame(n, perm.length, "Wrong length of a permutation");
			assertSame(n, (int) IntStream.of(perm).distinct().count(), "Permutation has duplicates");
			//IntStream.of(perm).forEach(x -> assertTrue(x >= 0 && x <n, "Wrong permutation element"));
  			List<Integer> permList = toList(perm);
			assertFalse(perms.contains(permList), "Permutation + " + Arrays.toString(perm)+ " is generated twice");
			perms.add(permList);
		}
	}
	
	private static List<Integer> toList(int[] array)
	{
		return IntStream.of(array).boxed().collect(Collectors.toList());
	}
	
	private static int fak(int n)
	{
		return IntStream.range(1, n+1).reduce(1, (x,y) -> x*y);
	}
	

}
