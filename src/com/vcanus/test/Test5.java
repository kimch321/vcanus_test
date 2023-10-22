package com.vcanus.test;

/* 의사코드
 * 1. 이전값의 연못 깊이를 구한다.
 * 2. 새로운 연못 배열을 선언하고 이전 연못을 복사한다.
 * 3. 연못의 요소를 순회한다. (단, 이때 0으로 선언된 요소는 건너뛴다.)
 * 4. 해당 요소의 상하좌우 값을 구한다. 그리고 모두가 자신보다 같거나
크면 현재값을 1 증가시킨다음 새로운 연못 배열에 저장한다.
 * 5. 변경된 연못의 깊이를 구한다.
 * 6. 이전값의 연못 깊이와 비교하여 다른 경우, 2.번으로 돌아간다.
 * 7. 연못 깊이의 이전 값과 이후 값이 같다면 종료하고 해당 값을 리턴한다.
 * */

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

        int pondDepth = calculatePondDepth(initialPond);
        System.out.println("연못 깊이의 총합: " + pondDepth);
    }

    public static int calculatePondDepth(int[][] pond) {
        int rows = pond.length;
        int cols = pond[0].length;
        int[][] newPond = new int[rows][cols];

        int previousDepth = 0;
        int currentDepth = 0;

        while (true) {
            previousDepth = currentDepth;
            currentDepth = 0;

            // 복사된 연못 배열 초기화
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    newPond[i][j] = pond[i][j];
                }
            }

            // 연못의 요소를 순회하며 연못 깊이를 계산
            // 연못의 가장자리는 조건을 충족할 수 없으므로 제외한다.
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                	// 요소가 땅일 경우 건너뛴다.
                    if (pond[i][j] == 0) {
                        continue;
                    }

                    // neighbors가 4라면 해당 값을 증가시킨다.
                    int neighbors = 0;
                    
                    // 상
                    if (i > 0 && pond[i - 1][j] >= pond[i][j]) {
                        neighbors++;
                    }

                    // 하
                    if (i < rows - 1 && pond[i + 1][j] >= pond[i][j]) {
                        neighbors++;
                    }

                    // 좌
                    if (j > 0 && pond[i][j - 1] >= pond[i][j]) {
                        neighbors++;
                    }

                    // 우
                    if (j < cols - 1 && pond[i][j + 1] >= pond[i][j]) {
                        neighbors++;
                    }

                    if (neighbors == 4) {
                        newPond[i][j]++;
                    }

                    currentDepth += newPond[i][j];
                }
            }

            // 새로운 연못 배열을 현재 연못 배열로 업데이트
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    pond[i][j] = newPond[i][j];
                }
            }

            if (currentDepth == previousDepth) {
                break;
            }
        }

        return currentDepth;
    }
}

