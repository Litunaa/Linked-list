public class Node<T> {
    private T data;
    private Node<T> next;



    public Node(T data, Node<T> next){
        this.data = data;
        this.next = next;
    }

    public T val(){
        return this.data;
    }

    public Node<T> next(){
        return this.next;
    }

    public void setVal(T data){
        this.data = data;
    }
    
    public void setNext(Node<T> node){
        this.next = node;
    }
    
}
