// Based on https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/

package org.maze.solvers;

import lombok.RequiredArgsConstructor;
import org.maze.Cell;
import org.maze.Direction;

import java.util.Arrays;
import java.util.PriorityQueue;

/** Special class for solving given maze using Dijkstra's algorithm. */
@RequiredArgsConstructor
public class DijkstraMazeSolver implements MazeSolver {
    private final char[][] maze;

    /** Solves maze with Dijkstra's approach
     * by storing minimal distances between cells. */
    @Override
    public int solve() {
        // Consider the maze as a graph that we can traverse,
        // initialise distance matrix to keep the smallest costs
        // from G to any other vertice of the graph
        int mazeSize = maze.length;
        int[][] distances = new int[mazeSize][mazeSize];

        // fill distance matrix with +inf (big values)
        for (int[] row : distances)
            Arrays.fill(row, Integer.MAX_VALUE);

        // set first distance to 0, as minimal cost from G -> G is 0
        distances[0][0] = 0;
        // initialise priority queue (implemented as min-heap)
        // to keep the track of the lowest cost cells,
        // then add (0, 0) cell to the queue
        PriorityQueue<Cell> queue = new PriorityQueue<>();
        queue.add(new Cell(0, 0, 0));

        // keep extracting elements from the top of
        // the queue until there is anything in it
        int x, y, moveCost, currentCost;
        while (!queue.isEmpty()) {
            Cell current = queue.poll();

            // if S point is reached, immediately return accumulated minimal cost
            if (maze[current.getX()][current.getY()] == 'S') {
                return current.getCost();
            }

            // consider all eight directions to move to
            for (Direction direction : Direction.values()) {
                int[] steps = direction.getSteps();
                x = current.getX() + steps[0]; // add vertical shift to the current coordinate
                y = current.getY() + steps[1]; // add horizontal shift
                if (isAvailable(x, y)) { // continue if the move is allowed
                    // if S or G, set moveCost to 0, as they don't hold any value
                    // otherwise convert numeric char value to int
                    moveCost = Character.isDigit(maze[x][y]) ? (maze[x][y] - '0') : 0;
                    // update potential cost as a sum of
                    // accumulated cost until the current vertice + move cost
                    currentCost = current.getCost() + moveCost;
                    if (currentCost < distances[x][y]) { // if there is lower cost,
                        distances[x][y] = currentCost; // update distance matrix
                        queue.add(new Cell(x, y, currentCost)); // add the next possible cell to the queue
                    }
                }
            }
        }
        return 0; // return 0, if S is not reachable
    }

    /** Verifies that the coordinates of a new cell are within the maze
     * and the next cell is not a wall. */
    @Override
    public boolean isAvailable(int x, int y) {
        return (x >= 0 && x < maze.length &&
                y >= 0 && y < maze.length &&
                maze[x][y] != 'X');
    }
}
