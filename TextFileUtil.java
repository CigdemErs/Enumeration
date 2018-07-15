package odev;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextFileUtil implements EncryptDecrypt {
	public String sifrelenecek;
	public String key;
	public String sifrelenmis;
	public char [][] matris;

	public TextFileUtil() {
		sifrelenecek="";
		key="";
		sifrelenmis="";
	}
	
	@Override
	public void encrypt(String inputFileName, String key) {
		Scanner inpStream=null;
		PrintWriter outStream=null;
		try {
			inpStream=new Scanner(new File(inputFileName));
			String outFileName=inputFileName+".encr";
			outStream=new PrintWriter(new FileOutputStream(outFileName));
		} catch(Exception e) {
			e.getMessage();
		}
		while(inpStream.hasNextLine()) {
			String line=inpStream.nextLine();
			String sifrelenmis=showStepEn(key, line);
			outStream.println(sifrelenmis);
		}
		inpStream.close();
		outStream.close();
	}

	@Override
	public void decrypt(String inputFileName, String key, String outputFileName) {
		Scanner inpStream=null;
		PrintWriter outStream=null;
		try {
			inpStream=new Scanner(new File(inputFileName));
			outStream=new PrintWriter(new FileOutputStream(outputFileName));
		}catch(Exception e) {
			e.getMessage();
		}
		while(inpStream.hasNextLine()) {
			String line=inpStream.nextLine();
			outStream.println(showStepDe(key, line));
		}
		outStream.close();
		inpStream.close();
	}
	public String showStepEn(String anahtar, String sifre) {
		int count=0, say=0;
		String sifrelenmis="";
		int satir=sifre.length()+1;
		int sutun=anahtar.length()+1;
		int h=0;
		while(satir>sutun) {
			anahtar=anahtar+anahtar.substring(h, h+1);
			h++;
			sutun=anahtar.length();
		}
		matris=new char[satir][satir];
		for(int i=0; i<satir; i++) {
			for(int j=0; j<satir; j++) {
				if (i==0 && j==0)
					matris[i][j]=' ';
				else if(i==0) {
					matris[i][j]=anahtar.charAt(j-1);
				}
				else if(j==0) {
					matris[i][0]=sifre.charAt(i-1);
				}
				else {
					if(Character.isLetter(matris[i][0])) {
						if(Character.isUpperCase(matris[i][0])) {
							matris[i][j]=(char) (matris[i][0]+matris[0][j]-65);
							while((matris[i][j])>90)
								matris[i][j]=(char) (matris[i][j]-26);
						}
						else if(Character.isLowerCase(matris[i][0])) {
							matris[i][j]=(char) (matris[i][0]+matris[0][j]-97);
							while(matris[i][j]>122)
								matris[i][j]=(char) (matris[i][j]-26);
						}
					}
					else {
						if(count==0) {
							matris[i][j]=(char)(matris[i][0]);
							count++;
							say=i;
						}
						else {
							if(say!=sifre.length()-1) {
								matris[i][j]=sifre.charAt(say);
								say++;
							}
							else {
								matris[i][j]=sifre.charAt(say);
								say=0;
							}
						}
					}
				}
				System.out.print(matris[i][j]+" ");
			}
			System.out.println();
		}
		int a=0;
		for(int i=1; i<satir; i++) {
			if(matris[i][0]==sifre.charAt(a)) {
				for(int j=1; j<satir; j++) {
					if(matris[0][j]==anahtar.charAt(a)) {
						sifrelenmis=sifrelenmis+matris[i][j];
						j=satir;
					}
				}
			}
			a++;
		}
		return sifrelenmis;
	}
	
	public String showStepDe(String anahtar, String sifre) {
		String sifrelenmis="";
		char harf=0;
		int h=0;
		while(anahtar.length()<sifre.length()) {
			anahtar=anahtar+anahtar.substring(h, h+1);
			h++;
		}
		for(int i=0; i<sifre.length(); i++) {
			if(Character.isUpperCase(sifre.charAt(i)))
				harf=(char)(Math.abs(sifre.charAt(i)-anahtar.charAt(i))+65);
			else
				harf=(char)(Math.abs(sifre.charAt(i)-anahtar.charAt(i))+97);
			sifrelenmis=sifrelenmis+harf;
		}
		return sifrelenmis;
	}
}
