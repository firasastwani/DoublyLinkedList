public class NodeType<T extends Comparable<T>> {

    public T info;
    public NodeType<T> next;
    public NodeType<T> back;

    public NodeType(T item){

        this.info = item;
        this.next = null;
        this.back = null;
    }

}
