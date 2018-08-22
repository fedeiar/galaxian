package TDACola;
public class ColaConEnlaces<T> implements Queue<T>{
	
	//atributos
	
		protected Nodo<T> head, tail;
		protected int tamaño;
		
	//constructor
		
		public ColaConEnlaces() {
			head=null;
			tail=null;
			tamaño=0;
		}
		
	//metodos
		
		public void enqueue(T e){
				Nodo<T> nodo = new Nodo<T>();
				nodo.setElemento(e);
				nodo.setSiguiente(null);
				if (tamaño==0)
					head=nodo;
				else
					tail.setSiguiente(nodo);
				tail=nodo;
				tamaño++;
		}
		
		public T dequeue() throws EmptyQueueException {
			if (tamaño==0)
				throw new EmptyQueueException ("la cola esta vacia");
			else {
				T aux= head.getElemento();
				head=head.getSiguiente();
				tamaño--;
				if(tamaño==0)
					tail=null;
				return aux;
			}			
		}
		
		public T front()throws EmptyQueueException {
			if (tamaño==0)
				throw new EmptyQueueException ("la cola esta vacia");
			else
				return head.getElemento();
		}
		
		public boolean isEmpty() {
			return tamaño==0;
		}
		
		public int size() {
			return tamaño;
		}
}
