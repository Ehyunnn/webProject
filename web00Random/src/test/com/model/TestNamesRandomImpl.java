package test.com.model;

import java.util.Random;

public class TestNamesRandomImpl implements TestNamesRandom {

	Random r = new Random();
	
	@Override
	public String getRandomName(TestNames tn) {
		
		String name = null;
		for (int i = 0; i < tn.getNames().length; i++) {
			int su = r.nextInt(tn.getNames().length);
			System.out.println("Random su:"+su);
			System.out.println("Random name:"+tn.getNames()[su]);
			if(i==tn.getNames().length-1) {
				name = tn.getNames()[su];
			}
		}
		return name;
	}

}
