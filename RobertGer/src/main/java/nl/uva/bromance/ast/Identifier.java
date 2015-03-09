package nl.uva.bromance.ast;

import nl.uva.bromance.ast.conditionals.Result;

/**
 * Created by Robert on 9-3-2015.
 */
public class Identifier {

    private String id;
    private Result result;

    public Identifier(String id) {
        id = process(id);
    }

    private String process(String id) {
        if (id.startsWith("\"") && id.endsWith("\"")) {
            return id.substring(1, id.length() - 1);
        } else
            return id;
    }


    public String getId() {
        return id;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
