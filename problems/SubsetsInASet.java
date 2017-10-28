public class SubsetsInASet
{
    public static void main(String args[])
    {
        Integer arr[] = {1,2,3,4};
        printAllSubsets(arr);
    }

    public static void printAllSubsets(Integer arr[])
    {
        Integer subset[] = new Integer[arr.length];
        helper(arr,subset,0);
    }

    public static void helper(Integer arr[],Integer subset[],int index)
    {
        if (index == arr.length)
        {
            printSubset(subset);
        }
        else
        {
            subset[index] = null;
            helper(arr,subset,index+1);
            subset[index] = arr[index];
            helper(arr,subset,index+1);
        }
    }

    public static void printSubset(Integer subset[])
    {
        System.out.printf("{ ");
        for(int i = 0; i < subset.length;i++)
        {
            if(subset[i] != null)
            {
                System.out.printf("%d, ",subset[i]);
            }
        }
        System.out.printf(" }");
    }
}
