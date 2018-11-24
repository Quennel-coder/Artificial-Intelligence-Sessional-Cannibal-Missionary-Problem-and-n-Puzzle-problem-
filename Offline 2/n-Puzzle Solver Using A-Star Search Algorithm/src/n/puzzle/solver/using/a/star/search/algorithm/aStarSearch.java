/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package n.puzzle.solver.using.a.star.search.algorithm;

import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author Heisenberg
 */
public class aStarSearch {

    Node[] NodeArray;
    Node initialNode;
    int nodeNo;

    public aStarSearch(Node init) {
        initialNode = init;
        NodeArray = new Node[1000000];
        nodeNo = 0;
    }

    public Node execute() {

        if (initialNode.isThisTheGoalBoard()) {
            return initialNode;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(new NodeComparator());
        HashMap<Node, Integer> map = new HashMap<>();

        pq.add(initialNode);

        while (!pq.isEmpty()) {
//            System.out.println("hi");
            Node u = pq.poll();
//            System.out.println(u);

            List<Node> successors = u.getSuccessors();

            for (Node v : successors) {
                if (!map.containsKey(v)) {
                    System.out.println(v);
                    nodeNo++;
                    if (v.isThisTheGoalBoard()) {
//                        System.out.println("GOAL!!");
                        return v;
                    }
                }
                map.put(v, nodeNo);
                pq.add(v);
            }
        }

        return null;
    }

    public void printAllMoves() {
        Node s = execute();
        System.out.println(s);
        System.out.println("Nodes generated: " + nodeNo);
        
        if(s == null)
        {
            System.out.println("No solution found!");
            return; 
        }
        
        Node[] arr = new Node[1000000]; 
        int t = 0 ; 
//        System.out.println("parent:"+  s.getPreviousNode().getPreviousNode());
        while(!s.equals(null))
        {
            arr[t] = s; 
            t++; 
            s = s.getPreviousNode(); 
        }
        
        System.out.println("It took " + t + " moves.");
        
        t--; 
        
        for(int i = t ; i >= 0 ; i--)
        {
            arr[i].printBoard();
        }
    }
}
