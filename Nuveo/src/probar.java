
public class probar {

	public static void main(String[] args) throws InterruptedException {
		
		long stime = System.currentTimeMillis();
		Thread.sleep(4000);
		long elapsedTime = System.currentTimeMillis() - stime;
		
		System.out.println(elapsedTime);

	}

}
