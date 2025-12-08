package symulator;

import javafx.util.StringConverter;

public class SilnikConverter extends StringConverter<Silnik> {

    @Override
    public String toString(Silnik silnik) {
        if (silnik == null) {
            return ""; }
        return silnik.getnazwa();
    }
    @Override
    public Silnik fromString(String string) {
        return null;
    }
}