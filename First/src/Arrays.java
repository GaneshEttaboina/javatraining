public class Arrays {
    public static void main(String[] args) {
        int arr[]={2,41,5,6,7,8,9,0,10,28,45,3,4,22,54,32,23};
        for(int i:arr)
        System.out.println(i);
        for (int i = 0; i < arr.length; i++)   
        {  
        for (int j = i + 1; j < arr.length; j++)   
        {  
        int tmp = 0;  
        if (arr[i] < arr[j])   
        {  
        tmp = arr[i];  
        arr[i] = arr[j];  
        arr[j] = tmp;  
        }  
        }
    }
    System.out.println("Highest temp:"+arr[0]);
} 
}
