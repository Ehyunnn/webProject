package test.com.random;

import java.util.Random;

import test.com.model.TestNames;
import test.com.model.TestNamesRandom;
import test.com.model.TestNamesRandomImpl;

public class TestRandom {

	public static void main(String[] args) {
		System.out.println("Random...Math..object");
		
		String[] names = new String[] {
			"김남은","김윤성","박이현","신현명",
			"이동준","이세희","장재광","정은아","조상묵",
			"진형기","최준형","한수진","최태용","곽찬양"
		};
		
		TestNamesRandom tnr = new TestNamesRandomImpl();
		TestNames tn = new TestNames();
		tn.setNames(names);
		String name = tnr.getRandomName(tn);
		System.out.println("============");
		System.out.println("당첨:"+name);
		System.out.println("============");
		
		
	}

}
