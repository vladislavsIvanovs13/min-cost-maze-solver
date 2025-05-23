package org.maze;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

// @RequiredArgsConstructor annotation generates
// constructors for final fields

/** Enum for storing possible eight directions to move to from current cell. */
@Getter
@RequiredArgsConstructor
public enum Direction {
    LEFT(new int[]{0, -1}),
    RIGHT(new int[]{0, 1}),
    UP(new int[]{-1, 0}),
    DOWN(new int[]{1, 0}),
    UP_LEFT(new int[]{-1, -1}),
    UP_RIGHT(new int[]{-1, 1}),
    DOWN_LEFT(new int[]{1, -1}),
    DOWN_RIGHT(new int[]{1, 1});

    private final int[] steps;
}
