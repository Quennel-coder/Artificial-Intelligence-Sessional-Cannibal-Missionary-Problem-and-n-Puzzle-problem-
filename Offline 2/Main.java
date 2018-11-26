/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package n.puzzle.solver.using.a.star.search.algorithm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
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
            System.out.println("Case No: " + t + "\n");

            int N;
            N = in.nextInt();
            Constants.N = N; // numbers in the puzzle
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

            System.out.println("The given board is: ");
            initialNode.printBoard();

            if (initialNode.isSolvable()) {
                System.out.println("This board is SOLVABLE. ");
                System.out.println("");

                Node tem;

                System.out.println("############################");
                System.out.println("Using Hamming Heuristic: ");
                Constants.HeuristicType = heuristicName.Ham;

                tem = initialNode;

                aStarSearch search = new aStarSearch(tem);
                search.printAllMoves();

                System.out.println("############################");

                System.out.println("Using Manhattan Heuristic: ");
                Constants.HeuristicType = heuristicName.Man;

                tem = initialNode;
                search = new aStarSearch(tem);
                search.printAllMoves();

                System.out.println("############################");

                System.out.println("Using Linear Conflict Heuristic: ");
                Constants.HeuristicType = heuristicName.Conf;

                tem = initialNode;
                search = new aStarSearch(tem);
                search.printAllMoves();

            } else {
                System.out.println("This board is NOT Solvable! Try again. ");
            }

        }
    }
}
