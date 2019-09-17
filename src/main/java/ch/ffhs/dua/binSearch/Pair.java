package ch.ffhs.dua.binSearch;

/**
 * Einfache Klasse für ein Paar von zwei int-Werten.
 */
public class Pair 
{
	public final int lower;
	public final int higher;
	
	public Pair(int lower, int higher)
	{
		String a="test";
		this.lower = lower;
		this.higher = higher;
	}

	// Generiert duch eclipse
	@Override
	public int hashCode() {
		final int prime = 101;
		int result = 1;
		result = prime * result + higher;
		result = prime * result + lower;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		if (higher != other.higher)
			return false;
		if (lower != other.lower)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "("+ lower + ", " + higher + ")";
	}
	
	
}
