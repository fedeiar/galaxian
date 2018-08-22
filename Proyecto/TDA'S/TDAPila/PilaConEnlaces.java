package TDAPila;
import java.util.EmptyStackException;

public class PilaConEnlaces<T> implements Stack<T> {
	
	//atributos
		
		protected Nodo<T> head;
		protected int tamaño; 
		
	//constructor
		
		public PilaConEnlaces() {
			head=null;
			tamaño=0;
		}
		
	//metodos
		
		public boolean isEmpty() {
			return tamaño==0;
		}
		
		public void push(T item) {
			Nodo<T> aux  = new Nodo<T>();
			aux.setElemento( item );
			aux.setSiguiente( head );
			head = aux;
			tamaño = tamaño + 1;
		}

		public T pop() throws EmptyStackException{
			if (isEmpty())
				throw new EmptyStackException();
			else {
				T aux = head.getElemento();
				head = head.getSiguiente();
				tamaño--;
				return aux;
			}
		}
		
		public T top() throws EmptyStackException{
			if (isEmpty())
				throw new EmptyStackException();
			else
				return head.getElemento();
				
		}
		
		
		public int size() {
			return tamaño;
		}
		
}
