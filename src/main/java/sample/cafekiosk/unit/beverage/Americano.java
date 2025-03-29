package sample.cafekiosk.unit.beverage;

public class Americano implements Beverage {
    @Override
    public String getNames() {
        return "아메리카노";
    }

    @Override
    public int getPrice() {
        return 4000;
    }
}
