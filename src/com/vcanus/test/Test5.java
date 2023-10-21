package com.vcanus.test;

public class Test5 {
    public static void main(String[] args) {
        int[][] initialPond = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 1, 1, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 1, 1, 0, 0, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 0, 1, 1, 1, 1, 1, 1, 0, 0},
            {0, 0, 0, 1, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        int[][] result = calculatePondDepth(initialPond);

        // 출력
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] calculatePondDepth(int[][] pond) {
        int rows = pond.length;
        int cols = pond[0].length;
        int[][] updatedPond = new int[rows][cols];
        boolean changed;

        do {
            changed = false;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    int currentHeight = pond[i][j];
                    int minNeighbor = currentHeight;

                    int[] rowOffsets = {-1, 1, 0, 0};
                    int[] colOffsets = {0, 0, -1, 1};

                    for (int k = 0; k < 4; k++) {
                        int ni = i + rowOffsets[k];
                        int nj = j + colOffsets[k];

                        if (ni >= 0 && ni < rows && nj >= 0 && nj < cols) {
                            minNeighbor = Math.min(minNeighbor, pond[ni][nj]);
                        }
                    }

                    if (minNeighbor + 1 > currentHeight) {
                        updatedPond[i][j] = minNeighbor + 1;
                        changed = true;
                    } else {
                        updatedPond[i][j] = currentHeight;
                    }
                }
            }

            // 복사된 결과를 다시 원래 배열에 복사
            for (int i = 0; i < rows; i++) {
                System.arraycopy(updatedPond[i], 0, pond[i], 0, cols);
            }

        } while (changed);

        return pond;
    }
}
