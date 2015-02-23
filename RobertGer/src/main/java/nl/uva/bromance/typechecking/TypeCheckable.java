package nl.uva.bromance.typechecking;

/**
 * Created by Robert on 2/21/2015.
 */
public interface TypeCheckable {

    void typeCheck() throws TypeCheckingException;

    void addReference(ReferenceMap referenceMap) throws TypeCheckingException;
}
