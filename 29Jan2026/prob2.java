import java.util.*;
public class prob2 {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String[] emp =new String[5];
        System.out.println("Enter 5 emp names:");
        for(int i=0;i<5;i++)
        {
            emp[i]=sc.nextLine();
        }
        ArrayList<String> a1=new ArrayList<String>();
        Collections.addAll(a1,emp);
        
        HashMap<String,Integer> hm=new HashMap<String,Integer>();
        HashSet<String> hs=new HashSet<String>();
        for(String q:a1)
        {
            hs.add(q);
            if(hm.get(q)==null)
            {
                hm.put(q,1);
            }
            else
            {
                hm.put(q,hm.get(q)+1);
            }
        }
        System.out.println("Arraylist ,Duplicates");
        Iterator<String> i=a1.iterator();
        while(i.hasNext())
        {
            System.out.println(i.next());
        }
        System.out.println("Hashset ,unique");
        for(String w:hs)
        {
            System.out.println(w);
        }
        System.out.println("Hashmap ,freq");
        for(Map.Entry<String,Integer> e:hm.entrySet())
        {
            System.out.println("Name:"+e.getKey()+" "+"Frequency:"+e.getValue());
        }
    }
}
