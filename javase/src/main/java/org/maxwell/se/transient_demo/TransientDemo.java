package org.maxwell.se.transient_demo;

import java.io.*;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/7/20 17:03
 */
public class TransientDemo {

    static final String fileName = "C:\\Users\\Maxwell\\Desktop\\test\\obj.text";

    static class Book implements Serializable {
        private static final long serialVersionUID = -2936687026040726549L;
        private String bookName;
        private transient String description;
        private transient int copies;

        public String getBookName() {
            return bookName;
        }

        public void setBookName(String bookName) {
            this.bookName = bookName;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getCopies() {
            return copies;
        }

        public void setCopies(int copies) {
            this.copies = copies;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "bookName='" + bookName + '\'' +
                    ", description='" + description + '\'' +
                    ", copies=" + copies +
                    '}';
        }
    }

    public static void serialize(Book book) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(book);
        fos.close();
        oos.close();
    }

    public static Book deserialize() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Book book = (Book) ois.readObject();
        fis.close();
        ois.close();
        return book;
    }

    public static void main(String[] args) {
        Book book = new Book();
        book.setBookName("Java Reference");
        book.setDescription("will not be saved");
        book.setCopies(25);

        try {
            serialize(book);
            Book deserialize = deserialize();
            System.out.println(deserialize);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
