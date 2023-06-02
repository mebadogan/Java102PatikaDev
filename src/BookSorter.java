import java.util.Comparator;
import java.util.TreeSet;

public class BookSorter {

    static class Book implements Comparable<Book>{
        private String bookName;
        private int pageCount;
        private String bookWriter;
        private int publishedDate;

        Book(String bookName, int pageCount, String bookWriter, int publishedDate){
            this.bookName = bookName;
            this.pageCount = pageCount;
            this.bookWriter = bookWriter;
            this.publishedDate = publishedDate;
            addBooktoList(this);
        }
        public static TreeSet<Book> bookListByName = new TreeSet<>(new Comparator<Book>(){
            @Override
            public int compare(Book o1, Book o2) {
                return o1.bookName.compareTo(o2.bookName);
            }
        });

        public static TreeSet<Book> bookListByPage = new TreeSet<>(new Comparator<Book>(){
            @Override
            public int compare(Book o1, Book o2) {
                return o1.pageCount - o2.pageCount;
            }
        });

        @Override
        public int compareTo(Book o) {
            return this.bookName.compareTo(o.bookName);
        }

        public static void printBooks(){
            for(Book book : bookListByName){
                System.out.println("Name: " + book.getBookName());
                System.out.println("*************************************");
            }
            for(Book book : bookListByPage){
                System.out.println("Name: " + book.getBookName() +
                        "\nPage: " + book.getPageCount());
                System.out.println("*************************************");
            }
        }

        public String getBookName() {
            return bookName;
        }

        public void setBookName(String bookName) {
            this.bookName = bookName;
        }

        public int getPageCount() {
            return pageCount;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }

        public String getBookWriter() {
            return bookWriter;
        }

        public void setBookWriter(String bookWriter) {
            this.bookWriter = bookWriter;
        }

        public int getPublishedDate() {
            return publishedDate;
        }

        public void setPublishedDate(int publishedDate) {
            this.publishedDate = publishedDate;
        }
        public void addBooktoList(Book book){
            bookListByName.add(book);
            bookListByPage.add(book);
        }

    }

    public static void main(String[] args) {
        Book book1 = new Book("Yabancı", 110, "Albert Camus", 1981);
        Book book2 = new Book("Dorian Gray'in Portresi", 258, "Oscar Wilde", 1890 );
        Book book3 = new Book("Dönüşüm", 74, "Franz Kafka", 1915);
        Book book4 = new Book("Yapay Zeka", 175, "Cem Say", 2018);
        Book book5 = new Book("Outliers", 242, "Malcolm Gladwell", 2008);

        Book.printBooks();
    }
}
