package org.maze;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// Lombok library reduces boilerplate code, therefore
// getters, setters and constructors can be generated using annotations

/** Each cell contains information about its x and y coordinates (indexes)
 * in matrix, value (number, S, G or X), parent cell to keep track of path
 * and visited cell flag to identify if current cell has already been visited. */
@Getter
@Setter
@AllArgsConstructor
public class Cell {
    private int x;
    private int y;
    private char value;
    private Cell parent;
    private boolean visited;
}
