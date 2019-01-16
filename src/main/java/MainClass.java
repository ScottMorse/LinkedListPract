import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainClass {
    public static void main(String[] args){
        DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
        list.push(0);
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
        list.push(5);
        list.push(6);
        list.removeAt(6);
        System.out.println(list.get(0));
    }
}

class SinglyNode<AnyType>{

    private AnyType data;
    private SinglyNode<AnyType> next;

    SinglyNode(AnyType data, SinglyNode<AnyType> next){
        this.data = data;
        this.next = next;
    }

    public AnyType getData(){
        return this.data;
    }

    public SinglyNode<AnyType> getNext(){
        return this.next;
    }

    public void setNext(SinglyNode<AnyType> node){
        this.next = node;
    }
}

class DoublyNode<AnyType> extends SinglyNode<AnyType>{
    private DoublyNode<AnyType> next;
    private DoublyNode<AnyType> prev;

    DoublyNode(AnyType data, DoublyNode<AnyType> next ,DoublyNode<AnyType> prev){
        super(data,next);
        this.next = next;
        this.prev = prev;
    }

    public DoublyNode<AnyType> getNext() { return this.next; }

    public void setNext(DoublyNode<AnyType> node) { this.next = node; }

    public DoublyNode<AnyType> getPrev(){
        return this.prev;
    }

    public void setPrev(DoublyNode<AnyType> node){
        this.prev = node;
    }

}

class SinglyLinkedList<AnyType>{

    private SinglyNode<AnyType> head;
    private int size = 0;

    SinglyLinkedList(){
        this.head = null;
    }

    public void push(AnyType data){

        this.head = new SinglyNode<AnyType>(data,this.head);
        this.size++;
    }

    public AnyType pop(){
        AnyType data = this.head.getData();
        this.removeAt(0);
        return data;
    }

    public void removeAt(int index) {
        if(index < 0){
            throw new NullPointerException("Index outside list bounds.");
        }
        else if(index >= this.size){
            throw new NullPointerException("Index outside list bounds.");
        }
        SinglyNode<AnyType> currentNode = this.head;
        if (index == 0) {
            this.head = this.head.getNext();
            return;
        }
        int i = 0;
        while (i < index - 1) {
            currentNode = currentNode.getNext();
            i++;
        }
        currentNode.setNext(currentNode.getNext().getNext());
        this.size--;
    }

    public AnyType get(int index){
        if(index < 0){
            throw new NullPointerException("Index outside list bounds.");
        }
        else if(index >= this.size){
            throw new NullPointerException("Index outside list bounds.");
        }
        SinglyNode<AnyType> currentNode = this.head;
        int i = 0;
        while(i < index){
            currentNode = currentNode.getNext();
            i++;
        }
        return currentNode.getData();
    }

}

class DoublyLinkedList<AnyType> extends SinglyLinkedList<AnyType>{
    private DoublyNode<AnyType> tail;
    private DoublyNode<AnyType> head;
    private int size = 0;

    DoublyLinkedList(){
        super();
        this.tail = null;
    }

    public void push(AnyType data){
        DoublyNode<AnyType> oldHead = this.head;
        this.head = new DoublyNode<AnyType>(data,oldHead,null);
        if(oldHead == null){
            this.tail = this.head;
        }
        else{
            oldHead.setPrev(this.head);
        }
        this.size++;
    }

    public void enqueue(AnyType data){
        this.tail = new DoublyNode<AnyType>(data,null,this.tail);
        this.tail.getPrev().setPrev(this.tail);
        this.size++;
    }

    public void removeAt(int index){
        if(index < 0){
            throw new NullPointerException("Index outside list bounds.");
        }
        else if(index >= this.size){
            throw new NullPointerException("Index outside list bounds.");
        }
        if(index == 0){
            if(this.tail == this.head){
                this.tail = null;
                this.head = null;
            }
            else{
                this.head = this.head.getNext();
            }
        }
        else if(index == this.size - 1){
            this.tail.getPrev().setNext(null);
            this.tail = this.tail.getPrev();
//            this.tail.setNext(null);
        }
        else if(index > this.size / 2){
            DoublyNode<AnyType> currentNode = this.tail;
            int i = 0;
            while(i < this.size - index - 2){
                currentNode = currentNode.getPrev();
                i++;
            }
            currentNode.setPrev(currentNode.getPrev().getPrev());
            currentNode.getPrev().getPrev().setNext(currentNode);
        }
        else{
            DoublyNode<AnyType> currentNode = this.head;
            int i = 0;
            while (i < index - 1) {
                currentNode = currentNode.getNext();
                i++;
            }
            currentNode.setNext(currentNode.getNext().getNext());
//            System.out.println(currentNode.getNext().getData());
            currentNode.getNext().setPrev(currentNode);
        }
        this.size--;
    }

    public AnyType get(int index){
        if(index < 0){
            throw new NullPointerException("Index outside list bounds.");
        }
        else if(index >= this.size){
            throw new NullPointerException("Index outside list bounds.");
        }
        DoublyNode<AnyType> currentNode = null;
        if(index > this.size / 2){
            int i = 0;
            currentNode = this.tail;
            while(i < this.size - index - 1){
                currentNode = currentNode.getPrev();
                i++;
            }
        }
        else{
            currentNode = this.head;
            int i = 0;
            while(i < index){
                currentNode = currentNode.getNext();
                i++;
            }
        }
        return currentNode.getData();
    }

    public DoublyNode<AnyType> getHead(){
        return this.head;
    }
}