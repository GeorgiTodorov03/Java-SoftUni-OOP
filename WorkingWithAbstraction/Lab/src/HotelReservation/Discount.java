package HotelReservation;

public enum Discount {
    VIP("VIP", 20),
    SecondVisit("SecondVisit", 10),
    None("None", 0);

    private String name;
    private double percent;

    Discount(String name, double discount) {
        this.name = name;
        this.percent = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }
}
