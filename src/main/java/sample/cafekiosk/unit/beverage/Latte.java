package sample.cafekiosk.unit.beverage;

public class Latte implements Beverage {
    @Override
    public String getNames() {
         return "라떼";
    }

    @Override
    public int getPrice() {
        return 4500;
    }
}