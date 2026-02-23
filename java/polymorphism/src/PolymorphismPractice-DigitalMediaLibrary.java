package package1;

public class TestRoom9 {
    static abstract class MediaItem {
        private String title;
        private double rating;

        public void setTitle(String title) {
            if (title == null || title.isBlank()) {
                System.out.println("Title cannot be null or blank.");
                return;
            }
            this.title = title;
        }

        public void setRating(double rating) {
            if (!(rating >= 0.0 && rating <= 5.0)) {
                System.out.println("Rating must be between 0.0 and 5.0");
                return;
            }
            this.rating = rating;
        }

        public String getTitle() {
            return title;
        }

        public double getRating() {
            return rating;
        }

        public abstract double playbackTime();

        public String describe() {
            return getTitle() + " has rating " + getRating() + " and plays for " + playbackTime() + " minutes.";
        }
    }

    static class Song extends MediaItem {
        private double length;

        public Song(String title, double rating, double length) {
            super.setTitle(title);
            super.setRating(rating);
            if (length <= 0) {
                System.out.println("Length must be greater than zero.");
                return;
            }
            this.length = length;
        }

        public void setLength(double length) {
            if (length <= 0) {
                System.out.println("Length muse be positive.");
                return;
            }
            this.length = length;
        }

        @Override
        public double playbackTime() {
            return length;
        }

        @Override
        public String describe() {
            return "Song: " + getTitle() + " is " + playbackTime() + " minutes with rating " + getRating() + ".";
        }
    }

    static class Movie extends MediaItem {
        private double hours;
        private double minutes;

        public Movie(String title, double rating, double hours, double minutes) {
            super.setTitle(title);
            super.setRating(rating);
            if (hours < 0) {
                System.out.println("Hours must be greater than or equal to zero.");
                return;
            }
            if (minutes < 0.0 || minutes > 59.0) {
                System.out.println("Minutes must be 0 and 59");
                return;
            }
            this.hours = hours;
            this.minutes = minutes;
        }

        public void setHours(double h) {
            if (h < 0) {
                System.out.println("Hours cannot be negative.");
                return;
            }
            this.hours = h;
        }

        public void setMinutes(double m) {
            if (m < 0.0 || m > 59.0) {
                System.out.println("Hours cannot be negative.");
                return;
            }
            this.minutes = m;
        }

        @Override
        public double playbackTime() {
            return (hours * 60) + minutes;
        }

        @Override
        public String describe() {
            return "Movie: " + getTitle() + " lasts " + playbackTime() + " minutes with rating " + getRating() + ".";
        }
    }

    static class PodcastEpisode extends MediaItem {
        private int episodeNumber;
        private double duration;

        public PodcastEpisode(String title, double rating, int episodeNumber, double duration) {
            super.setTitle(title);
            super.setRating(rating);
            if (episodeNumber < 1) {
                System.out.println("Episode number must be at least 1.");
                return;
            }
            if (duration <= 0) {
                System.out.println("Duration cannot be negative.");
                return;
            }
            this.episodeNumber = episodeNumber;
            this.duration = duration;
        }

        public void setEpisodeNumber(int e) {
            if (e < 1) {
                System.out.println("Episode number must be greater than 1.");
                return;
            }
            this.episodeNumber = e;
        }

        public void setDuration(double d) {
            if (d <= 0) {
                System.out.println("Duration must be positive.");
                return;
            }
            this.duration = d;
        }

        @Override
        public double playbackTime() {
            return duration;
        }

        @Override
        public String describe() {
            return "Podcast: Episode " + episodeNumber + " of \"" + getTitle() + "\" runs " + playbackTime()
                    + " minutes with rating " + getRating();
        }
    }

    public static void main(String[] args) {
        MediaItem[] library = new MediaItem[4];

        library[0] = new Song("Sunrise", 4.5, 3.2);
        library[1] = new Movie("Skyfall", 4.0, 2, 23);
        library[2] = new PodcastEpisode("TechTalk", 4.8, 12, 47.5);
        library[3] = new Song("Night Drive", 3.9, 4.0);

        for (MediaItem m : library) {
            System.out.println(m.describe());
        }
    }
}
