package Level1;

/*
최대공약수와 최소공배수
https://school.programmers.co.kr/learn/courses/30/lessons/12940
 */
public class common_multiple_and_common_factor {
    public int[] solution(int n, int m) {
        int max = Math.max(n, m);
        int min = Math.min(n, m);
        int temp = 0;
        int temp2 = 0;

        //최대 공약수 - 유클리드 호재법
        while(min>0){
            temp = max%min;
            max = min;
            min = temp;
        }

        //최소 공배수 ==> 두 수의 곱 / 최대 공약수
        temp2 = (n*m)/max;

        int[] answer = {max, temp2};

        return answer;
    }
}
