public class TowerHopper
{
    public static void main(String args[])
    {
        Integer arr[] = {1,3,5,3,1,1,1,0};
        System.out.println(isHoppable(arr));
    }

    public static boolean isHoppable(Integer arr[])
    {
        int current = 0;
        while (true)
        {
            if(current >= arr.length)
            {
                return true;
            }
            else if(arr[current] == 0)
            {
                return false;
            }
            current = nextStep(current,arr);
        }
    }

    public static int nextStep(int current, Integer arr[])
    {
        int hops = arr[current];
        if(hops + current >= arr.length)
        {
            return hops + current;
        }
        int max = Integer.MIN_VALUE;
        int next = current;
        while(hops> 0)
        {
            current++;
            hops--;
            if (arr[current] >= max)
            {
                next = current;
                max = arr[current];
            }
        }
        return next;
    }

}
