/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package n.puzzle.solver.using.a.star.search.algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author Heisenberg
 */
public class test {
    
    public static void swap(int a , int b)
    {
        int tem = a; 
        a = b; 
        b = tem; 
    }


    public static void main(String[] args) {
//        PriorityQueue<a> pq = new PriorityQueue<>(new acomp());
//
//        pq.add(new a(2, 3));
//        pq.add(new a(3, 4));
//        pq.add(new a(6, 5));
//
//        while (!pq.isEmpty()) {
//            a t;
//            t = pq.poll();
//            System.out.println(t.a + " , " + t.b);
//        }

        int a = 3 , b = 4 ; 
        
        swap(a,b); 
        System.out.println(a + " " + b);
        
    }
}

class acomp implements Comparator<a> {

    public int compare(a a1, a a2) {
        if (a1.a < a2.a) {
            System.out.println("in a1.a < a2.a");
            System.out.println(a1);
            System.out.println(a2);
            System.out.println("---");
            return -1;
        } else if (a1.a > a2.a) {
            System.out.println("in a1.a > a2.a");
            System.out.println(a1);
            System.out.println(a2);
            System.out.println("---");
            return 1;
        }
        System.out.println("in a1.a == a2.a");
        System.out.println(a1);
        System.out.println(a2);
        System.out.println("---");
        return 0;
    }
}

class a {

    int a, b;

    public a(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return a + " , " + b;
    }

}
