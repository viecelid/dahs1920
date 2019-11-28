package ch.ffhs.dua.sort;

public class InsertSort 
{
	/**
	 * Sortiert ein Array durch Einfügen
	 * @param array Das zu sortierende Array.
	 */
	public static void sort(int[] array)
	{
		int lenA=array.length;
		//mit jedem Schritt wächst der Bereich in den wir die zu sortierenden Zahl einordnen wollen

		for (int k=0;k<=lenA-1;k++){
			sort(array,0,k);
			System.out.print(" "+array[k]);
		}

	}
	
	/**
	 * Sortiert einen durch zwei Grenzen angebenen Teil eines Arrays durch Einfügen.
	 * Arrayelemente ausserhalb der Grenzen werden nicht verschoben.
	 * @param array 
	 * @param start Index des ersten  Elementes des Teils, das Sortiert werden muss.
	 * @param end   Index des letzten Elementes des Teils, das sortiert werden muss.
	 */
	public static void sort(int[] array, int start, int end)
	{
		//int insert=array[end];
		for (int i=start; i<=end; i++){
			if (array[end]<array[i]){
				//füge anstelle des Wertes ein und update das lokale Ende des Arrays mit dem grössten Wert
				int temp=array[i];
				array[i]=array[end];
				array[end]=temp;
			}
		}
		// TODO
	}

}
