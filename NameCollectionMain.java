package odev;
import java.util.Scanner;

public class NameCollectionMain {
	public static void main(String[] args) {
		String[] isimler;
		Scanner keyboard=new Scanner(System.in);
		
		System.out.println("Kac isim girilecek:"); //soruda boyutla ilgili herhangi bir bilgi verilmedigi icin kullanicidan aldim.
		int size=keyboard.nextInt();
		isimler=new String[size];
		
		System.out.println("Isimleri giriniz:"); //isimlerin kullanicidan alinacagi belirtilmis.
		keyboard.nextLine();
		for(int i=0; i<size; i++) {
			isimler[i]=keyboard.nextLine();
		}
		
		NameCollection nameCollection=new NameCollection(isimler);
		System.out.println(isimler[0]); //getNext() metodu sadece elemandan sonrakini yazdirmasi gerektigi icin ilk elemani burda yazdirdim.
		for(int i=0; i<size+1; i++) {
			System.out.println(nameCollection.getEnumeration().getNext());
		}
		
		keyboard.close();
	}
}
