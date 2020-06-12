package minipro2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import minipro2.ReviewList;

public class TitleList {

	private List<Title> titleList = new ArrayList<Title>();
	private ReviewMap reviewMap;

	public TitleList(ReviewMap reviewMap) {
		String t1 ="ワンピース";
		Title title1 = new Title(t1);
		titleList.add(title1);

		this.reviewMap = reviewMap;
		
		HashMap<Integer, ReviewList> rm = this.reviewMap.getReviewMap();
		
		ReviewList newlist1 = new ReviewList(t1, title1.getTitleNo());
		rm.put(0, newlist1);
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
