package Level1;

import java.util.Stack;

public class hamburger {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i : ingredient) {
            stack.add(i);

            if (stack.size() >= 4) {
                int l = stack.size();
                if (stack.get(l - 1) == 1 && stack.get(l - 2) == 3 && stack.get(l - 3) == 2 && stack.get(l - 4) == 1) {
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    answer += 1;
                }
            }
        }

        return answer;
    }
}
