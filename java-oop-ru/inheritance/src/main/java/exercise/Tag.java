package exercise;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

// BEGIN
public abstract class Tag {
    public String getName() {
        return name;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public String getBody() {
        return body;
    }

    private String name;
    private Map<String, String> attributes;
    private String body;

    public Tag(String name, Map<String, String> attributes) {
        this.name = name;
        this.attributes = new LinkedHashMap<>(attributes);
    }

    public void setAttributes(String name, String value) {
        this.attributes.put(name, value);
    }

    public void setBody(String body) {
        this.body = body;
    }
    public abstract boolean isSelfClosing();

    public String render() {
        StringBuilder sb = new StringBuilder();

        sb.append("<").append(name);

        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            sb.append(" ").append(entry.getKey()).append("=\"").append(entry.getValue()).append("\"");
        }

        if (isSelfClosing()) {
            sb.append(">");
        } else {
            sb.append(">");
            if (body != null) {
                sb.append(body);
            }
            sb.append("</").append(name).append(">");
        }

        return sb.toString();
    }
}

// END
