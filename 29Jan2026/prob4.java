import java.util.*;
public class prob4 {
    public static void main(String args[])
    {
        String s[]={"22","3.23","45","ab","66.6"};
        ArrayList <Number> a1=new ArrayList<Number> ();
        for(String p:s)
        {
            try{
            if(p.contains("."))
            {
                Double d=Double.parseDouble(p);
                a1.add(d);
            }
            else
            {
                Integer i=Integer.parseInt(p);
                a1.add(i);
            }
            }
            catch(NumberFormatException e)
            {
                System.out.println("Invalid input");
            }
        }
        int intsum=0;
        double doubsum=0;
        for(Number n:a1)
        {
            if(n instanceof Integer)
            {
                intsum+=n.intValue();
            }
            else if(n instanceof Double)
            {
                doubsum+=n.doubleValue();
            }
        }
        System.out.println("int:"+intsum);
        System.out.println("double:"+doubsum);
    }
}
