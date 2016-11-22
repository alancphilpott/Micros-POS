/** Created by Sam on 22/11/2016 */

enum ItemType {
    FOOD, DRINK, DESSERT
}

class MenuItem {

    private final String name;
    private final double price;
    private final ItemType type;



    MenuItem(String name, double price, ItemType type)
    {
        this.name = name;
        this.price = price;
        this.type = type;

    }

    String getName ()
    {
        return this.name;
    }

    double getPrice ()
    {
        return this.price;
    }

    ItemType getType() { return this.type; }

    public String toString ()
    {
        return String.format("%s - €%.2f", this.getName(),this.getPrice());
    }


}