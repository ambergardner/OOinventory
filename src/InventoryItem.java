public class InventoryItem
{
    String name;
    int amount;
    String category;

    public InventoryItem(String name, int amount, String category) {
        this.name = name;
        this.amount = amount;
        this.category = category;
    }
    // ingredient is the name of the item. String is its data type.
    //  amount is how many. int is its data type.
    // so everything that is a InventoryItem has an name and an amount
    //category is defined as either protein or veggie.
}
