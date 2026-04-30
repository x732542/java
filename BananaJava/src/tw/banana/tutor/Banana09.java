package tw.banana.tutor;

public class Banana09 {
	public static void main(String[] args) {
		double temp = Math.random();
		int year = (int)( temp * 2026);
		boolean isLeap = false;
		if(year % 4 ==0) {
			if(year % 100 ==0) {
				if(year % 400 ==0) {
						isLeap =true;
				} else {
					isLeap = false;
				}
			} else {
				isLeap = true;
			}
		} else {isLeap=false;
		}
		System.out.printf("%d是%s年\n",year,isLeap?"潤":"平");
		
	
		if(year % 400 ==0 || (year % 4 == 0 && year % 100 != 0)) {
			isLeap = true;
		}else { isLeap = false;
		}
		
		if (year % 400 == 0) {
			System.out.println("閏年\n");
			isLeap =true;
		}
		else if( year % 100 == 0) {
			System.out.println("平年\n");
			}
		else if (year % 4 == 0) {
			System.out.println("潤年\n");
			isLeap = true;
			}
		else 
			System.out.println("平年\n");

		System.out.printf("%d是%s年\n",year,isLeap?"潤":"平");
	}}

