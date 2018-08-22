package TDACola;

public class ColaCircular<T> implements Queue<T> {
	
	//atributos
		
		private T[] A;
		private int f,r;
		
	//constructor
		
		public ColaCircular(int max) {
			A=(T[])	 new Object[max];
			f=0;
			r=0;
		}
		
		public ColaCircular() {
			A=(T[])	 new Object[10];
			f=0;
			r=0;
		}
		
	//metodos
		
		public boolean isEmpty() {
			return f==r;
		}
		
		public T front() throws EmptyQueueException {
			if (isEmpty())
				throw new EmptyQueueException ("la cola esta vacia");
			else
				return A[f];
		}
		
		public T dequeue() throws EmptyQueueException {
			if(isEmpty())
				throw new EmptyQueueException ("la cola esta vacia");
			T aux= A[f];
			A[f]=null;
			f = (f+1) % (A.length);
			return aux;
			
		}
		
		public void enqueue (T e){
			if(size()==A.length-1) {
				T[] B = (T[]) new Object[A.length*2];
				
				if(r>f) {
					
					for(int i=0 ; i<r ; i++)
						B[i]=A[i];
					
				}
				else {
					int aux=0;
					for(int i=f ; i<A.length ; i++) {
						B[aux] = A[i];
						aux++;
					}
					for(int i=0 ; i<r ; i++) {
						B[aux] = A[i];
						aux++;
					}
					f=0;
					r=aux;
				}
				
				A=B;
			}
			
			A[r]=e;
			r=(r+1) % A.length;
		}
		
		public int size() {
			return (A.length - f + r) % (A.length);
		}

}
