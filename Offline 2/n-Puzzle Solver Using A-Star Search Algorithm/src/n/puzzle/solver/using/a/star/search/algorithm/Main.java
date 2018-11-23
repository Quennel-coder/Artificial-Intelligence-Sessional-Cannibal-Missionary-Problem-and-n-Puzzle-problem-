/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package n.puzzle.solver.using.a.star.search.algorithm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Heisenberg
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input.txt"));
        int T, t = 0;
        T = in.nextInt();

        while (t < T) {
            t++;
            System.out.println("Input case " + t + ": ");

            int N;
            N = in.nextInt();
            Constants.N = N;
            N++;
            N = (int) Math.sqrt(N);
            Constants.rowNum = Constants.colmNumber = N;

            int[][] initialBoard = new int[N][N];

            for (int i = 0; i < Constants.rowNum; i++) {
                for (int j = 0; j < Constants.colmNumber; j++) {
                    initialBoard[i][j] = in.nextInt();
                }
            }

            Node initialNode = new Node(initialBoard, 0, null);
            System.out.println(initialNode.isThisTheGoalBoard());
//            aStarSearch search = new aStarSearch(); 
//            search.execute(initialNode);
        }
    }
}
