package Chap07;

/**
 * 2013.03.26
 * Michel
 */
public class FamilyDoctor extends Doctor {
	boolean makesHouseCalls;
	void giveAdvice(){
		//提出诊断
		System.out.println("提出诊断");
	}
	
	public static void main(String[] args){
		FamilyDoctor d = new FamilyDoctor();
		d.workAtHospital = false;
		d.treatPatient();
		d.giveAdvice();
	}
}
