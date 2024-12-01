class Solution 
{
    public boolean checkIfExist(int[] arr) 
    {
        for(int i = 0;i<arr.length;i++)
        {
            for(int j = 0;j<arr.length;j++)
            {
                if(arr[i] == 2*arr[j] && i!=j)
                {
                    System.out.print(arr[i]+" "+arr[j]);
                    return true;
                }
            }
        }
        return false;
    }
}