package org.maze.solvers;

public interface MazeSolver {
    int solve();
    boolean isAvailable(int x, int y);
}
