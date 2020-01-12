package commonFile;

public class Book {
    public double price;
    public String title;
    public String cover;

    public Book(Double price, String title, String cover){
        this.price = price;
        this.title = title;
        this.cover = cover;
    }

    public String getTitle()
    {
        return title;
    }

    public String getCover()
    {
        return cover;
    }

    public double getPrice()
    {
        return price;
    }


    /* now we create a mutator method for each of the instance variables created above that allows a user to change
     * the state of the object.
     */

    public void setTitle(String title)
    {
        this.title=title;
    }

    public void setCover(String cover)
    {
        this.cover=cover;
    }

    public void setPrice(double price)
    {
        this.price=price;
    }

}
