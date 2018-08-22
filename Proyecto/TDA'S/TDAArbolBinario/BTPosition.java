package TDAArbolBinario;

public interface BTPosition<E> extends Position<E> {
	
	public void setElement(E e);
	
	public BTPosition<E> getLeft();
	
	public BTPosition<E> getRight();
	
	public BTPosition<E> getParent();
	
	public void setLeft(BTPosition<E> n);
	
	public void setRight(BTPosition<E> n);
	
	public void setParent(BTPosition<E> n);
	
}
