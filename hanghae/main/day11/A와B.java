package hanghae.main.day11;

import java.io.*;


// B
// BA  BB  => BBA
// BAA ABB BBA BBB  =>  BBBAA
// BAAA AABB ABBA BBAB BBAA ABBB BBBA BBBB  => BBBBAAA    BBBAA
// BBBBAAA
public class A와B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder(T);
        while (S.length() < sb.length()){
            if(sb.charAt(sb.length() -1) == 'A')
                sb.deleteCharAt(sb.length() -1);
            else {
                sb.deleteCharAt(sb.length() -1);
                sb.reverse();
            }
        }
        if(S.equals(sb.toString()))
            bw.write("1");
        else bw.write("0");
        bw.flush();
    }

}
