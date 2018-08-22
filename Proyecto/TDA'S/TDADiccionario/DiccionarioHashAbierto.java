package TDADiccionario;


import TDALista.*;


public class DiccionarioHashAbierto<K,V> implements Dictionary<K,V> {
	
	//atributos
	
		private PositionList<Entrada<K,V>>[] T;
		private int size;
		private int N;
		
	//constructor
		
		public DiccionarioHashAbierto() {
			size=0;
			N=13;
			T=(PositionList<Entrada<K,V>>[]) new  ListaDE[N];
			for(int i=0 ; i<N ; i++) 
				T[i] = new ListaDE<Entrada<K,V>>();
		}
		
	//metodos
		
		public int size() {
			return size;
		}
		
		public boolean isEmpty() {
			return size==0;
		}
		
		public Entry<K,V> find(K k) throws InvalidKeyException{
			checkKey(k);
			int p = funcionHash(k);
			for(Entrada<K,V> e : T[p])
				if(e.getKey().equals(k)) {
					return e;
				}
			return null;
		}
		
		private void checkKey(K k) throws InvalidKeyException {
			if(k==null)
				throw new InvalidKeyException("la clave es nula");
		}
		
		private int funcionHash(K k) {
			int p = k.hashCode();
			return p % N;
		}
		
		public Iterable<Entry<K,V>> findAll(K k) throws InvalidKeyException{
			PositionList<Entry<K,V>> L = new ListaDE<Entry<K,V>>();
			checkKey(k);
			int p = funcionHash(k);
			for(Entry<K,V> e : T[p]) {
				if(e.getKey().equals(k))
					L.addLast(e);
			}
			return L;
		}
		
		public Entry<K,V> insert(K k, V v) throws InvalidKeyException{
			checkKey(k);
			if(!factorCarga())
				reHash();
			int p = funcionHash(k);
			Entrada<K,V> e = new Entrada<K,V>(k,v);
			T[p].addLast(e);
			size++;
			return e;
		}
		
		private boolean factorCarga() {
			float i = size/N;
			return i<0.9;
		}
		
		private void reHash() {
			N= N*2 +1;
			PositionList<Entrada<K,V>> [] A = T;
			T =  (PositionList<Entrada<K,V>>[]) new PositionList[N];
			for(int i=0; i<N ; i++)
				T[i]= new ListaDE<Entrada<K,V>>();
			
			for(int i=0 ; i<A.length ; i++)
				for(Entrada<K,V> e : A[i]) {
					int p = funcionHash(e.getKey());
					T[p].addLast(e);
				}
		}
		
		public Entry<K,V> remove(Entry<K,V> ent) throws InvalidEntryException{
			Entrada<K,V> e = checkEntry(ent);
			int p = funcionHash(e.getKey());
			try {
				for(Position<Entrada<K,V>> aux : T[p].positions())
					if(e.equals(aux.element())) {
						T[p].remove(aux);
						size--;
						return e;
					}
			}
			catch(InvalidPositionException e1) {
				e1.printStackTrace();
			}
			throw new InvalidEntryException("la entrada no se encuentra en el diccionario");
					
		}
		
		private Entrada<K,V> checkEntry(Entry<K,V> e) throws InvalidEntryException {
			try {
				if(e==null)
					throw new InvalidEntryException("la entrada es nula");
				return (Entrada<K,V>) e;
			}
			catch(ClassCastException e1) {
				throw new InvalidEntryException("el parametro no es un entry");
			}
		}
		
		public Iterable<Entry<K,V>> entries(){
			PositionList<Entry<K,V>> L = new ListaDE<Entry<K,V>>();
			for(int i=0; i<N ; i++)
				for(Entrada<K,V> e : T[i])
					L.addLast(e);
			return L ;
		}



}
