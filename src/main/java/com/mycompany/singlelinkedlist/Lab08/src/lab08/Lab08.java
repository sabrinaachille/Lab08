/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab08;
import java.util.Scanner;

/**
 *
 * @author 13476
 */
public class Lab08 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*prompting the usign to input a value for n
        to prove that code will run for any value of n
        */
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter a value for n: ");
        int n = sc.nextInt();
        System.out.println("Range: 0 to " + n);
        
        //list populated by prime numbers from 0 to n
        LinkedList pList = new LinkedList();
        pList.makePrime(n);
        
        System.out.print("List of prime numbers: ");
        pList.printList();
        
        //list populated by prime numbers with digit three
        LinkedList tList = new LinkedList(pList);
        tList.keepThree(); //Error with this method, lines 181-193 of LinkedList
        //tList.removeThree(); //But this function works
        
        System.out.print("List of prime numbers without the digit three: ");
        tList.printList();
        
        //sum of the list content
        System.out.println("Sum of list: " + tList.sum());
    }
}
