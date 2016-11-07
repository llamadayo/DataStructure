public class InsertionSort
{
    public static void insertionSort(char[] data)
    {
        int n = data.length;
        for (int k = 1; k < n; k++)
        {
            char cur = data[k];
            int j = k;
            while(j > 0 && data[j - 1] > cur)
            {
                data[j] = data[j - 1];
                j--;
            }
            data[j] = cur;
        }    
    }
    public static void main(String[] argv)
    {
        char[] a = {'C', 'E', 'B', 'D', 'A', 'J', 'I'};
        System.out.println(java.util.Arrays.toString(a));
        insertionSort(a);
        System.out.println(java.util.Arrays.toString(a));
    }


}
