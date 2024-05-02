import java.util.*;
import java.io.*;

public class symboltable {
    static int LC = 0;
    static List<String> mnemonics = new ArrayList<>(Arrays.asList("STOP", "ADD", "SUB", "MUL", "MOVER", "MOVEM", "COMP", "BC", "DIV", "READ", "PRINT", "LTORG", "ORIGIN", "START", "EQU", "DS", "DC", "END"));
    static Map<String, int[]> symtab = new HashMap<>();
    static int symindex = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:/Users/prasa/OneDrive/Desktop/assignments/3rd Year/SEM 2/LPCC/Practical/input.txt"));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] words = line.split("\\s+");
            int k = 0;

            if (mnemonics.contains(words[0])) {
                detectMn(k, words);
            } else {
                if (!symtab.containsKey(words[k])) {
                    symtab.put(words[k], new int[]{LC, symindex});
                    symindex++;
                } else {
                    int[] x = symtab.get(words[k]);
                    if (x[0] == -1) {
                        symtab.put(words[k], new int[]{LC, x[1]});
                    }
                }
                k = 1;
                detectMn(k, words);
            }
        }

        reader.close();
        symbol();
    }

    static void detectMn(int k, String[] words) {
        String mnemonic = words[k];

        if (mnemonic.equals("START")) {
            LC = Integer.parseInt(words[1]);
        } else if (mnemonic.equals("END") || mnemonic.equals("LTORG")) {
            // Do nothing
        } else if (mnemonic.equals("ORIGIN")) {
            LC = Integer.parseInt(words[k + 1]);
        } else if (mnemonic.equals("DS")) {
            LC += Integer.parseInt(words[k + 1]);
        } else if (mnemonic.equals("DC")) {
            LC += 1;
        } else {
            LC += 1;
        }
    }

    static void symbol() {
        System.out.println("Symbol Table:");
        for (String key : symtab.keySet()) {
            int[] value = symtab.get(key);
            System.out.println(key + "\t" + value[0] + "\t" + value[1]);
        }
    }
}