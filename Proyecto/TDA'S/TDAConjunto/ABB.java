package TDAConjunto;

import java.util.Comparator;

import TDALista.*;

public class ABB<E> {

	// atributos

	private NodoABB<E> raiz;
	protected int size;
	Comparator<E> comp;

	// constructor

	public ABB(Comparator<E> c) {
		raiz = new NodoABB<E>(null,null);
		size = 0;
		comp = c;
	}

	public ABB() {
		this(new DefaultComparator<E>());
	}

	// metodos

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	// ---------------

	public E pertenece(E k) {
		NodoABB<E> n = buscar(k);
		
		if(n.getE()!=null)
			return n.getE();
		return null;
		
	}

	private NodoABB<E> buscar(E k) {
		return buscarAux(k, raiz);
	}

	private NodoABB<E> buscarAux(E k, NodoABB<E> n) {
		if (n.getE() == null)
			return n;
		else {
			int c = comp.compare(k, n.getE());
			if (c == 0)
				return n;
			else
				if (c < 0)
					return buscarAux(k, n.getIzq());
				else
					return buscarAux(k, n.getDer());
		}
	}

	// -------------

	public E insertar(E e) {
		return insertarAux(e,raiz);
	}

	private E insertarAux(E e, NodoABB<E> n) {
		if (n.getE() == null) {
			n.setE(e);
		
			size++;
			n.setDer(new NodoABB<E>(null, n));
			n.setIzq(new NodoABB<E>(null ,n));
			return null;
		} else {
			int c = comp.compare(e, n.getE());
			if (c == 0) {
				n.setE(e);
				return n.getE();
			}
			else if (c < 0)
				return insertarAux(e, n.getIzq());
			else
				return insertarAux(e, n.getDer());
		}

	}

	// ------------------

	public E eliminar(E k) {
		NodoABB<E> p = buscar(k);
		if (p.getE() != null) {
			E eliminado = p.getE();
			size--;
			eliminarAux(p);
			return eliminado;
		} 
		else
			return null;
	}

	private void eliminarAux(NodoABB<E> p) {
		if (isExternal(p)) {
			p.setE(null);
			p.setIzq(null);
			p.setDer(null);
		} 
		else {
			if (soloIzq(p)) {
				if(p!=raiz)
					if (p.getPadre().getIzq() == p)
						p.getPadre().setIzq(p.getIzq());
					else
						p.getPadre().setDer(p.getIzq());
				else
					raiz=p.getIzq();
				
				p.getIzq().setPadre(p.getPadre());	
			} 
			else 
				if (soloDer(p)) {
					if(p!=raiz)
						if (p.getPadre().getIzq() == p)
							p.getPadre().setIzq(p.getDer());
						else
							p.getPadre().setDer(p.getDer());
					else
						raiz=p.getDer();
					
					p.getDer().setPadre(p.getPadre());
				} 
				else {
					p.setE(eliminarMinimo(p.getDer()));
				}
		}
	}

	private E eliminarMinimo(NodoABB<E> n) {
		if (n.getIzq().getE() == null) {
			E aRetornar = n.getE();
			if (n.getDer().getE() == null) {
				n.setE(null);
				n.setIzq(null);
				n.setDer(null);
			} 
			else {
				if(n!=raiz)
					n.getPadre().setDer(n.getDer());
				else
					raiz=n.getDer();
				n.getDer().setPadre(n.getPadre());
			}
			return aRetornar;
		} 
		else {
			return eliminarMinimo(n.getIzq());
		}
	}

	private boolean isExternal(NodoABB<E> p) {
		return p.getIzq().getE() == null && p.getDer().getE() == null;
	}

	private boolean soloIzq(NodoABB<E> p) {
		return p.getIzq().getE() != null && p.getDer().getE() == null;
	}

	private boolean soloDer(NodoABB<E> p) {
		return p.getDer().getE() != null && p.getIzq().getE() == null;
	}

	// ------------
	
	

	public PositionList<E> Listado() {
		PositionList<E> L = new ListaDE<E>();
		inorder(raiz , L);
		return L;
	}

	private void inorder(NodoABB<E> n , PositionList<E> L) {
		if(n.getE()!=null) {
			inorder(n.getIzq() , L);
			L.addLast(n.getE());
			inorder(n.getDer() , L);
		}
	}
}
