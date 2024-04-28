package JavaPrograms;

public class FibonacciSeries {
	
	public static void main(String [] args)
	
	{
		int firstNum= 0;
		int secNum = 1;
		int sum=0;
		System.out.println(" Fibonacci Series :");
		System.out.println(firstNum);
		
		for(int i=0; i<7;i++)
		{
			
			firstNum=secNum;
			secNum=sum;
			sum =firstNum+secNum;
			System.out.println(sum);
		}
	}

}
