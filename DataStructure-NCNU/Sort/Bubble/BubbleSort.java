public class BubbleSort
{
    public static int[] bubbleSort(int[] arr)
    {
        int tmp;
        for (int i = 0; i < arr.length-1; i++)
            for (int j = i + 1; j < arr.length; j++)
                if (arr[i] > arr[j])
                {
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
        return arr;
    }

    public static void main(String[] argv)
    {
        int capacity = (int)(Math.random()*11+10);
        int[] data = new int[capacity];
        for (int i = 0; i < data.length; i++)
            data[i] = (int)(50-Math.random()*101);
        bubbleSort(data);
        for (int i = 0; i < data.length; i++)
            System.out.println(data[i]);
    }
}
