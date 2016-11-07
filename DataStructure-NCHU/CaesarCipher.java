import java.util.Scanner;

public class CaesarCipher
{
    protected char[] encoder = new char[26];
    protected char[] decoder = new char[26];
    public CaesarCipher(int rotation)
    {
        for (int k = 0; k < 26; k++)
        {
            encoder[k] = (char) ('A' + (k + rotation) % 26);
            decoder[k] = (char) ('A' + (k - rotation + 26) % 26);
          //  System.out.println(encoder[0]);
        }
    }

    public String getEncode()
    {
        String s = String.valueOf(encoder);
        return s;
    }

    public String getDecode()
    {
        String s = new String(decoder);
        return s;
    }

    public static void main(String[] argv)
    {
        Scanner input = new Scanner(System.in);
        int rotat = input.nextInt();
        CaesarCipher CC = new CaesarCipher(rotat);
        System.out.println(CC.getEncode() + "\n" + CC.getDecode());
    }
/*
    public String encrypt(String message)
    {
        return transform(message, encoder);
    }

    public String decrypt(String secret)
    {
        return transform(secret, decoder);
    }
 */
}
