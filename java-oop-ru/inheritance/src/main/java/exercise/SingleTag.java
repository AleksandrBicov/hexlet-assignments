package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {

    public SingleTag(String name, Map<String, String> attributes) {
        super(name, attributes);
    }
    @Override
    public boolean isSelfClosing() {
        return true;
    }

    public String toString() {
        return SingleTag.super.render();
    }
}
// END
