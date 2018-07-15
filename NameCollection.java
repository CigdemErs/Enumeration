package odev;

public class NameCollection {
	public String [] names;
	public int j=0;
	
	public NameCollection (String [] names) {
		this.names=names;
	}
	
	public Enumeration getEnumeration () {
		Enumeration Enumeration = new Enumeration() {
				
			@Override
			public boolean hasNext() {
				boolean b=false;
				int x=j+1;
				if(j<names.length-1) {
					if(names[x]!=null) {//pointerin bulundugu elemandan sonrakinin olup olmadigini kontrol eder.
						b=true;
					}
				}
				return b;
			}

			@Override
			public Object getNext() {
				String cumle="";
				String simdiki=names[j];
				if(hasNext()) { //suan ki elemandan sonra eleman varsa sonrakini yazdirir.
					j=j+1;
					cumle=names[j]; 
				}
				
				return cumle;
			}
			
		};
		return Enumeration;
	}
}
