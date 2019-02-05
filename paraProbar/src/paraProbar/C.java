package paraProbar;

public class C extends B{

	public C() {
		
	}
	
	public C ret(B b) {
		System.out.println("Estoy en C");
		return new C();
	}
}
