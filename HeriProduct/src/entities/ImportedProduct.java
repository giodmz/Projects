package entities;

public class ImportedProduct extends Product {
    
    private double customsFee;

    public ImportedProduct(){

    }

    public ImportedProduct(String name, double price, double customsFree) {
        super(name, price);
        this.customsFee = customsFree;
    }

    public double getCustomsFree() {
        return customsFee;
    }

    public void setCustomsFree(double customsFree) {
        this.customsFee = customsFree;
    }

    @Override
    public String priceTag(){
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(" $" + price);
        sb.append(" (Customs fee: $" + customsFee + ")");
        return sb.toString();
    }

}
