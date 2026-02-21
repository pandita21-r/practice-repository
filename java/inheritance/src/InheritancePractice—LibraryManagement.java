/*
    UML Diagram:
                   ┌─────────────────────┐
                   │   <<abstract>>      │
                   │    LibraryItem      │
                   ├─────────────────────┤
                   │ - title: String     │
                   │ - itemId: String    │
                   │ - isBorrowed: bool  │
                   ├─────────────────────┤
                   │ + borrow()           │
                   │ + returnItem()       │
                   │ + getInfo(): String  │
                   │ # getTitle(): String │
                   │ # getItemId(): String│
                   │ # getBorrowed(): bool│
                   └─────────▲───────────┘
                             │
          ┌──────────────────┼──────────────────┐
          │                  │                  │
 ┌───────────────┐  ┌────────────────┐  ┌───────────────┐
 │     Book      │  │   Magazine     │  │      DVD      │
 ├───────────────┤  ├────────────────┤  ├───────────────┤
 │ - author:Str  │  │ - issueNumber:int│  │ - duration:int│
 │ - numPages:int│  ├────────────────┤  ├───────────────┤
 ├───────────────┤  │ + getInfo():Str│  │ + getInfo():Str│
 │ + getInfo():Str│  └────────────────┘  └───────────────┘
 └───────────────┘
*/
package package1;

public class TestRoom9 {
    static abstract class LibraryItem {
        private final String title;
        private final String itemId;
        private volatile boolean isBorrowed;

        LibraryItem(String title, String itemId) {
            if (title == null || title.isBlank()) {
                throw new IllegalArgumentException("Title cannot be null or blank.");
            }
            if (itemId == null || itemId.isBlank()) {
                throw new IllegalArgumentException("Item ID cannot be null or blank.");
            }
            this.title = title;
            this.itemId = itemId;
            this.isBorrowed = false;
        }

        public synchronized void borrow() {
            if (isBorrowed) {
                throw new IllegalStateException("Item is already borrowed.");
            }
            this.isBorrowed = true;
        }

        public synchronized void returnItem() {
            if (!isBorrowed) {
                throw new IllegalStateException("Item is not currently borrowed.");
            }
            this.isBorrowed = false;
        }

        protected String getTitle() {
            return title;
        }

        protected String getItemId() {
            return itemId;
        }

        protected boolean getBorrowed() {
            return isBorrowed;
        }

        public String getInfo() {
            return String.format("Title: %s, ID: %s, Borrowed: %b", title, itemId, isBorrowed);
        }
    }

    static class Book extends LibraryItem {
        private final String author;
        private final int numPages;

        public Book(String title, String itemId, String author, int numPages) {
            super(title, itemId);
            if (author == null || author.isBlank()) {
                throw new IllegalArgumentException("Author cannot be null or blank.");
            }
            if (numPages < 1) {
                throw new IllegalArgumentException("Number of pages cannot be 0.");
            }
            this.author = author;
            this.numPages = numPages;
        }

        @Override
        public String getInfo() {
            return String.format("%s, Author: %s, Pages: %d", super.getInfo(), author, numPages);
        }
    }

    static class Magazine extends LibraryItem {
        private final int issueNumber;

        public Magazine(String title, String itemId, int issueNumber) {
            super(title, itemId);
            if (issueNumber < 1) {
                throw new IllegalArgumentException("Issue number must be greater than 0.");
            }
            this.issueNumber = issueNumber;
        }

        @Override
        public String getInfo() {
            return String.format("%s, Issue: %d", super.getInfo(), issueNumber);
        }
    }

    static class DVD extends LibraryItem {
        private final int duration;

        public DVD(String title, String itemId, int duration) {
            super(title, itemId);
            if (duration < 1) {
                throw new IllegalArgumentException("Duration must be greater than 0.");
            }
            this.duration = duration;
        }

        @Override
        public String getInfo() {
            return String.format("%s, Duration: %d", super.getInfo(), duration);
        }
    }

    public static void main(String[] args) {
        LibraryItem book = new Book("Java Programming", "B001", "John Doe", 500);
        LibraryItem mag = new Magazine("National Geographic", "M101", 45);
        LibraryItem dvd = new DVD("Inception", "D500", 148);

        try {
            System.out.println(book.getInfo());
            System.out.println(mag.getInfo());
            System.out.println(dvd.getInfo());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
