package ch.ffhs.dua.sort;

public class QuickSort 
{
	
	/**
	 * Sortiert ein Array durch Quicksort.
	 * @param array Zu sortierendes Array.
	 */
	public static void sort(int[] array)
	{
		if (array.length>1){
			sort(array,0,array.length-1);
		}
	}
	
	/**
	 * Sortiert ein Teilstück eines Arrays durch Quicksort.
	 * @param array ZU sortierenden Array
	 * @param start Index des ersten Elementes des Teils, das sortiert werden muss.
	 * @param end   Index des letzen Elementes des Teils, das sortiert werden muss.
	 */
	public static void sort(int[] array, int start, int end)
	{
		if ((end-start)>=1){
			//Pivot nimm den mittleren Wert von links, mitte, rechts (ordne zuerst die 3 Werte)
			//Achtung int/int ist in Java int. Sprich Division ohne Rest
			int mid=((start+end)+1)/2;
			//Mitte justieren
			if (array[start]>array[mid]){
				int t=array[start];
				array[start]=array[mid];
				array[mid]=t;
			}
			if(array[mid]>array[end]){
				int t=array[mid];
				array[mid]=array[end];
				array[end]=t;
				//falls mid auch kleiner als start nachdem getauscht wurde
				if (array[start]>array[mid]){
					t=array[start];
					array[start]=array[mid];
					array[mid]=t;
				}
			}



			//array für links kleiner und rechts grössere Werte als Pivot Zahl
			Integer[] temparray=new Integer[(end-start)+1];
			int og_r=end-start;
			int ug_l=0;
			int pivotValue=array[mid];
			for (int i=start;i<=end; i++) {

				if (array[i] > pivotValue) {
					temparray[og_r]=array[i];
					og_r--;
				}
				if (array[i]<pivotValue) {
					temparray[ug_l]=array[i];
					ug_l++;
				}
			}
			//temporäres Array zurückschreiben. Wenn der Mittlere Wert vorkommt wurde er nicht geschrieben
			//dort ist das temparray noch empty (darum Typ Integer genommen, um null testen zu können
			//todo: mitte Anpassen wenn lange kein Value gefunden wird
			for (int i=start;i<=end;i++){
				if (temparray[i-start]!=null) {
					//System.out.print(" not null--> "+temparray[i-start]+" value: "+(i-start));
					array[i] = temparray[i-start];
				}
				else{
					//todo: dieses i sollte neu als Mitte gebraucht werden
					array[i]=pivotValue;
					mid=i; //unbedingt die Wahre neue Mitte setzen
				}
			}
			//...nach diesem vertauschen steht der Mittlere Wert in der Mitte
			//linke Seite
			if ((end-start)>1) {
				sort(array, start, mid-1);
				//rechte Seite
				sort(array, mid+1, end);
			}
		}

	}
	
	/** 
	 * Schwellwert, bei welcher Arraygrösse in der Rekursion InsertSort 
	 * statt Quicksort aufgerufen werden sollte. 
	 */
	static int THRESHOLD = 4; // TODO finden Sie einen sinnvollen Wert
	
	/**
	 * Modifiziertes Quicksorts.
	 * Wenn die Grösse des zu sortierenden Arrays in der Rekursion 
	 * einen Schwellwert unterschreitet, wird InsertSort statt Quicksort 
	 * aufgerufen.
	 * @param array Zu sortierendes Array
	 */
	public static void sortPlus(int[] array)
	{
		// TODO
	}

	/**
	 * Modifiziertes Quicksorts zum SOrtieren eines Teilstücks eines Arrays.
	 * Wenn die Grösse des zu sortierenden Arrays in der Rekursion 
	 * einen Schwellwert unterschreitet, wird InsertSort statt Quicksort 
	 * aufgerufen.
	 * @param array Zu sortierendes Array
	 * @param start Index des ersten  Elementes des zu sortierenden teilstücks.
	 * @param end   Index des letzten Elementes des zu sortierenden teilstücks.
	 */
	public static void sortPlus(int[] array, int start, int end)
	{
		// TODO
	}

	/**
	 * Hilfsmethode für Quicksort. 
	 * Ein Teilstück eines Arrays wird geteilt, so dass alle Elemente,
	 * die kleiner als ein gewisses Pivot-Elements sind, links stehen
	 * und alle Elemente, die grösser als das Pivot-Element rechts stehen.
	 * @param array Array zum Umordnen.
	 * @param start Indes des ersten  Elements des Teilstücks, das geteilt werden muss.
	 * @param end   Index des letztes Elements des Teilstücks, das geteilt werden muss.
	 * @param piv   Index des PiotElements
	 * @return Index des Piot-Element nach der Partitionierung.
	 */
	static int partition(int[] array, int start, int end, int piv)
	{
		// TODO Verwenden Sie diese Mehode für Quicksort
		return -1;
	}
	
	/**
	 * Hilfsmethode zum Vertauschen zweier Array-Elemente
	 * @param array
	 * @param a
	 * @param b
	 */
	static void swap(int[] array, int a, int b)
	{
		int tmp = array[a];
		array[a] = array[b];
		array[b] = tmp;
	}
	
	/**
	 * Hilfsmethode zum Finden eines Pivot-Elementes für Quicksort.
	 * Zu einem Array und den zwei Indices start und end wird 
	 * der Index eines möglichen Pivot-Elementes angegeben 
	 * @param array
	 * @param start
	 * @param end
	 * @return Index eines Pivot-Elementes
	 */
	static int findPivot(int[] array, int start, int end)
	{
		// TODO
		return start;
	}
}
