package odev;
import java.lang.Number;

public class  MatMul<N extends Number> {
	public static Double [][] sonuc;
	
	public static <N extends Number> Double[][] multiply(N [][] array, N[][] array2) {
		if(array[1].length==array2.length) {
			int ilkUzunluk=array.length;
			int ilkIkinci=array[1].length;
			int sonUzunluk=array2[1].length;
			sonuc=new Double[ilkUzunluk][sonUzunluk];
			for(int i=0; i<ilkUzunluk; i++) {
				for(int j=0; j<sonUzunluk; j++) {
					sonuc[i][j]=(double)0;
				}
			}
			for(int i=0; i<ilkUzunluk; i++) {
				for(int j=0; j<sonUzunluk; j++) {
					for(int a=0; a<ilkIkinci; a++) {
						Double ilk, ikinci;
						if(array instanceof Integer[][]) {
							ilk=(array[i][a]).doubleValue();
							ikinci=(array2[a][j]).doubleValue();
						}
						else {
							ilk=(Double)(array[i][a]);
							ikinci=(Double)(array2[a][j]);
						}
						sonuc[i][j]=(ilk*ikinci)+sonuc[i][j];
					}
				}
			}
		}
		else {
			System.out.println("Girdiginiz uzunluk degerlerini kontrol ediniz.");
		}
		return sonuc;
	}
	public static void yazdir(Double [][] array) { //denemeyi kolaylastirmak icin yazdir metodu.
		for(int i=0; i<array.length; i++) {
			for(int j=0; j<array[1].length; j++) {
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
	}
}
