package symulator;

import javafx.util.StringConverter;

public class SamochodConverter extends StringConverter<Samochod> {

    @Override
    public String toString(Samochod samochod) {
        if (samochod == null) {
            return ""; }
        return samochod.getName();
    }
    @Override
    public Samochod fromString(String string) {
        return null;
    }
}