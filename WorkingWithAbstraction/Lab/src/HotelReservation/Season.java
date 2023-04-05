package HotelReservation;

public enum Season {

    Autumn("Autumn", 1),
    Spring("Spring", 2),
    Winter("Winter", 3),
    Summer("Summer", 4);
    private String name;
    private int multiplier;

    Season(String name, int multiplier) {
        this.name = name;
        this.multiplier = multiplier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }
}
