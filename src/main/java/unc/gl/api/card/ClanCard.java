package unc.gl.api.card;

public class ClanCard implements ICard{
    public static int NUM_COLOR = 9;
    private int strength;
    private EColor color;

    public ClanCard(int strength, EColor color){
        this.strength = strength;
        this.color = color;
    }

    @Override
    public String getId() {
        return this.color + String.valueOf(this.strength);
    }

    public int getStrength(){
        return this.strength;
    }

    public EColor getColor(){
        return this.color;
    }
}
