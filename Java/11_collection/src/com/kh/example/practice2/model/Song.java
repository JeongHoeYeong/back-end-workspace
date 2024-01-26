package com.kh.example.practice2.model;

public class Song implements Comparable<Song>{
	private String title;
	private String singer;
	
	public Song() {
	}
	public Song(String songName, String singer) {
		this.title = songName;
		this.singer = singer;
	}
	public String getSongName() {
		return title;
	}
	public void setSongName(String songName) {
		this.title = songName;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	@Override
	public int compareTo(Song o) {
		return this.title.compareTo(o.title);
	}
	
	@Override
	public String toString() {
		return singer + ":" + title;
	}
}
