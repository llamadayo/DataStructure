public class Program3
{
    public static void main(String[] argv)
    {
        new HelloWorldApplet();
        String ID = "4104029043";
        long start, end;
        long[] m1 = new long[10];
        long[] m2 = new long[10];
        int[] times = new int[10];
        int n = 10000;
        for (int i = 0; i < 10; i++)
        {
            start = System.currentTimeMillis();
            method1(ID, n);
            end = System.currentTimeMillis();
            m1[i] = end - start;
            start = System.currentTimeMillis();
            method2(ID, n);
            end = System.currentTimeMillis();
            m2[i] = end - start;
            times[i] = n;
            n += 10000;
        }
        for(int i = 0; i < 10; i++)
            System.out.println("當 n = "+times[i]+"時"+"method1執行時間 : "+ m1[i]+"ms method2執行時間 : " + m2[i] + "ms");
    }

    public static String method1(String s, int n)
    {
        String str = "";
        for (int i = 0; i < n; i++)
            str += s;
        return str;
    }

    public static String method2(String s, int n)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            sb.append(s);
        return sb.toString();
    }

}
