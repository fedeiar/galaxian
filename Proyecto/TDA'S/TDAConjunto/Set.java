package TDAConjunto;
import java.util.Iterator;
public interface Set<E> extends Iterable<E> {
	
	public int size();
	
	public boolean isEmpty();
	/**
	 * Inserta un elemento en el conjunto. retorna null si el elemento ya se encontraba en el conjunto.
	 * @param e
	 * @return
	 */
	public E insert(E e);
	/**
	 * Elimina el elemento pasado por parametro y lo retorna, retorna null si el elemento no estaba en el conjunto.
	 * @param e
	 * @return
	 */
	public E remove(E e);
	
	public boolean pertenece(E e);
	
	public void union(Set<E> s);
	
	public void intersection(Set<E> s);
	
	public Iterator<E> iterator();

}
