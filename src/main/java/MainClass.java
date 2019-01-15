import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainClass {
    public static void main(String[] args){
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();
        list.add("Hello");
        list.add("Goodbye");
        list.removeAt(0);
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

class SinglyLinkedList<AnyType>{

    private SinglyNode<AnyType> head;

    SinglyLinkedList(){
        this.head = null;
    }

    public void add(AnyType data){
        this.head = new SinglyNode<AnyType>(data,this.head);
    }

    public void removeAt(int index){
        SinglyNode<AnyType> currentNode = this.head;
        if(index == 0){
            this.head = this.head.getNext();
            return;
        }
        int i = 0;
        while(i < index - 1){
            currentNode = currentNode.getNext();
            i++;
        }
        currentNode.setNext(currentNode.getNext());
    }

    public AnyType get(int index){
        SinglyNode<AnyType> currentNode = this.head;
        int i = 0;
        while(i < index){
            currentNode = currentNode.getNext();
            i++;
        }
        return currentNode.getData();
    }

}