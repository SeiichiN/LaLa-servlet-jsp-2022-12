package model;

public class SiteEVLogic {
	// SiteEV -- 参照わたし
	public void like(SiteEV site) {
		int count = site.getLike(); // 今のいいねの数
		site.setLike(count + 1);  // 新しいいいねの数
	}
	public void dislike(SiteEV site) {
		int count = site.getDislike();
		site.setDislike(count + 1);
	}
}
