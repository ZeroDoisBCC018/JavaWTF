package Principal;

public class Random {
	private long p = 2147483648l;
	private long m = 843314861;
	private long a = 453816693;
	
	// Semente
	private long xi = 1023;


	public double getRand() {
		xi = (a + m * xi) % p;
		double d = xi;
		return d / p;
	}
	
	// Retorna valor aleatório
	public int getIntRand(int max){
		double d = getRand() * max;
		return (int) d;
	}

	// Define uma semente
	public void setSemente(int semente) {
       xi = semente;		
	}

	public Random(int k){
		xi = k;
	}
	
	public Random() {
		
	}
	
}