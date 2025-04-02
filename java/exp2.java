// package exp2;
import java.util.Arrays;
class Video {
 String title;
 boolean isCheckedOut;
 int userRating;
 Video(String title) {
 this.title = title;
 isCheckedOut = false;
 userRating = 0;
 }
 void beingCheckedOut() {
 isCheckedOut = true;
 }
 void beingReturned() {
 isCheckedOut = false;
 }
 void receiveRating(int rating) {
 userRating = rating;
 }
}
class VideoStore {
 Video[] inventory = new Video[10];
 int videoCount = 0;
 void addVideo(String title) {
 if (videoCount < inventory.length) {
 inventory[videoCount++] = new Video(title);
 } else {
 System.out.println("Cannot add more videos. Inventory is full.");
 }
 }
 void listInventory() {
 System.out.println("Available videos:");
 for (int i = 0; i < videoCount; i++) {
 Video video = inventory[i];
 if (!video.isCheckedOut) {
 System.out.println(video.title + " (Rating: " + video.userRating +
")");
 }
 }
 }
 void rentVideo(String title) {
 for (int j = 0; j < videoCount; j++) {
 if (inventory[j].title.equals(title) && !inventory[j].isCheckedOut) {
 inventory[j].beingCheckedOut();
 System.out.println("Video rented: " + title);
 return;
 }
 }
 System.out.println("Video not found or already checked out: " + title);
 }
 void returnVideo(String title) {
 for (int j = 0; j < videoCount; j++) {
 if (inventory[j].title.equals(title) && inventory[j].isCheckedOut) {
 inventory[j].beingReturned();
 System.out.println("Video returned: " + title);
 return;
 }
 }
 System.out.println("Video not found or not checked out: " + title);
 }
 void giveRating(String title, int rating) {
 for (int j = 0; j < videoCount; j++) {
 if (inventory[j].title.equals(title)) {
 inventory[j].receiveRating(rating);
 System.out.println("Rating given to " + title + ": " + rating);
 return;
 }
 }
 System.out.println("Video not found: " + title);
 }
}
public class exp2 {
 public static void main(String[] args) {
 VideoStore store = new VideoStore();
 Arrays.fill(store.inventory, null);
 store.addVideo("Aarya");
 store.addVideo("Ramesh");
 store.addVideo("Harshit");
 store.listInventory();
 store.rentVideo("Aarya");
 store.rentVideo("Ramesh");
 store.rentVideo("Harshit");
 store.listInventory();
 store.giveRating("Aarya", 4);
 store.giveRating("Ramesh", 3);
 store.giveRating("Harshit", 5);
 store.returnVideo("Aarya");
 store.returnVideo("Ramesh");
 store.returnVideo("Harshit");
 store.listInventory();
 }
}// 21BCS2487_Aarya Kapoor