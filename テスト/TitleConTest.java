package minipro2;

import org.junit.Before;
import org.junit.Test;

public class TitleConTest {
	TitleCon titleCon;
	TitleList titleList;
	ReviewMap reviewMap;
	ReviewList reviewList;
	Title title;
	int titleNo;
	
	@Before
	public void setup() {
		reviewMap = new ReviewMap();
		titleList = new TitleList(reviewMap);
		titleCon = new TitleCon(titleList);
		reviewList = new ReviewList("abc", 1);
		titleNo = reviewList.getTitleNo();
		reviewMap.setTitle(titleNo, reviewList);
	}
	
	@Test
	public void Test_addTitle1() {
		titleCon.addTitle("キングダム");
	}
	
	@Test
	public void Test_addTitle2() {
		titleCon.addTitle("ワンピース");
	}
	
}
