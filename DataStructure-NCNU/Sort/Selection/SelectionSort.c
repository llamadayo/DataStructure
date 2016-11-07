#include<stdio.h>

int main()
{
    int length = 10;
    int data[10] = {-24, 12, -5, 98, 43, 39, 4, -8, -98, -100};
    int tmp, i, j, minIndex, index;
    for (i = 0; i < length - 1; i++)
    {
        minIndex = i;
        for (j = i + 1; j < length; j++)
        {
            if (data[j] < data[minIndex])
                minIndex = j;
        }
        tmp = data[i];
        data[i] = data[minIndex];
        data[minIndex] = tmp;
        for (index = 0; index < 10; index++)
            printf("%3d ", data[index]);
        printf("\n");
    }

}
