package myCraftForm.database.connection;

/**
 *
 * @author crafttor
 */
public class Products {
    private int id;
    private String product;
    private int availability;
    private int sum;
    private String unit;
    private String description;
    
    public Products(){
    }
    
    public Products(int id, String product, int availability){
        this.id = id;
        this.product = product;
        this.availability = availability;
    }
    public Products(int id, String product, int availability, int sum, String unit, String description){
        this.id = id;
        this.product = product;
        this.availability = availability;
        this.sum = sum;
        this.unit = unit;
        this.description = description;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getProduct() {
        return product;
    }
    public void setProduct(String product) {
        this.product = product;
    }
    public int getAvailability() {
        return availability;
    }
    public void setAvailability(int availability) {
        this.availability = availability;
    }
    public int getSum() {
        return sum;
    }
    public void setSum(int sum) {
        this.sum = sum;
    }
    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{id:" + id + ", product: " + product + ", description: " + description + "}";
    }
}
