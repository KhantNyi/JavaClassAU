// Name - Khant Nyi Thu
// ID - 6632108
// Section - 541

package Week05;

public class MyTimeDriver {
    public static void main(String[] args) {
        
        MyTime time1 = new MyTime(12, 5, 14);
        System.out.println("12:05:14 in 12-hour format is: " + time1.to12HourFormat());
        
        MyTime time2 = new MyTime(0, 0, 0);
        System.out.println("00:00:00 in 12-hour format is: " + time2.to12HourFormat());
        
        System.out.println();
        
        MyTime time3 = new MyTime(13, 5, 58);
        System.out.println("1:05:58 PM in 24-hour format is: " + time3.to24HourFormat());
        
        MyTime time4 = new MyTime(23, 59, 59);
        System.out.println("11:59:59 PM in 24-hour format is: " + time4.to24HourFormat());
    }
}
