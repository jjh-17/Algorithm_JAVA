package Level1;

//https://school.programmers.co.kr/learn/courses/30/lessons/77884
public class 약수의_개수와_덧셈 {
    private int divide(int num) {
        int n = 0;

        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                n += 2;
                if (Math.sqrt(num) == i)
                    n -= 1;
            }
        }

        if (n % 2 == 0)
            return num;

        return -num;
    }

    public int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++)
            answer += divide(i);

        return answer;
    }
}
