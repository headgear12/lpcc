import java.util.*;
import java.io.*;

public class intermidiate {
    public static void main(String[] args) {
        List<String> ans=new ArrayList<>();
        try{
            BufferedReader reader=new BufferedReader(new FileReader("input.txt"));
            String line;
            while((line=reader.readLine())!=null){
                String[] str=line.split("\\s+");
                if(str[0].equals("MACRO")){
                    while(!(line=reader.readLine()).equals("MEND")){

                    }
                }
                if(!line.equals("MEND")){
                    ans.add(line);
                }
            }
            reader.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        for(String str:ans){
            System.out.println(str);
        }
    }
}
