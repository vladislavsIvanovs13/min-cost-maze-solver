// Vladislavs Ivanovs

package org.maze;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        MazeReader reader = new MazeReader(FileName.HUNDRED_AND_ONE.getPath());
        MinCostMazeSolver solver = new MinCostMazeSolver(reader.getMaze());

        int sum = solver.solve();
        System.out.println(sum);
    }
}
