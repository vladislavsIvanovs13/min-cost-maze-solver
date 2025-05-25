package org.maze;

import lombok.Getter;
import lombok.Setter;

// Lombok library reduces boilerplate code, therefore
// getters and setters can be generated using annotations

/** Each cell contains information about its x and y coordinates (indexes)
 * in matrix, value (number, S, G or X), cost (only numeric value),
 * parent cell to keep track of path or visited cell flag
 * to identify if current cell has already been visited. */
@Getter
@Setter
public class Cell implements Comparable<Cell> {
    private int x;
    private int y;
    private int cost;
    private char value;
    private Cell parent;
    private boolean visited;

    public Cell(int x, int y, char value, Cell parent, boolean visited) {
        this.x = x;
        this.y = y;
        this.value = value;
        this.parent = parent;
        this.visited = visited;
    }

    public Cell(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    @Override
    public int compareTo(Cell o) {
        return this.cost - o.cost;
    }
}