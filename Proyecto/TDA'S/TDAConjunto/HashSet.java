package TDAConjunto;
import java.util.Iterator;

import TDALista.*;
import TDAMapeo.Entrada;
public class HashSet<E> implements Set<E> {

	//atributos
	
	private PositionList<E>[] T;
	private int size;
	private int N;
	
	//constructor
	
	public HashSet() {
		N=13;
		size=0;
		T = (PositionList<E>[]) new ListaDE[N];
		for (int i=0 ; i<N ; i++)
			T[i]= new ListaDE<E>();
	}
	
	//metodos
	
	private int funcionHash(E k) {
		int i = Math.abs(k.hashCode());
		return (i % N);
	}
	
	private boolean factorCarga() {
		float i = size/N;
		return i<0.9;
	}
	
	private void rehash (){
		N= N*2 +1;
		PositionList<E> [] A = T;
		T =  (PositionList<E>[]) new ListaDE[N];
		for(int i=0; i<N ; i++)
			T[i]= new ListaDE<E>();
		
		for(int i=0 ; i<A.length ; i++)
			for(E e : A[i]) {
				int p = funcionHash(e);
				T[p].addLast(e);
			}
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public E insert(E e) {
		if(!factorCarga())
			rehash();
		int p = funcionHash(e);
		for(E e1 : T[p])
			if(e1.equals(e))
				return null;
		T[p].addLast(e);
		size++;
		return e;
	}
	
	public E remove(E e) {
		int p = funcionHash(e);
		try {
		for(Position<E> e1:T[p].positions())
			if(e1.element().equals(e)) {
				T[p].remove(e1);
				size--;
				return e;
			}
		}
		catch(InvalidPositionException er) {
			er.printStackTrace();
		}
		return null;
	}
	
	public boolean pertenece(E e) {
		int p = funcionHash(e);
		for(E e1 : T[p])
			if(e1.equals(e))
				return true;
		return false;
	}
	
	public void union(Set<E> s) {
		for(E e : s) 
			if(!this.pertenece(e)) {
				int p=funcionHash(e);
				T[p].addLast(e);
				size++;
			}
	}
	
	public void intersection(Set<E> s) {
		try {
			for(int i=0; i<N ; i++)
				for(Position<E> e : T[i].positions())
					if(!s.pertenece(e.element())) {
						T[i].remove(e);
						size--;
					}
		}
		catch(InvalidPositionException e) {
			e.printStackTrace();
		}
	}
	
	public Iterator<E> iterator(){
		PositionList<E> L = new ListaDE<E>();
		for(int i=0; i<N ; i++)
			for(E e:T[i])
				L.addLast(e);
		return L.iterator();
	}


	
}
