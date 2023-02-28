package Level1;

import java.util.Stack;

/*
크레인 인형뽑기
https://school.programmers.co.kr/learn/courses/30/lessons/64061
 */
public class crane {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int depth = board.length;
        int length = board[0].length;
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[length]; //각 열에서 최상단 인형의 위치

        //각 열에서 최상단 인형의 위치를 arr에 저장
        for (int i = 0; i < length; i++) {
            int count = 0;

            for (int j = 0; j < depth; j++) {
                if (board[count + j][i] != 0) {
                    arr[i] = count + j;
                    break;
                }
            }
        }

        //moves 순회
        for (Integer move : moves) {
            move -= 1;
            if (arr[move] != depth) {
                if (stack.empty())
                    stack.push(board[arr[move]][move]);
                else{
                    if (board[arr[move]][move] == stack.peek()) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(board[arr[move]][move]);
                    }
                }
                arr[move] += 1;
            }
        }


        return answer;
    }
}
