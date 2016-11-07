public class Magic
{
    public static void main(String[] argv)
    {

        int N = (int)(Math.random()*10)+20;
        if (N % 2 == 0)
            N++;
        int i = 0;
        int j = (N+1)/2;
        int[][] magic = new int[N+1][N+1];
        for (int value = 1; value <= N*N; value++)
        {
            if (value % N == 1)
                i++;
            else
            {
                i--;
                j++;
            }
            if (i == 0)
                i = N;
            if (j > N)
                j = 1;
            magic[i][j] = value;
        }
        System.out.println("魔術方陣大小"+N+"*"+N);
        System.out.println("魔術方陣");
        for(int m = 1; m <= N; m++)
        {
            for(int n = 1; n <= N; n++)
            {
                System.out.printf("%3d ", magic[m][n]);
                if (n == N)
                    System.out.println();
            }
        }

        int midSum = 0;
        for (int m = 1; m <= N; m++)
            midSum += magic[m][(N+1)/2];
        System.out.println("中間列總和 : " + midSum);

        midSum = 0;
        for (int m = 1; m <= N; m++)
            midSum += magic[(N+1)/2][m];

        System.out.println("中間行總和 : " + midSum);
        int crossSum = 0;
        for(int m = 1; m <= N; m++)
            crossSum += magic[m][m];
        System.out.println("對角線總和 : " + crossSum);
    }
}
