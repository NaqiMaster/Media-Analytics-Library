import java.util.*;

public class MediaLibrary implements Iterable<MediaItem> {

    private final ArrayList<MediaItem> items = new ArrayList<>();

    public void add(MediaItem m) {
        if (m != null) items.add(m);
    }

    public int size() {
        return items.size();
    }

    public ArrayList<String> titlesByCreator(String creator) {
        ArrayList<String> result = new ArrayList<>();
        if (creator == null) return result;

        for (MediaItem m : items) {
            if (creator.equals(m.getCreator())) {
                result.add(m.getTitle());
            }
        }
        return result;
    }

    public ArrayList<String> topTitlesByRating(int k) {
        ArrayList<String> result = new ArrayList<>();
        if (k <= 0) return result;

        ArrayList<MediaItem> copy = new ArrayList<>(items);

        copy.sort((a, b) -> {
            int cmp = Double.compare(b.getRating(), a.getRating());
            if (cmp != 0) return cmp;
            return a.getTitle().compareTo(b.getTitle());
        });

        int limit = Math.min(k, copy.size());
        for (int i = 0; i < limit; i++) {
            result.add(copy.get(i).getTitle());
        }
        return result;
    }

    public Map<String, Long> countByType() {
        Map<String, Long> map = new HashMap<>();
        map.put("Book", 0L);
        map.put("Movie", 0L);
        map.put("Album", 0L);

        for (MediaItem m : items) {
            String key = null;

            if (m instanceof Book) key = "Book";
            else if (m instanceof Movie) key = "Movie";
            else if (m instanceof Album) key = "Album";

            if (key != null) {
                map.put(key, map.get(key) + 1L);
            }
        }
        return map;
    }

    public double averageLengthForType(String type) {
        if (type == null) return 0.0;

        long sum = 0;
        long count = 0;

        for (MediaItem m : items) {
            boolean matches =
                (type.equals("Book") && m instanceof Book) ||
                (type.equals("Movie") && m instanceof Movie) ||
                (type.equals("Album") && m instanceof Album);

            if (matches) {
                sum += m.getLength();
                count++;
            }
        }

        if (count == 0) return 0.0;
        return (double) sum / (double) count;
    }

    // Lazy filtered iteration: no temp list created
    public Iterable<MediaItem> filterByRating(double min) {
        return () -> new Iterator<MediaItem>() {
            private int index = 0;
            private MediaItem nextItem = findNext();

            private MediaItem findNext() {
                while (index < items.size()) {
                    MediaItem m = items.get(index++);
                    if (m.getRating() >= min) return m;
                }
                return null;
            }

            @Override
            public boolean hasNext() {
                return nextItem != null;
            }

            @Override
            public MediaItem next() {
                if (nextItem == null) throw new NoSuchElementException();
                MediaItem current = nextItem;
                nextItem = findNext();
                return current;
            }
        };
    }

    @Override
    public Iterator<MediaItem> iterator() {
        return items.iterator();
    }
}

