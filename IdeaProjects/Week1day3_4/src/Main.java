public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World!");
        Author author = new Author("R.K. Narayan", "rknarayan@gmail.com", 'M');
        System.out.println(author.toDisplay());
        author.setEmail("abc@gmail.com");
        System.out.println(author.toDisplay());

        /*
        Populate the data using a util method.
        Add an author for a particular book.
        Display the authors for a particular book.
        Print the details for the books available.
         */
    }
}
