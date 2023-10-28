import java.util.LinkedList;

public class LinkedList<T>{

    private Node<T> head;
    private int length;



    public LinkedList(){ // Constructs default values to each linked list
        this.head = null;
        this.length = 0;
    }

    public boolean isEmpty(){ // Returns wheter the linked list is empty or not 
        return this.head == null;
    }

    public boolean isSorted(){ // Returns wheter the linke d list is sorted or not
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

    public int length(){ // Returns length of the linked list
        return this.length;
    }

    public void clear(){ // Clears the linked list
        this.head = null;
        this.length = 0; 
    }

    public void append(T data){ // Appends item to linked list 
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

    public T getValueAt(int index){     // Returns value at specified index
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


    public int IndexOf(T data){ // Returns index of first occurence of an item
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

    public String IndexOfAll(T data){  // Returns index of all occurences of an item
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

    public String toString(){ // Returns a string representation of the linked list
        Node<T> current = this.head;
        StringBuilder list = new StringBuilder();

        while (current != null){
            list.append(String.valueOf(current.val()) + " -> ");
            current = current.next();
        }
        list.append("null");

        return list.toString();
    }


    public void remove(T val){   // Removes item
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

    public void pop(){

        if (this.head == null){
            return;
        }

        if (this.head.next() == null){

            this.head = null;
        }


        else{
            Node<T> current = this.head;
        
            while (current.next().next() != null){
                current = current.next();
            }
            current.setNext(null);
        }

        this.length--;
    }

    public void add(T data, int index){     // Adds item at specified index
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

    public void addFirst(T data){
        add(data, 0);
    }


    public boolean contains(T data){ // Returns wheter an item is in the linked list or not
        Node<T> current = head;

        while (current != null){
            if (current.val() == data){
                return true;
            }
            current = current.next();
        }
        return false;
    }

    public void reverse(){ // Reverses linked list
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


    public T getLast(){
        if (this.head == null){
            return null;
        }

        Node<T> current = this.head;

        while (current.next() != null){
            current = current.next();

        }
        return current.val();
    }

    public T getFirst(){
        if (this.head == null){
            return null;
        }

        return this.head.val();
    }


    public void merge(LinkedList<T> mergeList){
        if (this.head == null){
            this.head = mergeList.head;
            return;
        }

        if (mergeList.head == null){
            return;
        }

        Node<T> current = this.head;

        while (current.next() != null){
            current = current.next();
        }
        current.setNext(mergeList.head);
        this.length += mergeList.length;
    }

    public LinkedList<T>[] split(int index){
        if (index < 0 || index >= this.length ){
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }

        LinkedList<T>[] splittedLists =  new LinkedList[2];
        Node<T> current = this.head;
        int currIndex = 0;

        LinkedList<T> leftList = new LinkedList<T>();
        LinkedList<T> rightList = new LinkedList<T>();

        while (currIndex < index){
            leftList.append(current.val());
            current = current.next();
            currIndex++;
        }

        while (current != null){
            rightList.append(current.val());
            current = current.next();
        }


        splittedLists[0] = leftList;
        splittedLists[1] = rightList;

        return splittedLists;
    }

    public boolean isPalindrome(){
        if (head == null || head.next() == null){
            return true;
        }


        LinkedList<T> leftSide = new LinkedList<>();


        Node <T> current = this.head;

    }

    public static void main(String[] args){
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.append(15);
        list.append(34);
        list.append(2);


        LinkedList<Integer> list2 = new LinkedList<Integer>();

        list2.append(9);
        list2.append(2);
        list2.append(10);

        list.merge(list2);


        LinkedList<Integer>[] splitted = list.split(3);
        System.out.println(splitted[0].toString());
        System.out.println(splitted[1].toString());

        System.out.println(list.isPalindrome());

        
        
        
    }
}