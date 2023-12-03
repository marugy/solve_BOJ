import java.util.*;
import java.io.*;
public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        if(str.equals("0"))
            System.out.print("YONSEI");
        else System.out.print("Leading the Way to the Future");
    }
}