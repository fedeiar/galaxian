package TDAColaCP;
import java.security.InvalidKeyException;
import java.util.Comparator;
import TDALista.*;
public class ListPriorityQueue<K,V> implements PriorityQueue<K,V> {

	//atributos
	
		private PositionList<Entrada<K,V>> L;
		private Comparator<K> comp;
		private int size;
		
	//constructores
		
		public ListPriorityQueue() {
			this(new DefaultComparator<K>());
		}
		
		public ListPriorityQueue(Comparator<K> c) {
			L= new ListaDE<Entrada<K,V>>();
			comp= c;
			size=0;
		}
		
	//metodos
		
		public boolean isEmpty() {
			return size==0;
		}
		
		public int size() {
			return size;
		}
		
		public Entry<K,V> min() throws EmptyPriorityQueueException{
			try {
				return L.first().element();
			}
			catch(EmptyListException e) {
				throw new EmptyPriorityQueueException("error: CP vacia");
			}
		}
		
		public Entry<K,V> removeMin() throws EmptyPriorityQueueException{
			try {
				Entrada<K,V> e =  L.remove(L.first());
				size--;
				return e;
			}
			catch(InvalidPositionException | EmptyListException e) {
				throw new EmptyPriorityQueueException("error: CP vacia");
			}
		}
		
		public Entry<K,V> insert(K key, V value) throws InvalidKeyException{
			Entrada<K,V> e = new Entrada<K,V>(checkKey(key) ,  value);
			try {
				if(L.isEmpty())
					L.addLast(e);
				else {
					Position<Entrada<K,V>> p = L.first();
					while(comp.compare(e.getKey() , p.element().getKey()) >0 && p!=L.last())
						p=L.next(p);
					if(p==L.last() && comp.compare(e.getKey() , p.element().getKey())>0 )
						L.addAfter(p, e);
					else
						L.addBefore(p, e);
				}
				size++;
			}
			catch(EmptyListException | InvalidPositionException | BoundaryViolationException e1) {
				e1.printStackTrace();
			}
			return e;
		}
		
		private K checkKey(K key) throws InvalidKeyException {
			try {
					comp.compare(key, key);
			}
			catch(ClassCastException | NullPointerException e) {
				throw new InvalidKeyException("error: la clave no es comparable");
			}
			return key;
		}

}
