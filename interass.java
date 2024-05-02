import java.util.*;

public class interass {
    public static void generateInter(List<String> sourceCode) {
        for (String line : sourceCode) {
            String[] tokens = line.trim().split("\\s+");
            if (tokens[1].equals("LTORG")) {
                continue;
            }
            if (tokens[1].equals("START")) {
                if (!tokens[2].equals("*")) {
                    System.out.println("(AD ,01) (C," + tokens[2] + ")");
                }
            } else if (tokens[1].equals("READ")) {
                int symbolIndex = 0;
                if (tokens[2].equals("B")) {
                    symbolIndex = 1;
                }
                System.out.println("(IS ,09) (S," + symbolIndex + ")");
            } else if (tokens[1].equals("MOVER")) {
                int symbolIndex = 0;
                if (tokens[2].equals("B")) {
                    symbolIndex = 1;
                }
                System.out.println("(IS ,04) (1) (S," + symbolIndex + ")");
            } else if (tokens[1].equals("SUB")) {
                int symbolIndex = 0;
                if (tokens[2].equals("B")) {
                    symbolIndex = 1;
                }
                System.out.println("(IS ,02) (1) (S," + symbolIndex + ")");
            } else if (tokens[1].equals("STOP")) {
                System.out.println("(IS ,00)");
            } else if (tokens[1].equals("DS")) {
                System.out.println("(DL ,02) (C," + tokens[2] + ")");
            } else if (tokens[1].equals("END")) {
                System.out.println("(AD ,02)");
            }
        }
    }

    public static void main(String[] args) {
        List<String> assemblyCode = Arrays.asList(
            "* START 100 *",
            "* READ A *",
            "* READ B *",
            "* MOVER AREG, A",
            "* SUB AREG, B",
            "* STOP * *",
            "A DS 1 *",
            "B DS 1 *",
            "* END * *"
        );
        // Generate and print intermediate code
        generateInter(assemblyCode);
    }
}
