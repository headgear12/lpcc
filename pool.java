import java.util.*;
import java.io.*;

public class pool {
    public static void main(String[] args) {
        Map<String, Integer> literal = new HashMap<>();
        String key = ""; // Initialize key outside the loop
        try {
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            String line;
            int i=1;
            while ((line = reader.readLine()) != null) {
                String[] s = line.split("\\s+");
                if (s[s.length - 1].charAt(0) == '=') {
                    if (literal.size() == 0) {
                        key = s[s.length - 1];
                    }
                    literal.put(s[s.length - 1], i++);
                }
                if (s[0].equals("LTORG")) {
                    if (!literal.isEmpty()) {
                        System.out.println(key + " #" + literal.get(key));
                    }
                    literal.clear();
                }
            }
            if (!literal.isEmpty()) {
                System.out.println(key + " #" + literal.get(key));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
