public class LinkedList<T>{

    private Node<T> head;
    private int length;



    public LinkedList(){
        this.head = null;
        this.length = 0;
    }

    public boolean isEmpty(){
        return this.head == null;
    }

    public boolean isSorted(){
        if (this.head == null){
            return true;
        }
        if (!(this.head.val() instanceof Number)){
            System.out.println("This method is only compatible with LinkedLists consisting of numbers");
            return false;
        }
        Node <T> current = this.head.next();
        Node <T> prev = this.head;
        while (current != null){
            if ( ((Number) current.val()).doubleValue() < ((Number) prev.val()).doubleValue() ){
                return false;
            }
            prev = current;
            current = current.next();
        }
        return true;
    }

    public int length(){
        return this.length;
    }

    public void clear(){
        this.head = null;
        this.length = 0; 
    }

    public void append(T data){
        Node<T> newNode = new Node<T>(data, null);
        if (this.head == null){
            this.head = newNode;
        }

        else{
            Node<T> current = this.head;
            while (current.next() != null){
                current = current.next();
            }
            current.setNext(newNode);
        }
        this.length++;
    }

    public T getValueAt(int index){
        if (index >= length || index < 0){
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }

        Node<T> current = this.head;

        int currIndex = 0;

        while (currIndex <= index){
            current = current.next();
        }
        return current.val();

    }


    public int IndexOf(T data){
        Node<T> current = head;
        int currIndex = 0;
        while (current != null){
            if (current.val() == data){
                return currIndex;
            }
            current = current.next();
            currIndex++;
        }
        return -1;
    }

    public String IndexOfAll(T data){  // Returns index of all occurences 
        Node<T> current = head;
        StringBuilder indexes = new StringBuilder();
        int currIndex = 0;

        while (current != null){
            if (current.val() == data){
                indexes.append(currIndex + " ");
            }
            current = current.next();
            currIndex++;
        }
        return indexes.toString();
    }

    public String toString(){
        Node<T> current = this.head;
        StringBuilder list = new StringBuilder();

        while (current != null){
            list.append(String.valueOf(current.val()) + " -> ");
            current = current.next();
        }
        list.append("null");

        return list.toString();
    }


    public void remove(T val){
        Node<T> current = this.head;
        Node<T> prev = null;
        while (current != null){
            if (current.val() == val){
                current = current.next();
                prev.setNext(current);
            }
            else{
                prev = current;
                current = current.next();
            }
        }
        length--;
    }

    public void add(T data, int index){  
        if (index > length || index < 0){
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }

        Node<T> newNode = new Node<T>(data, null);

        if (index == 0){
            newNode.setNext(this.head);
            this.head = newNode;
            
        }

        else{
        Node<T> current = this.head;
        Node<T> prev = null;
        int currIndex = 0;

        while (currIndex < index){
            prev = current;
            current = current.next();
            currIndex++;
        }
        prev.setNext(newNode);
        newNode.setNext(current);
        }
        length++;
    }

    public boolean contains(T data){
        Node<T> current = head;

        while (current != null){
            if (current.val() == data){
                return true;
            }
            current = current.next();
        }
        return false;
    }
    public void reverse(){
        if (length <= 1){
            return;
        }

        Node<T> current = this.head;
        Node<T> prev = null;
        Node<T> temp = null;
        while (current != null){
            temp = current.next();
            current.setNext(prev);
            prev = current;
            current = temp;
        }

        this.head = prev;
    }



    public static void main(String[] args){
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.append(5);
        list.append(2);
        list.add(2, 2);
        list.append(4);
        list.append(4);
        list.append(4);
        list.append(9);
        list.add(7, 0);

        

        System.out.println(list.contains(190));
        
        
        
    }
}