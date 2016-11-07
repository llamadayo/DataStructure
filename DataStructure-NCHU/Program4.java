import java.io.File;
import java.util.Scanner;
import java.util.regex.*;

public class Program4
{
    public static void main(String[] argv)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a path : ");
        String path = input.next();
        File f = new File(path);
        while (!f.isDirectory())
        {
            System.out.print("Please enter a path : ");
            path = input.next();
            f = new File(path);
        }
        File[] fileList = f.listFiles();
        System.out.println("[1]list [2]search [3]end ");
        System.out.print(" ==> ");
        while (input.hasNext())
        {
            String cmd = input.next();
            if (cmd.equals("list"))
            {
                for (int i = 0 ; i < fileList.length; i++)
                    System.out.println(fileList[i].length()+"      "+fileList[i].getName()+"  "+fileList[i].getAbsolutePath());
            }
            else if (cmd.equals("search"))
            {
                System.out.println("Please enter a file name : (Allow wildcard search)");
                String fileName = input.next();
                searchFile(fileList, fileName);
            }
            else if (cmd.equals("end"))
                break;

            System.out.println("[1]list [2]search [3]end ");
            System.out.print(" ==> ");
        }
    }

    public static void searchFile(File[] fileList, String name)
    {
        Pattern pattern;
        boolean isExist = false;
        try
        {
            pattern = Pattern.compile(name);
        }
        catch(Exception e)
        {
            pattern = Pattern.compile("."+name);
        }
        for (int i = 0; i < fileList.length; i++)
        {
            Matcher matcher = pattern.matcher(fileList[i].getName());
            while (matcher.find())
            {
                System.out.println("File exists ! At " + fileList[i].getAbsolutePath() +" size : "+fileList[i].length());
                isExist = true;
            }
        }
        if (isExist)
            return;
        else
            System.out.println("File doesn't exists !");
    }
}
