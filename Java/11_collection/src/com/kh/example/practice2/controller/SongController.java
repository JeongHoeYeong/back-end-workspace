package com.kh.example.practice2.controller;

import java.util.ArrayList;
import java.util.Collections;

import com.kh.example.practice2.model.Song;

public class SongController {
	ArrayList<Song> list = new ArrayList<>();
	
	public boolean behind(String song, String singer) {
		try{
			return list.add(new Song(song, singer));
		} catch (Exception e) {
			return false;
		}
		
	}
	
	public boolean front(String song, String singer) {
		try {
			list.add(0, new Song(song, singer));
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	public ArrayList<Song> printAll() {
		return list;
	}
	
	public Song print(String song) {
		for(Song li : list) {
			if(li.getSongName().equals(song)) {
				return li;
			}
		}
		return null;
	}
	public Song remove(String song) {
		for(Song li : list) {
			if(li.getSongName().equals(song)) {
				list.remove(li);
				return li; 
			}
		}
		return null;
	}

	public Song set(String song, String title, String setSinger) {
		for (int i = 0; i < list.size(); i++) {
			if (song.equals(list.get(i).getSongName())) {
				Song before = list.get(i);
				list.set(i, new Song(title, setSinger));
				return before;
			}

		}
		return null;
	}
	public ArrayList<Song> songAsc() {
		Collections.sort(list);
		return list;
	}
	
	public void singerDesc() {
		
	}
}
