/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package n.puzzle.solver.using.a.star.search.algorithm;

import java.util.Comparator;

/**
 *
 * @author Heisenberg
 */
public class NodeComparator implements Comparator<Node> {

    @Override
    public int compare(Node node1, Node node2) {
        if (node1.getPriorityFunction() < node2.getPriorityFunction()) {
            return -1;
        } else if (node1.getPriorityFunction() > node2.getPriorityFunction()) {
            return 1;
        } else {
            return 0;
        }
    }
}
