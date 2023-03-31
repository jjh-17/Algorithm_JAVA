package Level2;

import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/17686
public class 파일명_정렬 {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        String[][] arr = new String[files.length][3]; //각 문자열의 head, number, tail 저장 배열

        //files 내 각 문자열을 head, number, tail로 나눈다
        for (int i = 0; i < files.length; i++) {
            char[] file_arr = files[i].toCharArray();
            String head = "", number = "", tail = "";
            int flag = 0; //0: head 부분, 1: number 부분, 2: tail 부분

            for (char c : file_arr) {
                if (flag == 0) { //head
                    if (c < '0' || c > '9') //숫자가 아닌 문자열
                        head += c;
                    else {
                        number += c;
                        flag = 1;
                    }
                } else if (flag == 1) { //number
                    if (c >= '0' && c <= '9') //숫자가 아닌 문자열
                        number += c;
                    else {
                        tail += c;
                        flag = 2;
                    }
                } else { //tail
                    tail += c;
                }
            }
            arr[i][0] = head;
            arr[i][1] = number;
            arr[i][2] = tail;
        }

        //arr에 저장된 head, number에 따라 arr 정렬
        Arrays.sort(arr, (a, b) -> {
            if (a[0].toLowerCase().compareTo(b[0].toLowerCase()) > 0) {
                return 1;
            } else if (a[0].toLowerCase().compareTo(b[0].toLowerCase()) < 0) {
                return -1;
            } else{ //head의 순서가 동일한 경우 ==> number 비교
                return Integer.compare(Integer.parseInt(a[1]), Integer.parseInt(b[1]));
            }
        });

        for (int i = 0; i < arr.length; i++) {
            answer[i] = arr[i][0] + arr[i][1] + arr[i][2];
        }


        return answer;
    }
}
