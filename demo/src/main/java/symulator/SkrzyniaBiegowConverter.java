package symulator;


import javafx.util.StringConverter;

public class SkrzyniaBiegowConverter extends StringConverter<SkrzyniaBiegow> {

    @Override
    public String toString(SkrzyniaBiegow skrzyniaBiegow) {
        if (skrzyniaBiegow == null) {
            return ""; }
        return skrzyniaBiegow.getnazwa();
    }
    @Override
    public SkrzyniaBiegow fromString(String string) {
        return null;
    }
}