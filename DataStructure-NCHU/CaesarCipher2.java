import java.util.Scanner;

public class CaesarCipher2
{
    public static void main(String[] argv)
    {
        Scanner input = new Scanner(System.in);
        String str = input.next();
        char[] data = str.toCharArray();
        int length = data.length;
        int shift = input.nextInt();
        for (int i = 0; i < data.length; i++)
        {
            char c = data[i];
            if (c >= 'A' && c <= 'Z')
            {
                int v = c - 'A';
                c = (char)((v + shift) % 26 + 'A');                       // 計算從'A'到要交換的值的距離v並加上要shift的位置
            }
            else if (c >= 'a' && c <= 'z')
            {
                int v = c - 'a';
                c = (char)((v + shift) % 26 + 'a');                       // 計算從'A'到要交換的值的距離v並加上要shift的位置
            }
            System.out.print(c);
        }
        System.out.println();
    }
}
