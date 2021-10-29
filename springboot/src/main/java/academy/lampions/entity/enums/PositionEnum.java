package academy.lampions.entity.enums;

public enum PositionEnum {
    GK("goleiro"),
    CB("zagueiro"),
    SB("lateral"),
    CM("meia"),
    ST("atacante");

    private String name;

    private PositionEnum(String position) {
        this.name = position;
    }

    public String getName() {
        return name;
    }
    
}
