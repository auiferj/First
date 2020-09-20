package Chap10;
 
/**
 * 2013.03.28
 * Michel
 */
import java.util.Date;
import java.util.Calendar;
public class TestFormats {
	public static void main(String[] args){
		//String.format(format, args)
		String s = String.format("%,d", 1000000000);
		System.out.println(s);
		
		//格式化输出方法与C语言里类似，略看
		String s2 = String.format("I have %,.2f bugs to fix.", 476578.09876);
		System.out.println(s2);
		
		//decimal(十进制)  参数:int
		System.out.println(String.format("%d",42));
		
		//floating point 参数:浮点数
		System.out.println(String.format("%.3f",42.000000));
		
		//hexadecimal(十六进制) 参数: byte, short, int, long, BigInteger
		System.out.println(String.format("%x",42));
		
		//character 参数:byte, short, int, long
		System.out.println(String.format("%c",42));
		
		//一个以上的参数
		int one = 20456654;
		double two = 100567890.248907;
		String s3 = String.format("The rank is %,d out of %,.2f",one,two);
		System.out.println(s3);
		
		//时间和日期
		//完整的日期与时间: %tc
		System.out.println(String.format("%tc", new Date()));
		
		//只有时间: %tr
		System.out.println(String.format("%tr", new Date()));
		
		//周、月、日： %tA %tB %td
		Date today = new Date();
		System.out.println(String.format("%tA, %tB %td",today,today,today));
		// 同上，另一种写法。"<"用来告诉格式化程序重复利用之前用过的参数
		System.out.println(String.format("%tA, %<tB %<td",today));  
		
		//Calendar是个抽象类
		//Calendar cal = new Calendar(); //error : Cannot instantiate the type Calenda
		//用这个静态方法：
		Calendar c = Calendar.getInstance();
		c.set(2004,1,7,15,40);  //2004.1.7 15:40
		System.out.println("time now: " + c.getTime());
		
		long day1 = c.getTimeInMillis();  //将目前时间转换成以毫秒表示
		day1 += 1000*60*60;   
		c.setTimeInMillis(day1);  //时间加1小时
		System.out.println("new hour " + c.get(c.HOUR_OF_DAY));
		
		c.add(c.DATE,35);     //加35天
		System.out.println("add 35 days "+ c.getTime());
		
		c.roll(c.DATE, 35);
		System.out.println("roll 35 days " + c.getTime()); //日期滚动35天，月份不动。
		
		c.set(c.DATE,1);  //直接设置DATE的值
		System.out.println("set to 1 " + c.getTime());
 		
	}
}
