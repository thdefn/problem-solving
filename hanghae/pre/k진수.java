package hanghae.pre;

public class k진수 {
    public static void main(String[] args) {
        System.out.println(solution(151, 10));
    }

    public static int solution(int n, int k) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        while (n >= k) {
            sb.append(n % k);
            n = n / k;
        }
        sb.append(n);

        int digit = 0;
        long number = 0;
        for (char c : sb.toString().toCharArray()){
            if(c == '0'){
                if(isPrimeNumber(number)) answer++;
                digit = 0;
                number = 0;
            } else {
                number += (long) ((c - '0') * Math.pow(10, digit));
                digit++;
            }
        }
        if(isPrimeNumber(number)) answer++;


        return answer;
    }

    public static boolean isPrimeNumber(long n) {
        if(n < 2) return false;
        for (int i = 2; i < Math.sqrt(n) + 1; i++) {
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}
