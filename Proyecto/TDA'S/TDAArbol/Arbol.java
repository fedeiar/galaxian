package TDAArbol;
import java.util.EmptyStackException;
import java.util.Iterator;
import TDALista.*;
import TDAPila.*;
public class Arbol<E> implements Tree<E> {
	
	//atributos
	
		protected Tnodo<E> raiz;
		protected int size;
		
	//constructor
		
		public Arbol() {
			raiz=null;
			size=0;
		}
		
	//metodos
		
		public int size() {
			return size;
		}
		
		public boolean isEmpty() {
			return size==0;
		}
		
		public Position<E> root() throws EmptyTreeException{
			if(isEmpty())
				throw new EmptyTreeException("arbol vacio");
			return raiz;
		}
		
		public Position<E> parent (Position<E> v) throws InvalidPositionException, BoundaryViolationException{
			Tnodo<E> n = checkPosition(v);
			if (n.getPadre()==null)
				throw new BoundaryViolationException("error al pedir parent a la raiz");
			return n.getPadre();
		}
		
		private Tnodo<E> checkPosition (Position<E> v) throws InvalidPositionException{
			try {
				if(v==null || isEmpty())
					throw new InvalidPositionException("posicion nula o invalida");
				return (Tnodo<E>) v;
			}
			catch(ClassCastException e) {
				throw new InvalidPositionException("el parametro no era de tipo Tnodo");
			}
		}
		
		public boolean isInternal(Position<E> v) throws InvalidPositionException{
			Tnodo<E> n = checkPosition(v);
			return !(n.getHijos().isEmpty());
		}
		
		public boolean isExternal(Position<E> v) throws InvalidPositionException{
			Tnodo<E> n = checkPosition(v);
			return (n.getHijos().isEmpty());
		}
		
		public boolean isRoot(Position<E> v) throws InvalidPositionException{
			Tnodo<E> n = checkPosition(v);
			return(n==raiz);
		}
		
		public void createRoot(E e) throws InvalidOperationException{
			if (size>0)
				throw new InvalidOperationException("el arbol ya tiene raiz");
			raiz= new Tnodo<E>(e);
			size=1;
		}
		
		public Position<E> addFirstChild(Position<E> p , E e) throws InvalidPositionException{
			Tnodo<E> n = checkPosition(p);
			Tnodo<E> fc = new Tnodo<E>(e,n);
			n.getHijos().addFirst(fc);
			size++;
			return fc;
		}
	
		public Position<E> addLastChild(Position<E> p , E e) throws InvalidPositionException{
			Tnodo<E> n = checkPosition(p);
			Tnodo<E> fc = new Tnodo<E>(e,n);
			n.getHijos().addLast(fc);
			size++;
			return fc;
		}
		
		public Position<E> addBefore(Position<E> p , Position<E> rb , E e) throws InvalidPositionException{
			Tnodo<E> pa = checkPosition(p);
			Tnodo<E> bro = checkPosition(rb);
			Tnodo<E> n = new Tnodo<E>(e,pa);
			PositionList<Tnodo<E>> hijos = pa.getHijos();
			Iterator<Position<Tnodo<E>>> it = hijos.positions().iterator();
			Position<Tnodo<E>> broR=null;
			boolean esta=false;
			while(it.hasNext() && !esta) {
				broR=it.next();
				esta= broR.element()==bro;
			}
			if(!esta)
				throw new InvalidPositionException("rb no es hijo de P");
			hijos.addBefore(broR, n);
			size++;
			return n;
		}
		
		public Position<E> addAfter(Position<E> p , Position<E> lb , E e) throws InvalidPositionException{
			Tnodo<E> pa = checkPosition(p);
			Tnodo<E> bro = checkPosition(lb);
			Tnodo<E> n = new Tnodo<E>(e,pa);
			PositionList<Tnodo<E>> hijos = pa.getHijos();
			Iterator<Position<Tnodo<E>>> it = hijos.positions().iterator();
			Position<Tnodo<E>> broL=null;
			boolean esta=false;
			while(it.hasNext() && !esta) {
				broL=it.next();
				esta= broL.element()==bro;
			}
			if(!esta)
				throw new InvalidPositionException("lb no es hijo de P");
			hijos.addAfter(broL, n);
			size++;
			return n;
		}
		
