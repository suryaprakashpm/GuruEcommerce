package liveECommercesiteTesting;

import junit.framework.Assert;

public class Calc {

	
	public int add(int n1, int n2){
		
		int resutl = n1+n2;
		
		return resutl;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Calc calc= new Calc();
int result=calc.add(2,3);


	}

}
