package nl.uva.softwcons.ast;

public class LineInfo {

    private final int line;
    private final int positionInLine;

    public LineInfo(int line, int positionInLine) {
        super();
        this.line = line;
        this.positionInLine = positionInLine;
    }

    public int getLine() {
        return line;
    }

    public int getPositionInLine() {
        return positionInLine;
    }

}
