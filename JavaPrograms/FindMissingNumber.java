package JavaPrograms;

import java.util.Arrays;

public class FindMissingNumber {
	
	public void findMissingElemnt(){
		int nums[]= {1,4,3,2,8,6,7};
	    Arrays.sort(nums);
	    System.out.println("Missing Element:");
	    for (int i=0; i<nums.length; i++) {
	    	if(nums[i]!=i+1)
	    	{
	    		System.out.println(i+1);
	    		break;
	    	}
	}
	
	}
	public static void main(String[] arg)
	{
		FindMissingNumber fn = new FindMissingNumber();
		fn.findMissingElemnt();
	}

}
