package com.example.ajit.myapplication;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by ajit on 11/10/16.
 */

public class PatriciaTrieTest {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        Random r=new Random();
        /* Creating object of PatriciaTrie */
        PatriciaTrie pt = new PatriciaTrie();
        System.out.println("Patricia Trie Test\n");

        char ch;
        String Square="YES";
      //  String Qube="YES";
        //String Qurter="YES";
        int digit3=3,digit4=4,digit5=5;

        /*  Perform trie operations  */
        if(Square=="YES"){
            for(int i=1; i<100; i++){
                pt.insert(i*i);
            }
            ArrayList<Integer> show =new ArrayList<Integer>();
            if(digit3==3){
               show=square(5,100);
            }
            int size=show.size();
            int x=r.nextInt(size);
            int y=show.get(x);
            show.remove(x);
            size=size-1;
            System.out.println("Hello ="+y);
            int A=y/10;
            System.out.println("H "+A);


        }
       /* if(Qube=="YES"){
            for(int i=1; i<100; i++){
                pt.insert(i*i*i);
            }}
        if(Qurter=="YES"){
            for(int i=1; i<50; i++){
                pt.insert(i*i*i*i);
            }}
       */



        do
        {
            System.out.println("\nPatricia Trie Operations\n");
            System.out.println("1. insert ");
            System.out.println("2. search");
            System.out.println("3. check emepty");
            System.out.println("4. make emepty");

            int choice = scan.nextInt();
            switch (choice)
            {
                case 1 :
                    System.out.println("Enter key element to insert");
                    pt.insert( scan.nextInt() );
                    break;
                case 2 :
                    System.out.println("Enter key element to search");
                    System.out.println("Search result : "+ pt.search( scan.nextInt() ));
                    break;
                case 3 :
                    System.out.println("Empty Status : "+ pt.isEmpty() );
                    break;
                case 4 :
                    System.out.println("Patricia Trie cleared");
                    pt.makeEmpty();
                    break;
                default :
                    System.out.println("Wrong Entry \n ");
                    break;
            }

            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);
        } while (ch == 'Y'|| ch == 'y');
    }
    public  static ArrayList<Integer> square(int X,int Z){
        ArrayList<Integer> squar = new ArrayList<Integer>();
        int x=5,y=10;
        for(int i=x; i<y; i++){
            squar.add(i*i);
        }
        return squar;
    }
   /* public  static ArrayList<Integer> qube(int X,int Z){
        ArrayList<Integer> qub = new ArrayList<Integer>();
        int x=5,y=10;
        for(int i=x; i<y; i++){
            qub.add(i*i*i);
        }
        return qub;
    }
    public  static  ArrayList<Integer> Quater(int X,int Z){
        ArrayList<Integer> Quat = new ArrayList<Integer>();
        int x=5,y=10;
        for(int i=x; i<y; i++){
            Quat.add(i*i*i*i);
        }
        return Quat;
    }*/
}
