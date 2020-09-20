package Chap20_AppendixB;

/**
 * 2013.04.22
 * Michel
 */
public class HfjEnum {
	enum Names{
		JERRY("lead guitar"){
			public String sings(){
				return "plaintively";
			}
		},
		BOBBY("rhythm guitar"){
			public String sings(){
				return "hoarsely";
			}
		},
		PHIL("bass");
		
		private String instrument;
		
		Names(String instrunment){
			//这是enum的构造函数
			//会对每个被声明的enum值执行一次
			this.instrument = instrunment;
		}

		public String getInstrument() {
			return this.instrument;
		}
		
		public String sings(){
			return "occasionally";
		}
	}
	
	public static void main(String[] args){
		for(Names n : Names.values()){
			System.out.print(n);
			System.out.print(", instrument: " + n.getInstrument());
			System.out.println(", sings: " + n.sings());
		}
	}
}
