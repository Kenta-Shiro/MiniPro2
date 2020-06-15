package minipro;

import java.util.List;

import DAO.TitleDAO;

public class TitleCon {

	private TitleDAO titleDAO;

	public TitleCon(TitleDAO titleDAO) {
		this.titleDAO = titleDAO;
	}

	public void addTitle(String title) {
		List<Title> tempList = titleDAO.getTitleList();
		// 判定
		for (Title temp : tempList) {
			if (title.equals(temp.getTitle())) {
				System.out.println("タイトルが重複しています");
				return;
			}
		}
		// return titleList;
		titleDAO.setTitle(title);
		System.out.println("タイトルが追加されました");
		System.out.println("");
	}

}
