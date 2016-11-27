import java.util.*;

public class Program6
{
    public static void main(String[] argv)
    {
        Scanner input = new Scanner(System.in);
        ArrayList list = new ArrayList();
        int cousor = -1;
        boolean hasCopy = false;
        int copyIndex = -100000;
        while (input.hasNext())
        {
            String cmd = input.next();
            if (cmd.equals("insert"))
            {
                cousor++;
                list.add(cousor, input.next().charAt(0));
            }
            else if (cmd.equals("left"))
            {
                cousor--;
                if (cousor < 0)
                {
                    System.out.println("It's at the beginning\n");
                    cousor = 0;
                }
            }
            else if (cmd.equals("right"))
            {
                cousor++;
                if (cousor > list.size()-1)
                {
                    System.out.println("It's at the end\n");
                    cousor = list.size()-1;
                }
            }

            else if (cmd.equals("delete"))
            {
                if (cousor == list.size()-1)
                    System.out.println("At the end ! Nothing could delete");
                else
                {
                    list.remove(cousor + 1);
                }
            }

            else if (cmd.equals("copy"))
            {
                copyIndex = cousor;
                hasCopy = true;
            }
            else if (cmd.equals("paste"))
            {
                if (hasCopy)
                {
                    cousor++;
                    list.add(cousor, list.get(copyIndex));
                }
                else
                    System.out.println("Nothing to paste");
            }
            for (int i = 0; i < list.size(); i++)
            {
                if (i == cousor)
                    System.out.print("\033[31;1m"+list.get(i)+"\033[0m");
                else
                    System.out.print(list.get(i));
            }
            System.out.println();
        }
    }


}
