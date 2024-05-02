import java.util.*;

public class MacroProcessor {
    static Map<String, List<String>> macroTable = new HashMap<>();
    public static void main(String[] args) {
        String[] inputCode = {
            "LOAD A",
            "MACRO ABC",
            "LOAD p",
            "SUB q",
            "MEND",
            "STORE B",
            "MULT D",
            "MACRO ADD1 ARG",
            "LOAD X",
            "STORE ARG",
            "MEND",
            "LOAD B",
            "MACRO ADD5 A1, A2, A3",
            "STORE A2",
            "ADD1 5",
            "ADD1 10",
            "LOAD A1",
            "LOAD A3",
            "MEND",
            "ADD1 t",
            "ABC",
            "ADD5 D1, D2, D3",
            "END"
        };

        // Pass 1: Scan for macro definitions and store them in macro table
        pass1(inputCode);

        // Pass 2: Expand macros
        pass2(inputCode);
    }

    // Pass 1: Scan for macro definitions and store them in macro table
    static void pass1(String[] code) {
        for (int i = 0; i < code.length; i++) {
            if (code[i].startsWith("MACRO")) {
                String macroName = code[i].split("\\s+")[1];
                List<String> macroDefinition = new ArrayList<>();
                i++; // Skip the macro definition line
                while (!code[i].equals("MEND")) {
                    macroDefinition.add(code[i]);
                    i++;
                }
                macroTable.put(macroName, macroDefinition);
            }
        }
    }

    // Pass 2: Expand macros
    static void pass2(String[] code) {
        for (String line : code) {
            if (line.startsWith("MACRO")) {
                String macroName = line.split("\\s+")[1];
                List<String> macroDefinition = macroTable.get(macroName);
                for (String macroLine : macroDefinition) {
                    System.out.println(macroLine);
                }
            } else {
                System.out.println(line);
            }
        }
    }
}
