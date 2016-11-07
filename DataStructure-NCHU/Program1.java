/**
 * 4104029043
 * 許達夫
 */

import java.util.Scanner;

public class Program1
{

    public static Student[] sort(Student[] arr, int data)
    {
        for (int i = 0; i < data - 1; i++)
            for (int j = i + 1; j < data; j++)
            {
                if (arr[i].getGrade() < arr[j].getGrade())
                {
                    Student tmp;
                    tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }
            }
        return arr;
    }

    public static Student[] sortID(Student[] arr, int data)
    {
        for (int i = 0; i < data - 1; i++)
            for (int j = i + 1; j < data; j++)
            {
                if (arr[i].getID() > arr[j].getID())
                {
                    Student tmp;
                    tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }
            }
        return arr;
    }

    public static Student[] adding(Student[] arr, Student newStu, int dataNum)
    {
        int i = dataNum - 1;
        while (i > 0 && newStu.getGrade() > arr[i - 1].getGrade())
        {
            arr[i] = arr[i - 1];
            i--;
        }
        arr[i] = newStu;
        return arr;
    }

    public static Student[] remove(Student[] arr, int index, int dataNum)
    {
        while (index < dataNum)
        {
            arr[index] = arr[index + 1];
            index++;
        }
        arr[dataNum-1] = null;
        return arr;
    }

    public static void main(String[] argv)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("請輸入初始資料量：");
        int data = input.nextInt();                                         // 計算學生資料數
        Student[] student = new Student[100];                               // 存放學生資料
        Student[] BestStudentBoard = new Student[5];                        // 存放最高分五名學生
        System.out.println("依序輸入ID, 姓名, 分數 : ");
        for (int i = 0; i < data; i++)
            student[i] = new Student(input.nextInt(), input.next(), input.nextInt()); // 讀取id, name, grade建立物件,存入陣列
        sort(student, data);                                                // 排序,依成績高低
        for (int i = 0; i < BestStudentBoard.length; i++)                   // 存入最高分的五名
            BestStudentBoard[i] = student[i];
        System.out.println("請輸入指令(adding/remove/changingScore/rename/show/end) : ");
        while(input.hasNext())
        {
            String cmd = input.next();                                      // 讀取指令
            if (cmd.equals("adding"))                                       // 新增一名學生
            {
                data++;
                System.out.println("依序輸入ID, 姓名, 分數 : ");
                Student newStu = new Student(input.nextInt(), input.next(), input.nextInt());
                adding(student, newStu, data);
            }
            else if (cmd.equals("remove"))                                 // 移除一名學生
            {
                System.out.println("\n"+"所有同學 : ");
                for (int i = 0; i < data; i++)
                    student[i].showDetails();                                     // 列出全部學生資料

                System.out.print("請輸入索引值,以移除該筆資料 : ");

                int index = input.nextInt();

                remove(student, index, data);
                data--;
            }
            else if (cmd.equals("changingScore"))                         // 由id搜尋,更改學生成績
            {
                System.out.println("請輸入ID, 更改該同學分數 : ");
                int search = input.nextInt();
                for (int i = 0; i < data; i++)
                {
                    if (search == student[i].getID())
                    {
                        System.out.print("請輸入分數 : ");
                        student[i].changingScore(input.nextInt());
                    }
                }
                sort(student, data);                                      // 再依成績重新排列
            }
            else if (cmd.equals("rename"))                                // 由id 搜尋, 更改name
            {
                System.out.println("請輸入ID, 更改該同學name : ");
                int search = input.nextInt();
                for (int i = 0; i < data; i++)
                {
                    if (search == student[i].getID())
                    {
                        System.out.println("請輸入新name : ");
                        student[i].rename(input.next());
                    }
                }
            }
            else if (cmd.equals("show"))
            {
                sort(student, data);
                for (int i = 0; i < BestStudentBoard.length; i++)                 // 重新儲存前五高分同學
                    BestStudentBoard[i] = student[i];
                System.out.println("\n"+"前五高分同學 : ");
                for (int i = 0; i < BestStudentBoard.length; i++)                 // 列出前五高分同學資料
                    BestStudentBoard[i].showDetails();
                sortID(student, data);                                            // 透過id sort （由小到大）
                System.out.println("\n"+"所有同學 : ");
                for (int i = 0; i < data; i++)
                    student[i].showDetails();                                     // 列出全部學生資料

            }
            else if (cmd.equals("end"))                                   // 結束
                break;
            System.out.println("請輸入指令(adding/remove/changingScore/rename/show/end) : ");
        }
        for (int i = 0; i < BestStudentBoard.length; i++)                 // 重新儲存前五高分同學
            BestStudentBoard[i] = student[i];
        System.out.println("\n"+"前五高分同學 : ");
        for (int i = 0; i < BestStudentBoard.length; i++)                 // 列出前五高分同學資料
            BestStudentBoard[i].showDetails();
        sortID(student, data);                                            // 透過id sort （由小到大）
        System.out.println("\n"+"所有同學 : ");
        for (int i = 0; i < data; i++)
            student[i].showDetails();                                     // 列出全部學生資料
    }

}
