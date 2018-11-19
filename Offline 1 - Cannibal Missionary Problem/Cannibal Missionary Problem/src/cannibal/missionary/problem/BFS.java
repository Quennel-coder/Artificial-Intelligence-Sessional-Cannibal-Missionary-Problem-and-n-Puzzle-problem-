/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cannibal.missionary.problem;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author Heisenberg
 */
public class BFS {

    int nodeNo;
    State[] stateArray;
    State initialState;

    public BFS(State initialState) {
        this.initialState = initialState;
        stateArray = new State[1000005];
        nodeNo = 0;
    }

    public State getFinalState() {

        Instant start = Instant.now();

        if (initialState.isItTheGoalState()) {
            return initialState;
        }

        nodeNo = 0;

        Queue<State> q = new LinkedList<>();

        HashMap<State, Integer> map = new HashMap<>();

        map.put(initialState, nodeNo);

        initialState.setParentState(-1);

        stateArray[nodeNo] = initialState;

        q.add(initialState);

        while (!q.isEmpty()) {

            State u = q.poll();
            int indexU = map.get(u);

            List<State> successors = u.getSuccessors();

            for (State v : successors) {

                Instant t = Instant.now();
                Duration dur = Duration.between(start, t);
                double till = dur.toMillis();
                if (till >= 10000) {
                    System.out.println("Time limit 10 s exceeded.");
                    return null;
                }

                if (!map.containsKey(v)) {
                    nodeNo++;
                    v.setParentState(indexU);
                    stateArray[nodeNo] = v;

                    if (v.isItTheGoalState()) {
                        Instant end = Instant.now();
                        Duration timeElapsed = Duration.between(start, end);
                        System.out.println("Time taken: " + timeElapsed.toMillis() + " milliseconds");

                        return v;
                    }

                    map.put(v, nodeNo);
                    q.add(v);
                }
            }
        }

        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Time taken: " + timeElapsed.toMillis() + " milliseconds");

        return null;
    }

    public void printPath() {
        int t = 0;
        State s = getFinalState();
        if (s == null) {
            System.out.println("No solution found.");
            return;
        }

        String[] str = new String[100005];

        while (!s.equals(initialState)) {
            str[t] = s.toString();
            t++;
            s = stateArray[s.getParentState()];
//            System.out.println(s);
        }
        str[t] = s.toString();

        System.out.println("BFS takes " + t + " steps.\n");

        for (int i = t; i >= 0; i--) {
            System.out.print(str[i]);
            if (i != 0) {
                System.out.print(" --> ");
            }
        }
        System.out.println("");
    }
}
