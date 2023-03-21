package Level2;

import java.util.Stack;

//https://school.programmers.co.kr/learn/courses/30/lessons/42584
public class 주식가격 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>(); //값이 감소하지 않은 시간대를 저장

        stack.push(0);
        for (int i = 1; i < prices.length; i++) {
            //stack.peek() : 값이 감소하지 않은 가장 최근 시간대
            //prices[stack.peek()] : 값이 감소하지 않은 시간대 중 가장 큰 가격
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            answer[stack.peek()] = prices.length - stack.peek() - 1;
            stack.pop();
        }

        return answer;
    }
}
