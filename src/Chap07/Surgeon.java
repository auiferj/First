package Chap07;

/**
 * 2013.03.26
 * Michel
 */
public class Surgeon extends Doctor {
	public void treatPatient(){
		super.treatPatient();   //执行父类方法
		
		//进行手术
		System.out.println("进行手术");
	}
	void makeIncision(){
		//截肢（好恶心！）
		System.out.println("截肢");
	}
	
	public static void main(String[] args){
		Surgeon s = new Surgeon();
		s.workAtHospital = false;
		s.treatPatient();
		s.makeIncision();
	}
}
