package TDAConjunto;
import java.util.Comparator;
import java.util.Iterator;
public class BSTSet<E> implements Set<E> {

	//atributos
	
	private ABB<E> T;
	private Comparator<E> comp;
	
	//constructor
	
	public BSTSet(Comparator<E> c) {
		comp = c;
		T= new ABB<E>(c);
	}
	
	public BSTSet() {
		this(new DefaultComparator<E>());
	}
	
	//metodos
	
	public int size() {
		return T.size();
	}
	
	public boolean isEmpty() {
		return size()==0;
	}
	
	public E insert(E e) {
		E aux = T.pertenece(e);
		if(aux!=null)
			return null;
		T.insertar(e);
		return e;
	}
	
	public E remove(E e) {
		return T.eliminar(e);
	}
	
	public boolean pertenece(E e) {
		return T.pertenece(e)!=null;
	}
	
	public void union(Set<E> s) {
		for(E e : s) {
			if(T.pertenece(e)==null)
				T.insertar(e);
		}
	}
	
	public void intersection(Set<E> s) {
		for(E e : T.Listado())
			if(!s.pertenece(e))
				T.eliminar(e);
		
	}
	
	public Iterator<E> iterator(){
		return T.Listado().iterator();
	}
	
	
}
