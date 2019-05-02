package linkedListChallenge;

public class Song {
	private String songTitle;
	private double duration;
	
	public Song(String songTitle, double duration) {
		this.songTitle = songTitle;
		this.duration = duration;
	}

	public String getSongTitle() {
		return songTitle;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.songTitle + ": " + this.duration;
	}
	
	
	
	

}
