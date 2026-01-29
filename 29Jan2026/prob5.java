import java.util.*;
import java.io.*;


class AgeNotValidException extends Exception {
    public AgeNotValidException(String msg) {
        super(msg);
    }
}
class Student
{
    Integer id;
    String name;
    Integer age;

    Student(Integer id, String name, Integer age) 
    {
        this.id = id;
        this.name = name;
        this.age = age;
    }

}

public class prob5 {
    public static void main(String args[]) throws FileNotFoundException
    {
        String line;
        List<Student> validList = new ArrayList<>();
        HashSet<Integer> h1 = new HashSet<Integer>();
        try{
            BufferedReader br=new BufferedReader(new FileReader("file5.txt"));
            BufferedWriter valid = new BufferedWriter(new FileWriter("valid.txt"));
            BufferedWriter invalid = new BufferedWriter(new FileWriter("invalid.txt"));

            while((line=br.readLine())!=null)
            {
                line=line.toLowerCase().replaceAll("\\s+", " ").trim();
                if(line.length()==0) continue;
                try{
                    String[] parts = line.split(",");
                    if(parts.length != 3) {
                        invalid.write(line);
                        invalid.newLine();
                        continue;
                    }
                    Integer id = Integer.parseInt(parts[0].trim());  
                    String name = parts[1].trim();
                    Integer age = Integer.parseInt(parts[2].trim());

                    if(age < 18)
                    {
                        throw new AgeNotValidException("Age below 18");
                    }

                    
                    Student s = new Student(id, name, age);
                    if(h1.contains(id)){
                        invalid.write(line);
                        invalid.newLine();
                        continue;
                    }
                    h1.add(id);

                    validList.add(s);
                }
                catch(AgeNotValidException e) {
                    System.out.println(e.getMessage());
                    invalid.write(line);
                    invalid.newLine();
                }
                catch(NumberFormatException e) {
                    invalid.write(line);
                    invalid.newLine();
                }
                
            }
            for(Student s : validList)
                {
                    valid.write(s.id+","+s.name+","+s.age);
                    valid.newLine();
                }
            br.close();
            valid.close();
            invalid.close();

        }
        catch(IOException e)
        {
            System.out.println("cant open file");
        }

    }
}
