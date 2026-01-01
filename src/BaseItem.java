public abstract class BaseItem implements MediaItem {

    private static int counter = 0;

    private final String id;
    private final String title;
    private final String creator;
    private final int length;
    private final double rating;

    protected BaseItem(String title, String creator, int length, double rating) {
        this.id = String.format("MI%03d", counter++);

        this.title = title;
        this.creator = creator;

        // Defensive validation
        this.length = Math.max(0, length);

        double r = rating;
        if (r < 0.0) r = 0.0;
        else if (r > 5.0) r = 5.0;
        this.rating = r;
    }

    @Override
    public String getId() { return id; }

    @Override
    public String getTitle() { return title; }

    @Override
    public String getCreator() { return creator; }

    @Override
    public int getLength() { return length; }

    @Override
    public double getRating() { return rating; }
}

