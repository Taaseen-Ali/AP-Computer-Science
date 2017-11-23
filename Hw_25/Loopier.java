//Taaseen Ali
//APCS1 pd1
//HW25-- All Hallow's Eve
//2017-11-1   

import java.util.Random;
import java.util.Arrays;
public class Loopier{	
	public static int[] fill(int[] nums){
		Random r = new Random();
		for(int i=0; i<nums.length; i++){
			nums[i] = r.nextInt(100);
		}
		return nums;
    }

    public static String getArrayString(int[] nums){
		String retStr = "[";
		for(int num:nums){
			retStr += num + " ";
		}
		return retStr+ "]";
    }

	public static int linSearch(int[] a, int target){
		for(int i=0; i<a.length; i++){
			if(a[i] == target) return i;
		}
		return -1;
    } 
	
	public static int linSearchR(int[] a, int target){
		if (a.length == 0){
			return -1;
		}
		if (a[0] == target){
			return 0;
		}
		else{
			if (linSearchR(Arrays.copyOfRange(a, 1, a.length), target) == -1){
				return -1;
			}
			else {
				return linSearchR(Arrays.copyOfRange(a, 1, a.length), target) + 1;
			}
		}
	}

	public static int freq(int[] a, int target){
		int freq = 0;
		for (int x : a){
			if (x == target){
				freq +=1;
			}
		}
		return freq;
	}
	
	public static int freqR(int[] a, int target){

		if (a.length ==0){
			return 0;
		}

		if (a[0] == target){
			return freqR(Arrays.copyOfRange(a, 1, a.length), target) + 1;
		}
		else{
			return freqR(Arrays.copyOfRange(a, 1, a.length), target);
		}

	}
	
	public static void main(String args[]){
		int [] arr = new int[10];
		int [] arr2 = {5,4,3,2,1,0,1,2,3};
		System.out.println(Loopier.fill(arr));
		System.out.println(Loopier.getArrayString(arr));
		System.out.println(Loopier.getArrayString(Loopier.fill(new int[] {0,0,0,0,1})));
		System.out.println(Loopier.linSearch(arr2, 1));
		System.out.println(Loopier.linSearchR(arr2, 697));
		System.out.println(Loopier.freq(arr2, 3));
		System.out.println(Loopier.freq(arr2, 99));
		System.out.println(Loopier.freqR(arr2, 3));
		System.out.println(Loopier.freqR(arr2, 99));
	}
}