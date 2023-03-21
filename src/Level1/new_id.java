package Level1;

public class new_id {
    public String solution(String new_id) {
        String answer = "";

        //1
        String step1 = new_id.toLowerCase();

        //2
        char[] arr = step1.toCharArray();
        StringBuilder step2 = new StringBuilder();
        for (char c : arr) {
            if (('a' <= c && c <= 'z') || ('0' <= c && c <= '9') || c == '-' || c == '_' || c == '.') {
                step2.append(c);
            }
        }

        //3
        String step3 = step2.toString().replace("..", ".");
        while (step3.contains("..")) {
            step3 = step3.toString().replace("..", ".");
        }

        //4
        String step4 = step3;
        if (step4.length() > 0) {
            if (step4.charAt(0) == '.') {
                step4 = step4.substring(1);
            }
        }
        if (step4.length() > 0) {
            if (step4.charAt(step4.length()-1) == '.') {
                step4 = step4.substring(0, step4.length() - 1);
            }
        }

        //5
        String step5 = step4;
        if (step5.isEmpty()) {
            step5 = "a";
        }

        //6


        //7



        return answer;
    }
}
