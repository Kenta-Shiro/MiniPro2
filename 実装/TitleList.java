package minipro2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TitleList {

	private List<Title> titleList = new ArrayList<Title>();
	private ReviewMap reviewMap;
	
	public TitleList(ReviewMap reviewMap) {
		Title title1 = new Title("ワンピース");
		Title title2 = new Title("");
		titleList.add(title1);
		titleList.add(title2);
		
		this.reviewMap = reviewMap;
	}

	public void makeTitle(String title) {
		Title newTitle = new Title(title);
		
		titleList.add(newTitle);
		
		int newTitleNo = newTitle.getTitleNo();
		reviewMap.makeReviewMap(title,newTitleNo);//reviewMapとtitleListの関連

	}

	public List<Title> getTitleList() {
		return titleList;
	}

}