		public void removeExternalNode (Position<E> p) throws InvalidPositionException {
				Tnodo<E> n = checkPosition( p );
				if( !isExternal(p) )
					throw new InvalidPositionException( "el nodo no es externo" );
				if (n==raiz)
					raiz=null;
				else {
					Tnodo<E> pa = n.getPadre();
					PositionList<Tnodo<E>> hijos = pa.getHijos();
					boolean encontre = false; 
					Position<Tnodo<E>> h = null;
					Iterator<Position<Tnodo<E>>> it = hijos.positions().iterator();
					
					while( it.hasNext() && !encontre ) {
					h = it.next();
					encontre = h.element() == n;
					}
					if( !encontre )
					throw new InvalidPositionException( "p no es del arbol" );
					hijos.remove( h );
					n.setPadre(null);
					n.setElemento(null);
				}
				size--;
		}
		
		public void removeInternalNode(Position<E> p) throws InvalidPositionException{
			Tnodo<E> n = checkPosition(p);
			if(isExternal(p))
				throw new InvalidPositionException("el nodo no es interno");
			if(n==raiz)
				if(n.getHijos().size()>1)
					throw new InvalidPositionException("el nodo raiz a eliminar no puede tener mas de 1 hijo");
				else {
					try {
					raiz=n.getHijos().first().element();
					n.setElemento(null);
					n.getHijos().remove(n.getHijos().first());
					raiz.setPadre(null);
					}
					catch(EmptyListException e) {
						e.printStackTrace();
					}
				}
			else {
				Tnodo<E> pa= n.getPadre();
				PositionList<Tnodo<E>> hijos = pa.getHijos();
				Iterator<Position<Tnodo<E>>> it =hijos.positions().iterator();
				Position<Tnodo<E>> me=null;
				boolean encontre = false;
				while(it.hasNext() && !encontre) {
					me=it.next();
					encontre=me.element()==n;
				}
				if (!encontre)
					throw new InvalidPositionException("n no figura como hijo de su padre");
				PositionList<Tnodo<E>> hijosN = n.getHijos();
				it = hijosN.positions().iterator();
				while(it.hasNext()) {
					Tnodo<E> nh= it.next().element();
					nh.setPadre(pa);
					hijos.addBefore(me, nh);
				}
				hijos.remove(me);
				n.setPadre(null);
				it = hijosN.positions().iterator();
					while( it.hasNext())
						hijosN.remove(it.next());
				size--;
			}
		}
			
		public void removeNode (Position<E> p) throws InvalidPositionException {
			if(isExternal(p))
				removeExternalNode(p);	
			else
				removeInternalNode(p);
		}
		
		public E replace (Position<E> v, E e) throws InvalidPositionException{
			Tnodo<E> n = checkPosition(v);
			E aux= v.element();
			n.setElemento(e);
			return aux;
		}
		
		public Iterable <Position<E>> children (Position<E> v) throws InvalidPositionException{
			Tnodo<E> p = checkPosition(v);
			PositionList<Tnodo<E>> hijos = p.getHijos();
			Iterator<Tnodo<E>> it = hijos.iterator();
			PositionList<Position<E>> li = new ListaDE<Position<E>>();
			while(it.hasNext())
				li.addLast(it.next());
			return li;
		}
		
		public Iterable<Position<E>> positions()  {
			PositionList<Position<E>> l = new ListaDE<Position<E>>();
			if( !isEmpty() )
				pre( l, raiz );
			return l;
			
		}
		
		private void pre(PositionList<Position<E>> l, Tnodo<E> r) {
			l.addLast(r);
			PositionList<Tnodo<E>> hijos = r.getHijos();
			Iterator<Tnodo<E>> it = hijos.iterator();
			while(it.hasNext())
				pre(l,it.next());	
		}
		
