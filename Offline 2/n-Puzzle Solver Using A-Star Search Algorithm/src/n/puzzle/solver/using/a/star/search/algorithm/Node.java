/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package n.puzzle.solver.using.a.star.search.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Heisenberg
 */
public class Node {

    private int[][] Board;
    private int movesTillNow, N, rowNum, colmNum, F, G, H;
    private Node previousNode;

    private int[][] goalBoard;
    private positionPair[] goalPositionOfEachNumber;

    public Node(int[][] board, int movesTillNow, Node previousNode) {
        this.N = Constants.N;
        this.rowNum = Constants.rowNum;
        this.colmNum = Constants.colmNumber;

        this.Board = board;
        this.movesTillNow = movesTillNow;
        this.previousNode = previousNode;

        int t = 1;
        goalBoard = new int[N][N];
        goalPositionOfEachNumber = new positionPair[N];

        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colmNum; j++) {
                goalBoard[i][j] = t % (N * N);
                goalPositionOfEachNumber[t % (N * N)] = new positionPair(i, j);
            }
        }

    }

    public boolean isThisTheGoalBoard() {
        int t = 1;

        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colmNum; j++) {
                if (Board[i][j] != goalBoard[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public positionPair getblankPosition() {
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colmNum; j++) {
                if (Board[i][j] == 0) {
                    return new positionPair(i, j);
                }
            }
        }

        return null;
    }

    public int HammingDistance() {
        int wrongPlace = 0;
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colmNum; j++) {
                if (Board[i][j] != goalBoard[i][j]) {
                    wrongPlace++;
                }
            }
        }
        return wrongPlace;
    }

    public int ManhattanDistance() {
        int distance = 0;

        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colmNum; j++) {
                distance += (Math.abs(i - goalPositionOfEachNumber[Board[i][j]].row)
                        + Math.abs(j - goalPositionOfEachNumber[Board[i][j]].colm));
            }
        }

        return distance;
    }

    public int linearConflict() {
        return 0;
    }

    public List<Node> getSuccessors() {
        List<Node> successors = new ArrayList<>();

        positionPair blankPosition = getblankPosition();
        if (blankPosition != null) {
            int blankRow, blankColm, tem;
            blankRow = blankPosition.row;
            blankColm = blankPosition.colm;

            if (blankRow - 1 >= 0) {
                int[][] temBoard = Board;

                tem = temBoard[blankRow - 1][blankColm];
                temBoard[blankRow - 1][blankColm] = temBoard[blankRow][blankColm];
                temBoard[blankRow][blankColm] = tem;

                successors.add(new Node(temBoard, movesTillNow + 1, this));
            }
            if (blankRow + 1 < rowNum) {
                int[][] temBoard = Board;

                tem = temBoard[blankRow + 1][blankColm];
                temBoard[blankRow + 1][blankColm] = temBoard[blankRow][blankColm];
                temBoard[blankRow][blankColm] = tem;

                successors.add(new Node(temBoard, movesTillNow + 1, this));
            }
            if (blankColm - 1 >= 0) {
                int[][] temBoard = Board;

                tem = temBoard[blankRow][blankColm - 1];
                temBoard[blankRow][blankColm - 1] = temBoard[blankRow][blankColm];
                temBoard[blankRow][blankColm] = tem;

                successors.add(new Node(temBoard, movesTillNow + 1, this));
            }
            if (blankColm + 1 < colmNum) {
                int[][] temBoard = Board;

                tem = temBoard[blankRow][blankColm + 1];
                temBoard[blankRow][blankColm + 1] = temBoard[blankRow][blankColm];
                temBoard[blankRow][blankColm] = tem;

                successors.add(new Node(temBoard, movesTillNow + 1, this));
            }
        }
        return successors;
    }

    public void printBoard() {
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colmNum; j++) {
                System.out.print(Board[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("-------------------");
    }

    public int[][] getBoard() {
        return Board;
    }

    public void setBoard(int[][] Board) {
        this.Board = Board;
    }

    public int getMovesTillNow() {
        return movesTillNow;
    }

    public void setMovesTillNow(int movesTillNow) {
        this.movesTillNow = movesTillNow;
    }

    public int getN() {
        return N;
    }

    public void setN(int N) {
        this.N = N;
    }

    public int getRowNum() {
        return rowNum;
    }

    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }

    public int getColmNum() {
        return colmNum;
    }

    public void setColmNum(int colmNum) {
        this.colmNum = colmNum;
    }

    public Node getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(Node previousNode) {
        this.previousNode = previousNode;
    }

    public int getF() {
        return F;
    }

    public void setF(int F) {
        this.F = F;
    }

    public int getG() {
        return G;
    }

    public void setG(int G) {
        this.G = G;
    }

    public int getH() {
        return H;
    }

    public void setH(int H) {
        this.H = H;
    }

}

class positionPair {

    int row, colm;

    public positionPair(int row, int colm) {
        this.row = row;
        this.colm = colm;
    }
}
