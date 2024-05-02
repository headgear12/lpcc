import java.util.*;
import java.io.*;

public class mdt_mnt {
    public static void main(String[] args) {
        HashMap<String,Integer> mnt=new HashMap<>();
        List<String> mdt=new ArrayList<>();
        try {
            BufferedReader reader=new BufferedReader(new FileReader("input.txt"));
            List<String> str=new ArrayList<>();
            String line;
            int i=0;
            while((line=reader.readLine())!=null) {
                i++;
                str.add(line);
                String[] s=line.split("\\s+");
                if(s[0].equals("MACRO")) {
                    if(mnt.size()==0){
                        i=1;
                    }
                    mnt.put(s[1],i);
                    while(!(line=reader.readLine()).equals("MEND")) {
                        i++;
                        mdt.add(line);
                    }
                    i++;
                    mdt.add("MEND");
                }
            }
            reader.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
        for(String key : mnt.keySet()) {
            System.out.println(key + " " + mnt.get(key));
        }
        for(int i=0;i<mdt.size();i++) {
            System.out.println(i+1+"\t"+mdt.get(i));
        }
    }
}