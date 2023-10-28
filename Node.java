public class Node<T> {
    private T data;
    private Node next;



    public Node(T data, Node next){
        this.data = data;
        this.next = next;
    }

    public T val(){
        return this.data;
    }

    public Node next(){
        return this.next;
    }

    public void setVal(T data){
        this.data = data;
    }
    
    public void setNext(Node node){
        this.next = node;
    }
    
}
