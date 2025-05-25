// Vladislavs Ivanovs

package org.maze;

import org.maze.solvers.BfsMazeSolver;
import org.maze.solvers.DijkstraMazeSolver;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        MazeReader reader = new MazeReader(FileName.HUNDRED_AND_ONE.getPath());
//        BfsMazeSolver solver = new BfsMazeSolver(reader.getMaze());
        DijkstraMazeSolver solver = new DijkstraMazeSolver(reader.getCharMaze());

        int sum = solver.solve();
        System.out.println(sum);
    }
}
