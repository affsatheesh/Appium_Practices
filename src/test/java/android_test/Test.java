package android_test;

import java.time.Year;
import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		
		String currentMonth ="AUGUST".toLowerCase();
		
        System.out.println(fetchMonthDetails(currentMonth));
		
		int navigateTo =5;
		
	
		int number=0;
		
		for(int i=number;i<=0;i++)
		{
		
		if(Integer.valueOf(fetchMonthDetails(currentMonth)) >= navigateTo)
		{
			System.out.println("back to oneTime");
		number++;
		}
		else {
			System.out.println("front to oneTime");
		}
		}
		
		//System.out.println(fetchMonthDetails(navigateTo));
		
//		int year =2027;
//		Year currentYear = Year.now();
//        System.out.println("Current Year: " + currentYear.getValue());
//        int currentYearIs = currentYear.getValue();
//        if(currentYearIs >year) {
//           System.out.println("its greater");
//           for(int i=currentYearIs;i>=year;i--)
//           {
//        	   System.out.println(i);
//           }
//        }else {
//        	
//        	System.out.println("its lesser");
//             for(int i=currentYearIs;i<=year;i++)
//             {
//          	   System.out.println(i);
//             }
//        }
//
	}
	
	public static String fetchMonthDetails(String keyOrValue)
	{
        Map<Integer, String> monthMap = new HashMap<>();
        
        monthMap.put(1, "January");
        monthMap.put(2, "February");
        monthMap.put(3, "March");
        monthMap.put(4, "April");
        monthMap.put(5, "May");
        monthMap.put(6, "June");
        monthMap.put(7, "July");
        monthMap.put(8, "August");
        monthMap.put(9, "September");
        monthMap.put(10, "October");
        monthMap.put(11, "November");
        monthMap.put(12, "December");
        
  
        try {
            int key = Integer.parseInt(keyOrValue);
            return monthMap.get(key);
        } catch (NumberFormatException e) {
            for (Map.Entry<Integer, String> entry : monthMap.entrySet()) {
                if (entry.getValue().equalsIgnoreCase(keyOrValue)) {
                    // Return the corresponding month number as a string
                    return String.valueOf(entry.getKey());
                }
            }
        }

        return "No matching month found!";
	}
}
