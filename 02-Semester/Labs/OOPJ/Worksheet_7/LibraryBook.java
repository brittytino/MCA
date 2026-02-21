package WorkSheet_7;

class Book{
    String title;
    String author;
    boolean available = true;

    Book(String t, String a){
        this.title = t;
        this.author = a;
    }

    void borrowBook(){
        System.out.println("Book borrowed successfully");
        this.available = false;
        displayStatus();
    }

    void returnBook(){
        System.out.println("Book returned");
        this.available = true;
        displayStatus();
    }

    void displayStatus(){
        if(this.available){
            System.out.println("Status: Available");
        } else {
            System.out.println("Status: Not Available");
        }

    }
}
public class LibraryBook {
    public static void main(String[] args) {
        Book b1 = new Book("Nadipu Arakan","Siva");
        b1.borrowBook();
        b1.returnBook();
    }
}
