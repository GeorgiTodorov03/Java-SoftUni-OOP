package HotelReservation;

public class PriceCalculator {

    public static double calculatePrice(double pricePerDay, int days, Season season, Discount discount) {
        double price = pricePerDay * days;

        price *= season.getMultiplier();

        price = price - price * (discount.getPercent() / 100);

        return price;
    }

}
