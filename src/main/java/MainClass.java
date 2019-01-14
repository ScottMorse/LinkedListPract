import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainClass {
    public static void main(String[] args){
        IntegerLinkedList list = new IntegerLinkedList(1,10);
        int result = list.get(9);
        System.out.println(result);
    }
}

class Node<AnyType>{

    private AnyType data;
    private Node<AnyType> next;

    public Node(AnyType data, Node<AnyType> next){
        this.data = data;
        this.next = next;
    }

    public AnyType getData(){
        return this.data;
    }

    public Node<AnyType> getNext(){
        return this.next;
    }
}

class IntegerLinkedList{

    private Node<Integer> head;

    IntegerLinkedList(int start,int size){
        for(int x = 0;x < size;x++){
            if(x == 0){
                this.head = new Node<Integer>(start + size - x - 1, null);
            }
            else{
                this.head = new Node<Integer>( start + size - x - 1,this.head);
            }
        }
    }

    public int get(int index){
        Node<Integer> currentNode = this.head;
        int i = 0;
        while(i < index){
            currentNode = currentNode.getNext();
            i++;
        }
        return currentNode.getData();
    }

}