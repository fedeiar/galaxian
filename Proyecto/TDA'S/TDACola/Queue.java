package TDACola;
public interface Queue<T> {
	
	// Inserta el elemento e al final de la cola
	public void enqueue(T e);
	// Elimina el elemento del frente de la cola y lo retorna. 
	// Si la cola está vacía se produce un error.
	public T dequeue() throws EmptyQueueException ;
	// Retorna el elemento del frente de la cola. 
	// Si la cola está vacía se produce un error.
	public T front() throws EmptyQueueException ;
	// Retorna verdadero si la cola no tiene elementos 
	// y falso en caso contrario
	public boolean isEmpty();
	// Retorna la cantidad de elementos de la cola.
	public int size(); 

	
}
