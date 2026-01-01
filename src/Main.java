public class Main {
    public static void main(String[] args) {

        MediaLibrary library = new MediaLibrary();

        library.add(new Book("1984", "George Orwell", 328, 4.7));
        library.add(new Book("Animal Farm", "George Orwell", 112, 4.5));
        library.add(new Movie("Inception", "Christopher Nolan", 148, 4.6));
        library.add(new Movie("Interstellar", "Christopher Nolan", 169, 4.8));
        library.add(new Album("Thriller", "Michael Jackson", 42, 4.9));
        library.add(new Album("Back in Black", "AC/DC", 41, 4.4));

        System.out.println("Library size: " + library.size());
        System.out.println();

        System.out.println("Titles by George Orwell:");
        System.out.println(library.titlesByCreator("George Orwell"));
        System.out.println();

        System.out.println("Top 3 titles by rating:");
        System.out.println(library.topTitlesByRating(3));
        System.out.println();

        System.out.println("Count by media type:");
        System.out.println(library.countByType());
        System.out.println();

        System.out.println("Average movie length:");
        System.out.println(library.averageLengthForType("Movie"));
        System.out.println();

        System.out.println("Media with rating >= 4.7:");
        for (MediaItem m : library.filterByRating(4.7)) {
            System.out.println(m.getTitle() + " (" + m.getRating() + ")");
        }
    }
}

