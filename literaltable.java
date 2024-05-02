import java.io.*;
import java.util.*;

public class literaltable {
    public static void main(String[] args) {
        List<String[]> tokens = new ArrayList<>();
        int lc = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:/Users/prasa/OneDrive/Desktop/assignments/3rd Year/SEM 2/LPCC/Practical/input.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                tokens.add(line.split("\\s+"));
            }

            lc = Integer.parseInt(tokens.get(0)[tokens.get(0).length - 1]);
            List<Integer> lcList = new ArrayList<>();
            for (int i = 0; i < tokens.size(); i++) {
                lcList.add(lc);
                if(tokens.get(i).length >1){
                    if (tokens.get(i)[1].equals("DS")) {
                        int incr = Integer.parseInt(tokens.get(i)[tokens.get(i).length - 1]);
                        lc += incr;
                    } else{
                        lc++;
                    }
                }else{
                    lc++;
                }
            }

            List<String[]> lt = new ArrayList<>();
            int end = lcList.get(lcList.size() - 1);

            for (String[] i : tokens) {
                if (i[i.length - 1].charAt(0) == '=') {
                    lt.add(new String[]{i[i.length - 1], "-1"});
                }
            }

            for (String[] i : lt) {
                i[1] = String.valueOf(end);
                end++;
            }

            for (String[] i : lt) {
                for (String s : i) {
                    System.out.print(s + " ");
                }
                System.out.println();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}