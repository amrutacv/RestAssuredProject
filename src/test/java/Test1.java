import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class Test1 {
	public static void main(String[] args) {
        
        int count = 0;
        int num =2;
        
        while(count<50){
            if(isPrime(num)){
                System.out.println(num);
                count++;
            }
            num++;
            
        }
    }
    
    public static boolean isPrime(int num){
        
        if(num>2){
            for(int i=2;i<=num/2;i++){
                if(num%i==0){
                    return false;
                }
            }
        }
        return true;
    }
	//public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int num = 10;
//		try {
//			
//			int i=num/0;
//			System.out.println(i);
//		}catch(Exception e) {
//			System.out.println("in try");
//			try {
//				int i=num/0;
//			}catch(ArithmeticException e1) {
//				System.out.println("in try");
//			}
//		}
//		finally {
//			System.out.println("In Finally");
//		}
//		
//		List<String> list=new LinkedList<String>();  
//		list.add("1");
//		list.add("2");
//		list.add("1");
//		for(int i=0;i<list.size();i++) {
//			for(int j=i+1;j<list.size();j++) {
//				if(list.get(i).equals(list.get(j))) {
//					list.remove(i);
//				}
//			}
//		}
//		System.out.println(list);
//		for(int i=1;i<=100;i++){
//		    if(checkPrime(i)){
//		        System.out.print(i+" " );
//		    }
//		}
//	}
//	public static boolean checkPrime(int num){
//	    
//	   // 0, 1 and negative numbers are not prime
//	    if(num<2){
//	        return false;
//	    }
//	    else{
//	        // no need to run loop till num-1 as for any number x the numbers in
//    // the range(num/2 + 1, num) won't be divisible anyways. 
//    // Example 36 wont be divisible by anything b/w 19-35
//	        int x= num/2;
//	        for(int i=2;i<=x;i++){
//	            if(num%i==0){
//	                return false;
//	            }
//	        }
//	    }
//	    // the number would be prime if we reach here
//	    return true;
	//}
}
