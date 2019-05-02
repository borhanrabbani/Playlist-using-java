package linkedListChallenge;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class MainPlaylist {
	
	private static ArrayList<Album> albums = new ArrayList<Album>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printMenu();
		
		Album album = new Album("Elvis Presley", "Elvis Presley");
		album.addSong("Can't help falling in love", 3.5);
		album.addSong("Suspicious Minds", 4.0);
		album.addSong("Jailhouse Rock", 4.3);
		album.addSong("Hound Dog", 4.6);
		album.addSong("Love Me Tender", 4.0);
		album.addSong("Always on my mind", 4.2);
		
		albums.add(album);
		
		album = new Album("Best of James", "James");
		album.addSong("Ma", 6.3);
		album.addSong("Baba", 4.5);
		album.addSong("Nondini", 5);
		album.addSong("Bangladesh", 6.5);
		album.addSong("Kobita", 4.2);
		album.addSong("Valentine", 5.2);
		album.addSong("Aziz boading", 4.3);
		
		albums.add(album);
		
		LinkedList<Song> playList = new LinkedList<Song>();
		albums.get(0).addToPlayList("Can't help falling in love", playList);
		albums.get(0).addToPlayList("Hound Dog", playList);
		albums.get(0).addToPlayList("Are you lonesome", playList);
		albums.get(1).addToPlayList("Bangladesh", playList);
		albums.get(1).addToPlayList(5, playList);
		albums.get(1).addToPlayList(3, playList);

		play(playList);
		
		
		
		
	}

	private static void play(LinkedList<Song> playList) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		boolean quit = false;
		boolean forward = true;
		ListIterator<Song> listIterator = playList.listIterator();
		if(playList.size()==0){
			System.out.println("No songs in playlist");
			return;
		}else{
			System.out.println("Now playing " + listIterator.next().toString());
		}
		
		while(!quit){
			int action = sc.nextInt();
			sc.nextLine();
			
			switch(action){
			case 0:
				System.out.println("Playlist complete");
				quit = true;
				break;
			case 1:
				if(!forward){
					if(listIterator.hasNext()){
						listIterator.next();
					}
					forward = true;
				}
				if(listIterator.hasNext()){
					System.out.println("Now playing: " + listIterator.next().toString());
				}else{
					System.out.println("We have reached at the end of the list");
					forward = false;
				}
				break;
			case 2:
				if(forward){
					if(listIterator.hasPrevious()){
						listIterator.previous();
					}
					forward = false;
				}
				if(listIterator.hasPrevious()){
					System.out.println("Now playing: "+ listIterator.previous().toString());
				}else{
					System.out.println("We are at the start of the list");
					forward=true;
				}
				break;
			case 3:
				if(forward){
					if(listIterator.hasPrevious()){
						System.out.println("Now replaying: " + listIterator.previous().toString());
						forward = false;
					}else{
						System.out.println("We are at the start of the list");
					}
				}else{
					if(listIterator.hasNext()){
						System.out.println("Now replaying: "+ listIterator.next().toString());
						forward=true;
					}else{
						System.out.println("We are at the end of the list");
					}
				}
				break;
			case 4:
				printList(playList);
				break;
			case 5:
				printMenu();
				break;
			case 6:
				if(playList.size() >0){
					listIterator.remove();
					if(listIterator.hasNext()){
						System.out.println("Now playing: " + listIterator.next());
					}else if(listIterator.hasPrevious()){
						System.out.println("Now playing: "+ listIterator.previous());
					}else{
						System.out.println("your playlist is empty");
					}
				}
				break;
			}
		}
	}

	private static void printList(LinkedList<Song> playList) {
		// TODO Auto-generated method stub
		Iterator<Song> iterator = playList.iterator();
		System.out.println("=============================");
		while(iterator.hasNext()){
			System.out.println(iterator.next().toString());
		}
		System.out.println("==============================");
	}

	private static void printMenu() {
		// TODO Auto-generated method stub
		System.out.println("Available actions:\nPress");
		System.out.println("0 - to quit\n" +
					"1 - to play next song\n" + 
					"2 - to play previous song\n" + 
					"3 - to replay the current song\n" +
					"4 - list songs in the playlist\n"+
					"5 - print available actions\n"+
					"6 - delete current song from list");
	}
	
	

}
