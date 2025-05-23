package org.maze;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

// @RequiredArgsConstructor annotation generates
// constructors for final fields

/** Enum for storing possible file names. */
@Getter
@RequiredArgsConstructor
public enum FileName {
    ELEVEN("maze_11x11.txt"),
    THIRTY_ONE("maze_31x31.txt"),
    HUNDRED_AND_ONE("maze_101x101.txt");

    private final String path;
}