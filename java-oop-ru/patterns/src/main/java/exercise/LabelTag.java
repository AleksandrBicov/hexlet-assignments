package exercise;

// BEGIN
public class LabelTag implements TagInterface{


    private String type;
    private TagInterface value;
    public LabelTag(String type, TagInterface value) {
        this.type = type;
        this.value = value;
    }


    
    @Override
    public String render() {
        StringBuilder sb = new StringBuilder();
        sb.append("<label>");
        sb.append(type);
        sb.append(value.render());
        sb.append("</label>");
        return sb.toString();
    }
}
// END
