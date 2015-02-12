package AST;

public class ObjectGeneric<T> {
	
	private T t;

	public T get(){
        return this.t;
    }
     
    public void set(T t1){
        this.t=t1;
    }

}


/*
 * public class ComponentGroup<T extends JComponent> {
   private ArrayList<T> components; // For storing the components in this group.
   public void repaintAll() {
      for ( JComponent c : components )
         if (c != null)
            c.repaint();
   }
   --------
   class Queue<T> {
   private LinkedList<T> items = new LinkedList<T>();
   public void enqueue(T item) {
      items.addLast(item);
   }
   public T dequeue() {
      return items.removeFirst();
   }
   public boolean isEmpty() {
      return (items.size() == 0);
   }
   public void addAll(Collection<? extends T> collection) {
         // Add all the items from the collection to the end of the queue
      for ( T item : collection ) 
         enqueue(item);
   }
}
*/
