package punisher;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestCriminalSort {

	@Test
	public void test() {
		Criminal leader = Criminal.builder().level(LevelEnum.LEADER.getLabel()).build();
		
		assertTrue(CriminalSort.LEVEL.compare(leader, leader) ==0);
		
		Criminal counselor =  Criminal.builder().level(LevelEnum.COUNSELOR.getLabel()).build();
		assertTrue(CriminalSort.LEVEL.compare(counselor, leader) >0);
		assertTrue(CriminalSort.LEVEL.compare(leader,counselor ) <0);
		
		Criminal sergeant = Criminal.builder().level(LevelEnum.SERGEANT.getLabel()).build();
		assertTrue(CriminalSort.LEVEL.compare(counselor, sergeant) <0);
		assertTrue(CriminalSort.LEVEL.compare(sergeant,counselor ) >0);
		assertTrue(CriminalSort.LEVEL.compare(sergeant, leader) >0);
		assertTrue(CriminalSort.LEVEL.compare(leader,sergeant ) <0);
		
		
		Criminal badass = Criminal.builder().level(LevelEnum.BADASS.getLabel()).build();

		assertTrue(CriminalSort.LEVEL.compare(counselor, badass) <0);
		assertTrue(CriminalSort.LEVEL.compare(badass,counselor ) >0);
		assertTrue(CriminalSort.LEVEL.compare(badass, sergeant) >0);
		assertTrue(CriminalSort.LEVEL.compare(sergeant,badass ) <0);
		assertTrue(CriminalSort.LEVEL.compare(badass, leader) >0);
		assertTrue(CriminalSort.LEVEL.compare(leader,badass ) <0);
		
	}

}
