package academy.lampions.entity.enums;

public enum PositionEnum {
    Goleiro("goleiro"),
    Zagueiro("zagueiro"),
    Lateral("lateral"),
    Meia("meia"),
    Atacante("atacante");

    private String name;

    private PositionEnum(String position) {
        this.name = position;
    }

    public String getName() {
        return name;
    }
    
}
