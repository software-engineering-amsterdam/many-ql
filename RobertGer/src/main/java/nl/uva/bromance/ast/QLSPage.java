package nl.uva.bromance.ast;

public class QLSPage extends QLSNode {
    private String identifier;

    public QLSPage(int lineNumber, String id) {
        super(lineNumber);
        if (id != null) {
            this.identifier = id.substring(1, id.length() - 1).toLowerCase();
        } else {
            System.err.println("Root Error: No identifier specified");
        }
    }

    public String getIdentifier() {
        return identifier;
    }

}
