/**
 * Datum: 30.9.2019
 * Fach: D&A
 * Gruppe 3: Falah und Dario
 * Thema: Permutationen
 */

package ch.ffhs.dua.permutations;


import sun.rmi.runtime.Log;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class Permutations
{
	/**
	 * Erzeugt ein Array von allen Permutationen von {0,1,2,3,...,n-1}.
	 * @param n Anzahl Elemente in einer Permutation.
	 * @return  Ein Array von Permutationen; jede Permutation ist ein Array von Integern.
	 */
	public static int[][] resultArray;
    private static int[] inputArray;
    private static int counter;
    private static int factstartn;
    private static int positionen;

	public static int[][] permutations(int n)
	{
	    //Arrays müssen nur beim ersten Durchlauf erstellt werden
	    if (inputArray==null && n!=0){
	        counter=0;
            resultArray =new int[factorial(n)][n];
            inputArray =new int[n];
            //Initialisierung input Array und statusArray
            if (n!=0){
                for (int i=0; i==n; i++){
                inputArray[i]=i;
                }
            }
	    }
        //Abfangen wenn n=0 ist
        if (n==0){
            resultArray =new int[n][n];
            return resultArray;
        }
        //Abfangen wenn n=1 ist
        if (n==0){
            resultArray =new int[n][n];
            resultArray[0][0]=n;
            return resultArray;
        }
        positionen=n;
        factstartn=factorial(n);
        permute(n);
        for (int i=0; i<factstartn; i++){
            System.out.print("Zeile ");
            System.out.print(i);
            System.out.print(":  ");
            for (int j=0; j<n; j++){
                System.out.print(" ");
                System.out.print(resultArray[i][j]);
            }
            System.out.println(" ");
        }
        return resultArray;
	}
    //Diese Rekursion füllt das Array mit der Position der Permutationen. Es angelt sich den Baum hinunter.
    //Trick: Die Fakultät n!:=n*(n-1)!
	public static void permute(int n){
        //Ausstieg
        if (n==0){
            return;
        }
	    int tempn=n;
        int i=factorial(n-1);
        boolean done=false;
        //leere Position an der eingetragen soll
        int leerpos=0;
        //geh durch das ganze Array length entspricht dem factorial vom Anfang n (statisch)
         for (int l=0; l<factstartn;l++){
            //Leere Position an der eingetragen werden soll entspricht dem factorial n-1. Ganzzahl Division zeigt mir wo im Baum
            if (l%i==0 && l/i>0){
                leerpos=(leerpos+1) % n;
            };
            //wechsle leere Position (von Links nach rechts)
            int c=0;
             for (int k=0; k<positionen;k++){
                //falls das Array an der Position Null ist Zahl eintragen und den loop verlassen
                if (resultArray[l][k]==0){
                    if(c==leerpos){
                        resultArray[l][k] = tempn;
                        done=true;
                        break;
                    }
                    c=c+1;
                }
            }


        }
	    permute(n-1);
        return;
    }

	//Fakultät Berechnung limitiert auf maximum Integer (reicht für dieses Beispiel)
	public static int factorial(int number) {
	    int result = 1;

	    for (int factor = 2; factor <= number; factor++) {
	        result *= factor;
	    }

	    return  result;
	}

	
}
