package TDAArbolBinario;

public class BTNode<E> implements BTPosition<E> {
	
	//atributos
	 	
		private E element;
		private BTPosition<E> left,right,parent;
		
	//constructor
		
		public BTNode(E e , BTPosition<E> l , BTPosition<E> r , BTPosition<E> p) {
			element = e;
			left = l;
			right = r;
			parent = p;
		}
		
		public BTNode(E e) {
			this(e,null,null,null);
		}
		
		public BTNode() {
			this(null,null,null,null);
		}
		
		
	//metodos
		
		public E element() {
			return element;
		}
		public void setElement(E e){
			element = e;
		}
		public BTPosition<E> getLeft(){
			return left;
		}
		public BTPosition<E> getRight(){
			return right;
		}
		public BTPosition<E> getParent(){
			return parent;
		}
		public void setLeft(BTPosition<E> n){
			left = n;
		}
		public void setRight(BTPosition<E> n){
			right = n;
		}
		public void setParent(BTPosition<E> n){
			parent = n;
		}
}
