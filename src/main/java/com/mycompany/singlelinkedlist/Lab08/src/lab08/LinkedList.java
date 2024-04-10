/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab08;

/**
 *
 * @author 13476
 */
//this Node class is based on Professor Alrajab's code 
class Node {
   public int data;
   public Node next;

   public Node(int data) {
      this.data = data;
      this.next = null;
   }
   //accessor for the node's data
   public int getData(){
       return data;
   }
   //accessor for the data of the nest node
   public int getNextData(){
       return next.getData();
   }
}

//this LinkedList class is based on Professor Alrajab's code 
public class LinkedList {
    
   private Node head;
   private Node tail;
   private int size;
    
   /*provided form the Professor's example
   I just intialized the size to 0*/
   public LinkedList() {
      head = null;
      tail = null;
      size = 0;
   }
   
   /*At first I was using for loops so I made this getSize
   but it wasn't going to work because I didn't have indexs to refer to
   so I use while loops instead*/
   public int getSize(){
       return size;
   }
   
   /*provided from the Professor's example
    I just added size increment to track the size*/
   public void append(Node newNode) {
      if (head == null) {
         head = newNode;
         tail = newNode;
      }
      else {
         tail.next = newNode;
         tail = newNode;
      }
      ++size;
   }
   
   /*provided from the Professor's example
    I just added size increment to track the size*/
   public void prepend(Node newNode) {
      if (head == null) {
         head = newNode;
         tail = newNode;
      }
      else {
         newNode.next = head;
         head = newNode;
      }
      ++size;
   }
   
   /*provided from the Professor's example
    I just added size increment to track the size*/
   public void insertAfter(Node currentNode, Node newNode) {
      if (head == null) {
         head = newNode;
         tail = newNode;
      }
      else if (currentNode == tail) {
         tail.next = newNode;
         tail = newNode;
      }
      else {
         newNode.next = currentNode.next;
         currentNode.next = newNode;
      }
      ++size;
   }
   
   /*provided from the Professor's example
    I just added size decrement to track the size*/
   public void removeAfter(Node currentNode) {
      if (currentNode == null && head != null) {
         // Special case: remove head
         Node succeedingNode = head.next;
         head = succeedingNode;
         if (succeedingNode == null) {
             // Last item was removed
             tail = null;
         }
      }
      else if (currentNode.next != null) {
         Node succeedingNode = currentNode.next.next;
         currentNode.next = succeedingNode;
         if (succeedingNode == null) {
            // Remove tail
            tail = currentNode;
         }
      }
      --size;
    }

    /*this prints out the list's content*/
    public void printList(){
        Node currentNode = head; 
        while(currentNode != null){
            System.out.print(currentNode.data + " " );
            currentNode = currentNode.next;
        }
        System.out.println();
    }
    
    /*This is my solution for creating new nodes to add because that 
      was getting very repeative
      the list that calls this method uses appends to add a new node
      Imporvements I would've like to make was assign each node an index
      so I can remove node at specdific positions directly 
    */
    public void addNode(int d){
        Node newNode = new Node(d);
        append(newNode);
    }
    
    /*this copy constuctor creates a new list with the same data as another list
      a new node copies the data of the other list's node
      and now the new list has it's own refernce varibale with the same data value*/
    public LinkedList(LinkedList list) {
       Node currentNode = list.head; 
       while(currentNode != null){
           Node newNode = new Node(currentNode.data);
           append(newNode);
           currentNode = currentNode.next;
       }
    }
    
    /*for the given number, makePrime creates a list of prime number
      it uses isPrime to validate if thennumber can be added to the list
      if the number is valid, a new node is created with that Prime int data
      and it's added to the list*/
    public void makePrime(int n){
        for (int i = 0; i < n; i++) {
            if(isPrime(i)){
                addNode(i);
            }
        }
    }
    
    //checks if a number is prime
    public boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
    
    /*This should check the data of the next node
    if it contains a three, the condition is true and the program may 
    proceed to the check the next node but if it's false it should go to the else
    and remove after should remove the next node that doesn't contain a three
    but it doesn't remove all the numbers that don't have a three digit*/
    public void keepThree(){
        Node checker = new Node(0);
        checker.next = head;
        while(checker.next != null ){
            if(isThree(checker.next.getData())){
                checker = checker.next;
            }
            else{
                removeAfter(checker);
                checker = checker.next;
            }
        }
    }

    
    /*checks the data of the next node, if the data contains the digit three
      remove after removes that next node
      if not, it continues through the list and checks the next node
      when I run this it works, I can't figure out what's wrong with keepThree*/
    public void removeThree(){
        Node checker = new Node(0);
        checker.next = head;
        while(checker.next != null ){
            if(isThree(checker.next.getData())){
                removeAfter(checker);                
            }
            else{
                checker = checker.next;                
            }
        }
    }
    
    //Converts the int data to a string and compare each char to check for the digit 3
    public boolean isThree(int n){
         String nStr = Integer.toString(n);
         for (int i = 0; i < nStr.length(); i++) {
            if(nStr.charAt(i)=='3'){
                return true;
            }
        }
        return false;
    }
    
    //This adds up the data values to sum variable and returns the sum
    public int sum(){
        int sum = 0;
        Node currentNode = head;
        while(currentNode != null){
           sum += currentNode.data;
           currentNode = currentNode.next;
       }
        return sum;
    }
}
