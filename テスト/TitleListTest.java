package minipro2;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TitleListTest {
	TitleList titleList;
	ReviewMap reviewMap;
	ReviewList reviewList;
	Title title;
	int titleNo;

	@Before
	public void setup() {
		reviewMap = new ReviewMap();

		titleList = new TitleList(reviewMap);
		reviewList = new ReviewList("abc", 1);
		titleNo = reviewList.getTitleNo();
		reviewMap.setTitle(titleNo, reviewList);
	}

	@Test
	public void Test_TitleList() {
		Title t1 = new Title("abc");
		titleList.setTitleList(t1);
		Title expected_TitleList = t1;
		List<Title> actual = titleList.getTitleList();

		assertThat(actual, hasItem(expected_TitleList));
	}

	@Test
	public void Test_MakeTitle() {
		titleList.makeTitle("キングダム");
		String expected_MakeTitle = "キングダム";
		String actual = titleList.getTitleList().get(2).getTitle();

		assertThat(actual, is(expected_MakeTitle));
	}

}
