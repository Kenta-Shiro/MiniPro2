package minipro3;

import java.util.List;

public class TitleCon {

	private TitleList titleList;

	public TitleCon(TitleList titleList) {
		this.titleList = titleList;
	}
	
	public void addTitle(String title) {
		List<Title> tempList = titleList.getTitleList();
		//判定
		for(Title temp:tempList) {
			if(title.equals(temp.getTitle())) {
				System.out.println("タイトルが重複しています");
				return;
			}
		}
		//return titleList;
		titleList.makeTitle(title);
		System.out.println("タイトルが追加されました");
		System.out.println("");
	}

}