		public Iterator<E> iterator(){
			PositionList<E> l = new ListaDE<E>();
			Iterator<Position<E>> it = this.positions().iterator();
			while (it.hasNext())
				l.addLast(it.next().element());
			return l.iterator();
		}
		
		
		//---------------------------------------------------------
		//------------------METODOS AJENOS A TREE------------------
		//---------------------------------------------------------
		
		
		public Tree<E> clone(){
			Tree<E> T = new Arbol<E>();
			try {
				if(size>0) {
					T.createRoot(raiz.element());
					preclon(T,T.root(),raiz);
				}
			}
			catch(InvalidOperationException | EmptyTreeException e) {
				e.printStackTrace();
			}
			return T;
		}
		
		private void preclon(Tree<E> T , Position<E> n , Tnodo<E> r) {
			try {
				for(Tnodo<E> h:r.getHijos()) {
					Position<E> nh=T.addLastChild(n, h.element());
					preclon(T , nh , h);
				
				}
			}
			catch(InvalidPositionException e) {
				e.printStackTrace();
			}
		}
		
		
		//-------------------------------
		
		public  PositionList<Position<E>> HEI(){
			PositionList<Position<E>> L = new ListaDE<Position<E>>();
			if(raiz!=null) {
				Tnodo<E> n = raiz;
				pre1(L,n);
			}
			return L;
		}
		
		private void pre1(PositionList<Position<E>> L , Tnodo<E> r) {
			try {
				for(Tnodo<E> h : r.getHijos()) {
					if(r.getHijos().first().element()==h && !h.getHijos().isEmpty())
						L.addLast(h);
					pre1(L,h);
				}
			}
			catch(EmptyListException e) {
				e.printStackTrace();
			}
		}
		
		//---------------------------------
		
		public void eliminaHEI() {
			if (raiz!=null) {
				Tnodo<E> n = raiz;
				pos(n);
			}
		}
		
		public void pos (Tnodo<E> p) {
			try {
				for(Tnodo<E> h : p.getHijos()) {
					pos(h);
					if(h==p.getHijos().first().element() && !h.getHijos().isEmpty())
						removeInternalNode(h);
				}
			}
			catch(EmptyListException | InvalidPositionException e) {
				e.printStackTrace();
			}
		}
		
		//-------------------------------------
		
		public void eliminaExs() {
			if(raiz!=null) {
				Tnodo<E> n = raiz;
				pre2(n);
			}
		}
		
		private void pre2(Tnodo<E> p) {
			try {
				for(Tnodo<E> h : p.getHijos()) {
					if(h.getHijos().isEmpty())
						removeExternalNode(h);
					else
						pre2(h);
				}
			}
			catch(InvalidPositionException e) {
				e.printStackTrace();
			}
		}
		
		//------------------------------------
		
		 public void eliminaRotulo(E r) {
			 if(raiz!=null)
				 posdelete(raiz,r);
		 }
		 
		 private void posdelete(Tnodo<E> p, E e) {
			 try {
				 for(Tnodo<E> h : p.getHijos())
					 posdelete(h,e);
				 if(p.element()==e)
					 removeNode(p);
			 }
			catch(InvalidPositionException e1) {
				e1.printStackTrace();
			}
		 }
		
		//--------------------------------------
		 
		 public PositionList<Position<E>> camino(Position<E> ps1, Position<E> ps2){
			 
			 PositionList<Position<E>> L = new ListaDE<Position<E>>();
			 Stack<Position<E>> p1= new PilaConEnlaces<Position<E>>();
			 Stack<Position<E>> p2= new PilaConEnlaces<Position<E>>();
			 Stack<Position<E>> p3= new PilaConEnlaces<Position<E>>();
			 try {
				 Tnodo<E> n1=checkPosition(ps1);
				 Tnodo<E> n2=checkPosition(ps2);
				 while(n1!=null) {
					 p1.push(n1);
					 n1=n1.getPadre();
				 }
				 
				 while(n2!=null) {
					 p2.push(n2);
					 n2=n2.getPadre();
				 }
				 
				 Position<E> aux=null;
				 while( ( !p1.isEmpty() && !p2.isEmpty() )&& ( p1.top()==p2.top()) ) {
					 aux=p1.pop();
					 p2.pop();
				 }
				 
				 while(!p1.isEmpty())
					 p3.push(p1.pop());
				 while(!p3.isEmpty())
					 L.addLast(p3.pop());
				 L.addLast(aux);
				 while(!p2.isEmpty())
					 L.addLast(p2.pop());
			 }
			 catch(EmptyStackException | InvalidPositionException e) {
				 e.printStackTrace();
			 }
			 return L;
		 }
		 
