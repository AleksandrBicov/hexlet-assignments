package exercise;

import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;

public class PairedTag extends Tag {
    private String body;
    private List<Tag> tagList;

    public PairedTag(String name, Map<String, String> attributes, String body, List<Tag> tagList) {
        super(name, new LinkedHashMap<>(attributes));
        this.body = body;
        this.tagList = tagList;
    }

    @Override
    public boolean isSelfClosing() {
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("<").append(getName());

        for (Map.Entry<String, String> entry : getAttributes().entrySet()) {
            sb.append(" ").append(entry.getKey()).append("=\"").append(entry.getValue()).append("\"");
        }

        sb.append(">");

        if (!body.isEmpty()) {
            sb.append(body);
        }

        for (Tag tag : tagList) {
            sb.append(tag.toString());
        }

        sb.append("</").append(getName()).append(">");

        return sb.toString();
    }
}