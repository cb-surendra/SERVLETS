public class Book {
    String name;
    Author[] authors;
    double price;
    int qtyInStock = 0;

    public Book(String name, Author[] authors, double price, int qtyInStock) {
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.qtyInStock = qtyInStock;
    }
    public Book(String name, Author authors, double price, int qtyInStock) {
        this.name = name;
        this.price = price;
        this.qtyInStock = qtyInStock;
    }

    //getter and setter for class variables
    public String getName() {
        return name;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQtyInStock() {
        return qtyInStock;
    }

    public void setQtyInStock(int qtyInStock) {
        this.qtyInStock = qtyInStock;
    }
    /*This returns a string in the format "[-name] by author1-name (gender) at email, author2-name (gender) at email…”.
    Price : $500
    No of books available : 30”
    This iterates through all the authors for the book and prints.*/
    public String toDisplay(){

        String result = "";
        int cnt = 0;
        for( Author a : this.getAuthors()){
            cnt++;
            result = result + "author"+cnt +"-"+ a.getName() + " " + a.getGender() + " at " + a.getEmail() + "\n";
        }
        result += "Price : $" + this.getPrice() + "\n";
        result +=  "No of books available : " + this.getQtyInStock();
        return result;
    }

    public void printAuthors(){
    }

    public void addAuthor(Author author){
    }
}
