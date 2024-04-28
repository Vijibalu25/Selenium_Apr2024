package JavaPrograms;

public class FindIntersection {
	
	public static void main(String[] args)
	{
		int a[]= {3,2,11,4,6,7};
		int b[]= {1,2,8,4,9,7};
		
		int arr1 = a.length;
		int arr2=b.length;
		
		for(int i=0; i<=arr1-1; i++)
		{
			for(int j=0; j<=arr2-1; j++)
				if(a[i]==b[j])
				{
					System.out.println(a[i]);
				}
		}
	}

}
