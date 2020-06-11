package minipro2;

import java.util.ArrayList;
import java.util.List;

public class TitleList {

	private List<Title> titleList = new ArrayList<Title>();
	private ReviewMap reviewMap;

	public TitleList(ReviewMap reviewMap) {
		Title title1 = new Title("ワンピース");
		titleList.add(title1);


		this.reviewMap = reviewMap;
	}

	public void makeTitle(String title) {
		Title newTitle = new Title(title);

		titleList.add(newTitle);

		int newTitleNo = newTitle.getTitleNo();
		reviewMap.makeReviewList(title, newTitleNo);// reviewMapとtitleListの関連

	}

	public void setTitleList(Title title) {
		titleList.add(title);

	}

	public List<Title> getTitleList() {
		return titleList;
	}

}
