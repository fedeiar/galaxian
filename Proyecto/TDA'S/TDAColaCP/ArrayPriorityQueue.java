package TDAColaCP;

import java.security.InvalidKeyException;
import java.util.Comparator;

import javax.sound.midi.SysexMessage;

public class ArrayPriorityQueue<K,V> implements PriorityQueue<K,V>{

	//atributos
	
		private Entrada<K,V>[] T;
		private int f;
		private int r;
		private Comparator<K> comp;
		
	//constructores
		
		public ArrayPriorityQueue(Comparator<K> c , int max) {
			T = (Entrada<K,V>[]) new Entrada[max];
			f=0;
			r=0;
			comp=c;
		}
		
		public ArrayPriorityQueue() {
			this(new DefaultComparator<K>() , 10);
		}
		
		public ArrayPriorityQueue(Comparator<K> c) {
			this(c,10000);
		}
		
		public ArrayPriorityQueue(int max) {
			this(new DefaultComparator<K>() , max);
		}
		
		
	//metodos
		
		public int size() {
			return 	(T.length - f + r) % T.length;
		}
		
		public boolean isEmpty() {
			return f==r;
		}
		
		public Entry<K,V> min() throws EmptyPriorityQueueException{
			if (isEmpty())
				throw new EmptyPriorityQueueException("error: CP vacia");
			return T[f];
		}
		
		public Entry<K,V> removeMin() throws EmptyPriorityQueueException{
			if(isEmpty())
				throw new EmptyPriorityQueueException("error: CP vacia");
			Entry<K,V> aux = T[f];
			T[f]=null;
			f= (f+1) % T.length;
			return aux;
		}
		
		public Entry<K,V> insert(K key, V value) throws InvalidKeyException{
			if(size()==T.length-1) {
				Entrada<K,V>[] B = (Entrada<K,V>[]) new Entrada[T.length*2];
				if(r>f) {
					for(int i=0 ; i<r ; i++)
						B[i]=T[i];
				}
				else {
					int aux=0;
					for(int i=f ; i<T.length ; i++) {
						B[aux] = T[i];
						aux++;
					}
					for(int i=0 ; i<r ; i++) {
						B[aux] = T[i];
						aux++;
					}
					f=0;
					r=aux;
				}
				T=B;
			}

			Entrada<K,V> e = new Entrada<K,V>( checkKey(key) , value );
			if(size()==0)
				T[f]=e;
			else { 
					int i = f;
					while ((i!=r) && (comp.compare(e.getKey(), T[i].getKey())>0)) {
						i = (i+1) % T.length;
					}
					int a=r;
					while(a!=i) {
						T[a]=T[(a+T.length-1) % T.length];
						a= (a+T.length-1) % T.length;
					}
					T[i]=e;
			}
			r = (r+1) % T.length;
			return e;
		}
		
		private K checkKey (K k) throws InvalidKeyException{
			try {
				comp.compare(k,k);
			}
			catch(ClassCastException | NullPointerException e) {
				throw new InvalidKeyException("la clave no es comparable");
			}
			return k;
		}
}
