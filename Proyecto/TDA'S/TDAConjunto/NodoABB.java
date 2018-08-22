package TDAConjunto;



public class NodoABB<E> {	
	
	//atributos
	
	private E e;
	private NodoABB<E> padre, izq, der;
	
	//constructor

	public NodoABB(E e, NodoABB<E> padre) {
		this.e=e;
		this.padre = padre;
		izq = der = null;
	}
	
	//metodos

	public E getE() {
		return e;
	}

	public NodoABB<E> getPadre() {
		return padre;
	}

	public NodoABB<E> getIzq() {
		return izq;
	}

	public NodoABB<E> getDer() {
		return der;
	}

	public void setE(E e) {
		this.e=e;
	}

	public void setIzq(NodoABB<E> izq) {
		this.izq = izq;
	}

	public void setDer(NodoABB<E> der) {
		this.der = der;
	}

	public void setPadre(NodoABB<E> padre) {
		this.padre = padre;
	}
}