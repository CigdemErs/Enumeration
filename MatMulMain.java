package odev;

public class MatMulMain {

	public static void main(String[] args) {
		Double[][] M = new Double[3][5];
		Double[][] N = new Double[5][7];
		
		for(int i=0; i<3; i++) { //M arrayini random doldurdum.
			for(int j=0; j<5; j++) {
				M[i][j]=(Double)(Math.random()*4);
			}
		}
		
		for(int i=0; i<5; i++) { //N arrayini random doldurdum.
			for(int j=0; j<7; j++) {
				N[i][j]=(Double)(Math.random()*4);
			}
		}
		
		Double[][] A = MatMul.<Double>multiply(M,N);
		MatMul.yazdir(A);
		//..
		Integer[][] K = new Integer[2][3];
		Integer[][] L = new Integer[3][5];
		
		for(int i=0; i<2; i++) { //K arrayini random doldurdum.
			for(int j=0; j<3; j++) {
				K[i][j]=(int)(Math.random()*4);
			}
		}
		
		for(int i=0; i<3; i++) { //L arrayini random doldurdum.
			for(int j=0; j<5; j++) {
				L[i][j]=(int)(Math.random()*4);
			}
		}
		
		Double[][] R = MatMul.<Integer>multiply(K,L);
		MatMul.yazdir(R);
	}

}
