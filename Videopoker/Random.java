import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class Random {
	
	// parâmetros para geração
	private long p = 2147483648L;
	private long m = 843314861;
	private long a = 453816693;
	
	// essa é a semente
	private long xi = 1023;
	
	public Random() throws InterruptedException {
		TimeUnit.MILLISECONDS.sleep(2);
		xi = (long)Calendar.getInstance().getTimeInMillis()%p;
	}
	
	public Random(int k) {
		xi = (int)k;
	}
	
	public void setSemente(int semente) {
		xi = (int)semente;
	}
	
	public double getRand() {
		
		// gera valor entre 0 e 1
		xi = (a + (m * xi)) % p;
		double d = xi;
		return d/p;
	}
	
	public int getIntRand(int max) {
		// gera valor entre 0 e 1
		// multiplica por máx
		
		double x = getRand()*max;
		
		return (int)x;
	}
	
//	public int getIntRand(int min, int max) {
//		if (max <= min) {
//			throw new IllegalArgumentException("Parâmetros inválidos.");
//		}
//		return min + getIntRand(max - min);
//	}
	
//	public int getIntRand() {
//		return getIntRand(Integer.MAX_VALUE);
//	}
	
//	@Override
//	public String toString() {
//		return xi + "";
//	}
	
}