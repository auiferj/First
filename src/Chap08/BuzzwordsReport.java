package Chap08;

/**
 * 2013.03.26
 * Michel
 */
public class BuzzwordsReport extends Report {
	
	void runReport(){
		super.runReport();   //调用父类runReport方法
		buzzwordCompliance();
		printReport();
	}
	
	void buzzwordCompliance(){
		System.out.println("do buzzwordCompliance");
	} 
}