		 //--------------------------------------
		 
		 public int profundidad(Position<E> p) {
			 int i = 0;
			 try {
				 Tnodo<E> n = checkPosition(p);
				 while(n!=null) {
					 System.out.println(n.element());
				 	n=n.getPadre();
				 	i++;
				 }
			 }
			 catch(InvalidPositionException e) {
				 e.printStackTrace();
			 }
			 return i-1;
		 }
		 
		 //-------------------------------------
		 
		 public int altura(Position<E> ps) {
			 try {
				 Tnodo<E> n = checkPosition(ps);
				 PositionList<Tnodo<E>> camino = height(n);
				 /*
				 for(Tnodo<E> p : camino)
					 System.out.println(p.element());
				 */
				 return camino.size()-1;
			 }
			 catch(InvalidPositionException e) {
				 e.printStackTrace();
			}
			return -1; 
		 }
		 
		 private PositionList<Tnodo<E>> height(Tnodo<E> n){
			 PositionList<Tnodo<E>> L= new ListaDE<Tnodo<E>>();
			 if(n.getHijos().isEmpty()) 
				 L.addLast(n);
			 else {
				 int max=0;
				 for(Tnodo<E> h : n.getHijos()) {
					 PositionList<Tnodo<E>> camino=height(h);
					 if(camino.size()>max) {
						 max=camino.size();
						 L=camino;
					 }
				 }
				 L.addLast(n);
			 }
			 return L;
		 }
		 
		 //------------------------------------
		 
		 public int alturaR(E r) {
			 if(raiz==null)
				 return-1;
			 Tnodo<E> n= prebusqueda(r,raiz);
			 if (n==null)
				 return -1;
			 else
				 return altura(n); 
		 }
		 
		 private Tnodo<E> prebusqueda(E e,Tnodo<E> n){
			 Tnodo<E> aux=null;
			 if(n.element().equals(e))
				 aux= n;
			 else {
				 Iterator<Tnodo<E>> it = n.getHijos().iterator();
				 while(it.hasNext() && aux!=null) {
					 aux = prebusqueda(e,it.next());
				 }
			 }
				 return aux;
			 
		 }
		 	
		 //---------------------------------------------------------------------------
		 
		 public void insertaHED(E r , int A) {
			 if(raiz!=null && A>0)
				 preinsert(r,A,raiz);
		 }
		 
		 private void preinsert(E e, int A , Tnodo<E> n) {
			 if(altura(n)==A) {
				 n.getHijos().addLast(new Tnodo<E>(e));
				 size++;
			 }
			 else
				 if(altura(n)> A)
					 for(Tnodo<E> h : n.getHijos())
						 preinsert(e,A,h);
		 }
		 
		 //---------------------------------------------------------------------------------
		 
		 public void ReversedChildren(E r) {
			 if(raiz!=null)
				 postwist(r,raiz);
		 }
		 
		 private void postwist(E e,Tnodo<E> n) {
			 for (Tnodo<E> h: n.getHijos())
				 postwist(e,h);
			 if(n.element()==e && !n.getHijos().isEmpty())
				 invertir(n.getHijos());
		 }
		 
		 private void invertir(PositionList<Tnodo<E>> L) {
			 try {
				 Position<Tnodo<E>> f = L.first();
				 Position<Tnodo<E>> l = L.last();
				 while( (f!=l) && L.next(f)!=l){
					 Tnodo<E> aux = L.set(f, l.element());
					 L.set(l, aux);
					 f=L.next(f);
					 l=L.prev(l);
				 }
				 if(f!=l)
					 if(L.next(f)==l) {
						 Tnodo<E> aux= L.set(f, l.element());
						 L.set(l, aux);
					 }
			 }
			 catch(BoundaryViolationException | InvalidPositionException | EmptyListException e) {
				 e.printStackTrace();
			 }
		 }
}
