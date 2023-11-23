import java.util.ArrayList;
import java.util.Arrays;

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
        if (index >= this.length || index < 0){
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }

        Node<T> current = this.head;

        int currIndex = 0;

        while (currIndex < index){
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
        return -1; // Incase item doesn't exist
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
        Node<T> prev = new Node<T>(null, null);
        while (current != null){
            if (current.val() == val){
                current = current.next();
                prev.setNext(current);
                this.length--;
                return;
            }
            else{
                prev = current;
                current = current.next();
            }
        }
    }

    public void removeLast(){
        if (this.head.next() == null){
            this.head = null;
            this.length = 0;
            return;
        }
        int index = 0;

        Node<T> current = this.head;
        Node<T> newLast = null;

        while (index < this.length-2){
            current = current.next();
            index++;
        }
        current.setNext(newLast);
        this.length--;
    }

    public void removeFirst(){
        if (this.head == null){
            return;
        }
        this.head = this.head.next();
        this.length--;
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

    public void add(int index, T data){     // Adds item at specified index
        if (index > this.length || index < 0){
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
        this.length++;
    }

    public void addFirst(T data){
        add(0, data);
    }
    public void addLast(T data){
        add(this.length, data);
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
        if (this.length <= 1){
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


    public T getLast(){ // Returns the last element of linked list 
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


    public void merge(LinkedList<T> mergeList){ // Merges a linked list with another linked list
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

    public LinkedList<T>[] split(int index){  // Splits a linked list at a given index into two seperate linked lists and returns a list of the splitted linked lists
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

        leftList.length = index;
        rightList.length = this.length - index;

        splittedLists[0] = leftList;
        splittedLists[1] = rightList;

        return splittedLists;
    }

    public boolean isPalindrome(){ // Returns wheter a linked list is a paildrome or not
        if (head == null || head.next() == null){
            return true;
        }

        boolean oddLength = this.length % 2 != 0;

        int middle = this.length / 2;


        LinkedList<T> leftSide = new LinkedList<>();
        Node<T> fast = this.head;
        int currIndex = 0;

        while (currIndex < middle){
            leftSide.add(0, fast.val());
            fast = fast.next();
            currIndex++;
        }


        if (oddLength){
            fast = fast.next();
        }


        Node<T> current = leftSide.head;
        while (fast != null){
            if (!fast.val().equals(current.val())){
                return false;
            }
            current = current.next();
            fast = fast.next();
        }

        return true;
    }

    public LinkedList<T> subList(int startIndex, int endIndex){
        if (startIndex < 0 || endIndex >= this.length){
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }

        if (startIndex > endIndex){
            throw new IndexOutOfBoundsException("The Start index cant be greater than the End index");
        }

        if (startIndex == endIndex){
            return new LinkedList<>();
        }

        int index = 0;


        LinkedList<T> newLinkedList = new LinkedList<T>(); 

        Node<T> current = this.head;

        while (index < startIndex){
            current = current.next();
            index++;
        }

        while (index < endIndex){
            newLinkedList.append(current.val());
            current = current.next();
            index++;
        }

        return newLinkedList;
    }

    public double sum(){
        Node<T> current = this.head;

        if (!(current.val() instanceof Number)){
            throw new UnsupportedOperationException("The sum() method is only compatible with linked lists with numeric values!");
        }

        double sum = 0;

        while (current != null){
            sum += ((Number) current.val()).doubleValue();
            current = current.next();
        }

        return sum;
    }

    public void removeDuplicates(){
        if (this.head == null){
            return;
        }

        ArrayList<Object> elements = new ArrayList<Object>();

        Node<T> current = this.head;
        Node<T> prev = null;


        while (current != null){
            if (elements.contains(current.val())){
                current = current.next();
                prev.setNext(current);
                this.length--;
            }
            
            else{
                elements.add(current.val());
                prev = current;
                current = current.next();
            }
           
        }
    }

    public LinkedList<T> clone(){
        LinkedList<T> new_LinkedList = new LinkedList<>();
        if (this.head == null){
            return new_LinkedList;
        }

        Node<T> current = this.head;
        new_LinkedList.head = current;
        Node<T> newCurrent = new_LinkedList.head;



        while (current != null){
            current = current.next();
            newCurrent.setNext(current);
            newCurrent = newCurrent.next();
        }

        return new_LinkedList;
    }


    public Object[] toArray(){
        Object[] array = new Object[this.length];

        Node<T> current = this.head;
        int index = 0; 

        while (current != null){
            array[index] = current.val();
            current = current.next();
            index++;
        }
        return array;
    }

    public void set(int index, T element){
        if (index < 0 || index >= this.length){
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }

        Node<T> current = this.head;
        int currIndex = 0;


        while (currIndex < index){
            current = current.next();
            currIndex++;
        }
        current.setVal(element);
    }

    public void remove(int index){
        if (index < 0 || index >= this.length){
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }

        Node<T> current = this.head;
        int currIndex = 0;

        while (currIndex < index - 1){
            current = current.next();
            currIndex++;
        }
        current.setNext(current.next().next());


    }


    public static void main(String[] args){
        LinkedList<Integer> list = new LinkedList<>();
        list.append(5);
        list.append(5);
        list.append(5);
        System.out.println(list.toString());

        list.set(2, 8);
        System.out.println(list.toString());
        list.remove(1);
        System.out.println(list.toString());

    }
}