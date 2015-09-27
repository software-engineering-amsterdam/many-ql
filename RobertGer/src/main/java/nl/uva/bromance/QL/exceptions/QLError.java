package nl.uva.bromance.QL.exceptions;

import java.util.ArrayList;
import java.util.List;

public class QLError extends Throwable{

    public QLError(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    public static String qlErrorListToString(List<QLError> errors){
        String result = "";
        for (QLError t : errors) {
            result += t.getMessage() + '\n';
        }
        return result;
    }

    public static List<QLError> convertTypeCheckingErrorListToQLErrorList(List<TypeCheckingError> typeCheckingErrors) {
        List<QLError> list = new ArrayList<>();
        for(TypeCheckingError e: typeCheckingErrors){
            list.add(e);
        }
        return list;
    }
}
