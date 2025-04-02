import java.util.Scanner;
import java.util.Arrays;

class Video {
    private String title;
    private boolean checkedOut;
    private double averageRating;

    public Video(String title) {
        this.title = title;
        this.checkedOut = false;
        this.averageRating = 0.0;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void checkOut() {
        checkedOut = true;
    }

    public void returnVideo() {
        checkedOut = false;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void receiveRating(int rating) {
        averageRating = (averageRating + rating) / 2.0;
    }
}

class VideoStore {
    private Video[] inventory;

    public VideoStore() {
        this.inventory = new Video[10];
    }

    public void addVideo(String title) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] == null) {
                inventory[i] = new Video(title);
                break;
            }
        }
    }

    public void checkOut(String title) {
        for (Video video : inventory) {
            if (video != null && video.getTitle().equals(title) && !video.isCheckedOut()) {
                video.checkOut();
                break;
            }
        }
    }

    public void returnVideo(String title) {
        for (Video video : inventory) {
            if (video != null && video.getTitle().equals(title) && video.isCheckedOut()) {
                video.returnVideo();
                break;
            }
        }
    }

    public void receiveRating(String title, int rating) {
        for (Video video : inventory) {
            if (video != null && video.getTitle().equals(title)) {
                video.receiveRating(rating);
                break;
            }
        }
    }

    public void listInventory() {
        System.out.println("Inventory:");
        for (Video video : inventory) {
            if (video != null) {
                System.out.println("Title: " + video.getTitle() +
                        ", Checked Out: " + (video.isCheckedOut() ? "Yes" : "No") +
                        ", Average Rating: " + video.getAverageRating());
            }
        }
    }

    public int getRatingFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter rating (1-5): ");
        int rating = scanner.nextInt();

        // Validate rating (assuming it should be between 1 and 5)
        while (rating < 1 || rating > 5) {
            System.out.println("Invalid rating. Please enter a rating between 1 and 5.");
            System.out.print("Enter rating (1-5): ");
            rating = scanner.nextInt();
        }
        
        return rating;
    }
}

public class VideoStoreLauncher {
    public static void main(String[] args) {
        VideoStore videoStore = new VideoStore();

        // Add videos
        videoStore.addVideo("The Matrix");
        videoStore.addVideo("Godfather II");
        videoStore.addVideo("Star Wars Episode IV: A New Hope");

        // Give ratings using user input
        System.out.println ("Enter the rating for movie - The Matrix: ");
        videoStore.receiveRating("The Matrix", videoStore.getRatingFromUser());
        System.out.println ("Enter the rating for movie - The Matrix: ");
        videoStore.receiveRating("The Matrix", videoStore.getRatingFromUser());
        System.out.println ("Enter the rating for movie - Godfather II: ");
        videoStore.receiveRating("Godfather II", videoStore.getRatingFromUser());
        System.out.println ("Enter the rating for movie - Godfather II: ");
        videoStore.receiveRating("Godfather II", videoStore.getRatingFromUser());
        System.out.println ("Enter the rating for movie - Star Wars Episode IV: A New Hope: ");
        videoStore.receiveRating("Star Wars Episode IV: A New Hope", videoStore.getRatingFromUser());

        // Rent and return videos
        videoStore.checkOut("The Matrix");
        videoStore.returnVideo("The Matrix");

        videoStore.checkOut("Godfather II");

        // List inventory
        videoStore.listInventory();
        
    }
}