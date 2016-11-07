import java.util.Scanner;

public class GameEntries
{
    private int score;
    private String name;

    public GameEntries(String s, int i)
    {
        score = i;
        name = s;
    }

    public int getScore()
    {
        return score;
    }

    public String getName()
    {
        return name;
    }

    public static void main(String[] argv)
    {
        Scanner input = new Scanner(System.in);
        String name = input.next();
        int score = input.nextInt();
        GameEntries game = new GameEntries(name, score);
        System.out.println(game.getName() +" "+game.getScore());
    }


}
