import java.io.*;

public class Program2
{
    public static void main(String[] argv)
    {
        SinglyLinkedList<Patient> list = new SinglyLinkedList<Patient>();
        int count = 0;
        int done = 0;
        int select = 0;
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        do
        {
            System.out.println("目前掛號人數 " + count + " 人");
            System.out.println("已看診人數 " + done + " 人");
            System.out.println("[1]掛號 [2]看診 [3]加掛 [4]顯示首位看診病患[5]顯示末位看診病患[6]離開 ==> ");
            System.out.print(" ==> ");
            try
            {
                System.out.flush();
                select = Integer.parseInt(buf.readLine());
                if (select == 1)
                {
                    System.out.println("請輸入姓名 : ");
                    System.out.print(" ==> ");
                    String name = buf.readLine();
                    count++;
                    Patient p = new Patient(count, name);
                    list.addLast(p);
                    System.out.println(" 掛號完成");
                    System.out.println("************************");
                }
                else if (select == 2)
                {
                      list.removeFirst();
                      if (done < count)
                          done++;
                      else
                          System.out.println("無待診病人");
                }
                else if (select == 3)
                {
                    System.out.println("請輸入姓名 : ");
                    System.out.print(" ==> ");
                    String name = buf.readLine();
                    list.addFirst(new Patient(count, name));
                    count++;
                    System.out.println(" 加掛完成");
                    System.out.println("************************");
                }
                else if (select == 4)
                {
                    System.out.println(list.first().getName());
                }
                else if (select == 5)
                {
                    System.out.println(list.last().getName());
                }
                System.out.println();
            }
            catch(Exception e)
            {}
        } while (select != 6);
    }
}
