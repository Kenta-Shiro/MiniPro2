package minipro3;

public class Title {
	// タイトル名
	private String titleName;
	// タイトル番号
	private int titleNo;
	// タイトルが生成されるたびに1増える変数
	private static int titleID = 1;

	public Title(String titleName) {
		this.titleName = titleName;
		titleNo = titleID;
		titleID++;
	}

	public String getTitle() {
		return titleName;
	}

	public int getTitleNo() {
		return titleNo;
	}

}
