package meal;

public class LoyaltyStatus {
    private final double discount;

    public LoyaltyStatus(double discount) {
        this.discount = discount;
    }

    public double applyDiscount(double totalCost) {
        return totalCost - (totalCost * discount);
    }
}