package tw.banana.tutor;

public class Banana05 {

	public static void main(String[] args) {
		// 0 ~ 100
		//brad@brad.tw
		double temp = Math.random();
		System.out.println(temp);
		
		int score = (int)(temp*101);
		System.out.println(score);
		
		if(score >= 90) {
			System.out.println("A");
		}else if(score >= 80) {
			System.out.println("B");
		}else if(score >= 70) {
			System.out.println("C");
		}else if(score >= 60) {
			System.out.println("D");
		}else {
			System.out.println("E");}
		
		if (score >= 60) {
		    if (score >= 70) {
		        if (score >= 80) {
		            if (score >= 90) {
		                System.out.println("A");
		            } 
		            else {
		                System.out.println("B");
		            }
		        } else {
		            System.out.println("C");
		        }
		    } else {
		        System.out.println("D");
		        }
			}
		else {
			System.out.println("E");
		}
		
	}	
}
