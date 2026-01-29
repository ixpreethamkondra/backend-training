import java.util.*;
import java.io.*;
public class prob1 {
    public static void main(String [] args) throws IOException
    {
        int ccount=0,wcount=0,scount=0;
         StringBuilder sb1=new StringBuilder();
            StringBuilder sb2=new StringBuilder();
            HashMap<String, Integer> freq = new HashMap<>();
        try{
        BufferedReader br=new BufferedReader(new FileReader("file1.txt"));
        
            String line="abc";
           
            
            while((line=br.readLine())!=null)
            {
                line = line.toLowerCase().replaceAll("\\s+", " ").trim();

                if (line.length() == 0) continue;
                StringBuilder word = new StringBuilder();
                //parse
                for(int i=0;i<line.length();i++)
                {
                    char c=line.charAt(i);
                    //char count
                    if(c==' ')
                    {
                            if(line.charAt(i-1)!=' ')
                                wcount++;
                        
                        if (word.length() > 0) {
                            freq.put(word.toString(),
                                    freq.getOrDefault(word.toString(), 0) + 1);
                            word.setLength(0);
                        }
                        // if (c != '.' && c != '?' && c != '!') {
                            sb1.append(c);   // space  appended for reverse
                        // }

                        continue;
                        
                        
                    }
                    
                    ccount++;
                    if(c!='.' && c!='?' && c!=',')
                    sb1.append(c);
                    
                    if (Character.isLetter(c)) {
                        word.append(c);
                    }

                    //sentence
                    if(c == '.' || c == '?' || c == '!')
                    {
                        scount++;
                        sb2.append(sb1.reverse().toString()).append("\n");
                        sb1.setLength(0);
                    }
                }
                if (word.length() > 0) {
                    freq.put(word.toString(),
                            freq.getOrDefault(word.toString(), 0) + 1);
                }
                if (line.length() > 0 && line.charAt(line.length() - 1) != ' ') {
                    wcount++;
                }


            }
            br.close();
        }
        catch(IOException e)
        {
            System.out.println("Cant open the file");
        }
            System.out.println("character count:"+ccount);
            System.out.println("Word count:"+wcount);
            System.out.println("Sentence count:"+scount);

            System.out.println("\nReversed sentences:");
        System.out.println(sb2);

        System.out.println("Word frequency:");
        for (Map.Entry<String, Integer> e : freq.entrySet()) {
            System.out.println(e.getKey() + " : " + e.getValue());
        }
        
    }
}
