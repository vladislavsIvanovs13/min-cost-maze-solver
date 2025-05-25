package org.maze;

import java.io.*;
import java.util.Scanner;

/** Special class for reading maze from txt file. */
public class MazeReader {
    private final String fileName;

    public MazeReader(String fileName) {
        this.fileName = "src/main/resources/" + fileName;
    }

    /** Extracts matrix with values from given txt file. */
    public char[][] getCharMaze() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        char[] firstLine = scanner.nextLine().toCharArray();
        int mazeSize = firstLine.length;
        char[][] values = new char[mazeSize][mazeSize];

        // fills char matrix with values from txt file
        int i = 0;
        values[i++] = firstLine;
        while (scanner.hasNextLine()) {
            char[] line = scanner.nextLine().toCharArray();
            values[i++] = line;
        }
        scanner.close();

        return values;
    }

    /** Converts value matrix to Cell object matrix. */
    public Cell[][] getMaze() throws FileNotFoundException {
        char[][] values = getCharMaze();
        int mazeSize = values.length;
        Cell[][] maze = new Cell[mazeSize][mazeSize];

        // populates maze matrix with cell objects that contain
        // values from char matrix, cell coordinates,
        // references to previous cells and 'visited' flag
        for (var x = 0; x < maze.length; x++)
            for (var y = 0; y < maze[x].length; y++)
                maze[x][y] = new Cell(x, y, values[x][y], null, false);

        return maze;
    }
}