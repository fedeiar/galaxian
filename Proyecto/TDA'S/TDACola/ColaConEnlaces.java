package TDACola;
public class ColaConEnlaces<T> implements Queue<T>{
	
	//atributos
	
		protected Nodo<T> head, tail;
		protected int tama�o;
		
	//constructor
		
		public ColaConEnlaces() {
			head=null;
			tail=null;
			tama�o=0;
		}
		
	//metodos
		
		public void enqueue(T e){
				Nodo<T> nodo = new Nodo<T>();
				nodo.setElemento(e);
				nodo.setSiguiente(null);
				if (tama�o==0)
					head=nodo;
				else
					tail.setSiguiente(nodo);
				tail=nodo;
				tama�o++;
		}
		
		public T dequeue() throws EmptyQueueException {
			if (tama�o==0)
				throw new EmptyQueueException ("la cola esta vacia");
			else {
				T aux= head.getElemento();
				head=head.getSiguiente();
				tama�o--;
				if(tama�o==0)
					tail=null;
				return aux;
			}			
		}
		
		public T front()throws EmptyQueueException {
			if (tama�o==0)
				throw new EmptyQueueException ("la cola esta vacia");
			else
				return head.getElemento();
		}
		
		public boolean isEmpty() {
			return tama�o==0;
		}
		
		public int size() {
			return tama�o;
		}
}
