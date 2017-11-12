public class Knapsack
{
    public static void main(String args[])
    {
        int weight[] = {1,3,4,5};
        int value[] = {1,4,5,7};
        int totalWeight = 7;
        int maxValue = solveKnapsack(weight,value,totalWeight);
        System.out.println(maxValue);
    }

    public static int solveKnapsack(int weight[], int value[], int totalWeight)
    {
        int n = value.length;
        int table[][] = new int[n][totalWeight+1];
        for(int i = 0; i < n; i++)
        {
            for(int w = 0; w <= totalWeight; w++)
            {
                if(w == 0)
                {
                    table[i][w] = 0;
                }
                else if(weight[i] <= w)
                {
                    if(i-1 >= 0)
                    {
                        table[i][w] = Integer.max(table[i-1][w],value[i] + table[i-1][w-weight[i]]);
                    }
                    else
                    {
                        table[i][w] = value[i];
                    }
                }
                else
                {
                    if(i-1 >= 0)
                    {
                        table[i][w] = table[i-1][w];
                    }
                    else
                    {
                        table[i][w] = 0;
                    }

                }

                System.out.printf("%d ",table[i][w]);

            }
            System.out.println();
        }

        return table[n-1][totalWeight];
    }
}
