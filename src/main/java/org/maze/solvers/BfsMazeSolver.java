// Based on https://www.baeldung.com/java-solve-maze

package org.maze.solvers;

import lombok.RequiredArgsConstructor;
import org.maze.Cell;
import org.maze.Direction;

import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Math.min;

/** Special class for solving given maze using BFS. */
@RequiredArgsConstructor
public class BfsMazeSolver implements MazeSolver {
    private final Cell[][] maze;

    /** Solves maze with BFS (Breadth First Search) approach
     * by sequentially exploring levels of a tree which represents the maze. */
    @Override
    public int solve() {
        // Since the paths from S to G and from G to S are equivalent,
        // we will use the easiest approach and move from G,
        // which is always at (0, 0). Let's find S with minimal cost.

        // introduce a queue to store possible cells to visit,
        // add the top-left cell there and mark it as visited
        Queue<Cell> queue = new LinkedList<>();
        maze[0][0].setVisited(true);
        queue.add(maze[0][0]);

        // define variables to keep track of the current cell
        // and the next cell coordinates, as well as the local sum
        // and minimal cost sum (global), initially set it to some big value
        int x, y, newX, newY, sum = 0;
        int minSum = Integer.MAX_VALUE;

        // keep extracting elements from the front of the queue
        // until there is anything in it
        while (!queue.isEmpty()) {
            Cell cell = queue.poll();
            x = cell.getX();
            y = cell.getY();

            // if starting point S is reached (we move in opposite direction),
            // use references to parent nodes to return to (0, 0) cell (G)
            // and calculate values on the go
            if (cell.getValue() == 'S') {
                cell = cell.getParent();
                while (cell.getValue() != 'G') {
                    sum += (cell.getValue() - '0'); // converts char to int
                    cell = cell.getParent();
                }
                minSum = min(minSum, sum); // choose globally minimal cost sum
                sum = 0; // set to 0 for the next possible cost calculations
            }

            // consider all eight directions to move to
            for (Direction direction : Direction.values()) {
                int[] steps = direction.getSteps();
                newX = x + steps[0]; // add vertical shift to the current coordinate
                newY = y + steps[1]; // add horizontal shift
                if (isAvailable(newX, newY)) { // if the move is allowed,
                    maze[newX][newY].setParent(cell); // connect current cell to the next cell in the path
                    maze[newX][newY].setVisited(true); // mark the next cell as visited
                    queue.add(maze[newX][newY]); // add the next possible cell to the queue
                }
            }
        }
        return minSum;
    }

    /** Verifies that the coordinates of a new cell are within the maze,
     * next cell is not a wall and hasn't been visited. */
    @Override
    public boolean isAvailable(int x, int y) {
        return (x >= 0 && x < maze.length &&
                y >= 0 && y < maze.length &&
                maze[x][y].getValue() != 'X' &&
                !maze[x][y].isVisited());
    }
}
