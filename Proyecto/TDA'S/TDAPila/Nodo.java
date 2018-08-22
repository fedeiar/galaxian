package TDAPila;

public class Nodo<T> {

	//atributos
	
		private T elemento;
		private Nodo<T> siguiente;
	
	//constructores
	
		public Nodo() { 
			this(null, null); 
		} 
	
		public Nodo( T item ) {
			this(item,null); 
		}
	
		public Nodo( T item, Nodo<T> sig ) { 
			elemento=item; 
			siguiente=sig; 
		}
	
	//metodos
	
		public  T getElemento() { 
			return elemento;
		}
	
		public void setElemento( T elemento ){ 
			this.elemento=elemento;
		}
	
		public Nodo<T> getSiguiente(){
			return siguiente;
		}
	
		public void setSiguiente( Nodo<T> siguiente ) { 
			this.siguiente = siguiente; 
		}
	
}

