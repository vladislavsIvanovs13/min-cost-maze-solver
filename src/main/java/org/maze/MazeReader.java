package org.maze;

import java.io.*;
import java.util.Scanner;

/** Special class for reading maze from txt file. */
public class MazeReader {
    private final String fileName;

    public MazeReader(String fileName) {
        this.fileName = "src/main/resources/" + fileName;
    }

    /** Extracts matrix with cells from given txt file. */
    public Cell[][] getMaze() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        char[] firstLine = scanner.nextLine().toCharArray();
        int mazeSize = firstLine.length;
        char[][] values = new char[mazeSize][mazeSize];
        Cell[][] maze = new Cell[mazeSize][mazeSize];

        // fills char matrix with values from txt file
        int i = 0;
        values[i++] = firstLine;
        while (scanner.hasNextLine()) {
            char[] line = scanner.nextLine().toCharArray();
            values[i++] = line;
        }
        scanner.close();

        // populates maze matrix with cell objects that contain
        // values from char matrix, cell coordinates,
        // references to previous cells and 'visited' flag
        for (var x = 0; x < values.length; x++)
            for (var y = 0; y < values[x].length; y++)
                maze[x][y] = new Cell(x, y, values[x][y], null, false);

        return maze;
    }
}