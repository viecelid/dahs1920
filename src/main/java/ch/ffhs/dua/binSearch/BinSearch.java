package ch.ffhs.dua.binSearch;

/**
 * Datum: 16.9.2019
 * Fach: D&A
 * Gruppe 3: Falah und Dario
 * Thema: Binäre Suche
 */

public class BinSearch {
    /**
     * Findet für einen aufsteigend geordneten Array zu einer Zahl value
     * den kleinsten und den grössten Index.
     *
     * @param array
     * @param value
     * @return Ein Paar mit kleinestem und grösstem Index oder
     * null, wenn der gegebene Wert im array nicht vorkommt.
     */
    public static Pair search(int[] array, int value) {
        //Error Handling: leeres Array
        if (array.length == 0) {
            return null;
        }
        return split(array, value, 0, array.length - 1);

    }

    //teile Index des Arrays in obere und untere Hälfte
    private static Pair split(int[] a, int m, int lowLimit, int highLimit) {
        //Ausstieg aus Rekurssion, wenn das Array Pointer auf das gleiche Arrayfeld zeigen
        if (lowLimit == highLimit) {
            if (m == a[lowLimit]) {
                Pair result = new Pair(lowLimit, highLimit);
                return result;
            }
            //Wenn nichts gefunden wurde wird ein nullpointer zurückgegeben
            else
                return null;

        }
        //Splittung des Arrays
        int helplow;
        int helphigh;
        int leftLow;
        int leftHigh;
        int rightLow;
        int rightHigh;
        rightLow = highLimit-(int) Math.floor((highLimit-lowLimit)/ 2);
        rightHigh = highLimit;
        if (rightLow>1){
        leftHigh = rightLow - 1;
        }
        else
        {
            leftHigh=0;
        }
        leftLow = lowLimit;
        Pair leftArr = new Pair(-1, -1);
        Pair rightArr = new Pair(-1, -1);

        //Aufrufe für die Rekursion Linker Teil des Arrays und Rechter. Bis nur noch ein Feld da ist
        if (a[leftHigh] >= m) {
            leftArr = split(a, m, leftLow, leftHigh);
        }
        if (m >= a[rightLow]) {
            rightArr = split(a, m, rightLow, rightHigh);
        }

        //prüfen was zurückgegeben werden soll. Da das Ursprungs Array alles gleiche Zahlen haben könnte.
        //muss obwohl schon im Linken Array die Zahl gefunden wurde, geschaut werden ob rechts noch höhere Indexes sind

        //falls leftArr oder rightArr null sind aussteigen
        if (leftArr==null){
            return null;
        }
        if (rightArr==null){
            return null;
        }
        if (leftArr.lower != -1) {
            if (rightArr.higher != -1) {
                Pair resultArr = new Pair(leftArr.lower, rightArr.higher);
                return resultArr;
            } else {
                return leftArr;
            }
        } else {
            if (rightArr.higher != -1) {
                return rightArr;
            }
            return null;
        }

    }


}
	

