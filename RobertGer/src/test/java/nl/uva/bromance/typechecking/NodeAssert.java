package nl.uva.bromance.typechecking;

import nl.uva.bromance.ast.Node;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

/**
 * Created by Robert on 3/1/2015.
 */
public class NodeAssert extends AbstractAssert<NodeAssert, Node> {


    public NodeAssert(Node actual) {
        super(actual, NodeAssert.class);
    }

    public static NodeAssert assertThat(Node actual) {
        return new NodeAssert(actual);
    }


    public NodeAssert hasChildrenOfType(Class<?> expectedClazz) {
        boolean hasChildrenOfClass = false;

        for (Node node : actual.getChildren()) {
            if (node.getClass().equals(expectedClazz))
                hasChildrenOfClass = true;
            break;
        }
        Assertions.assertThat(hasChildrenOfClass).isTrue();
        return this;
    }

    public NodeAssert hasExactlyChildrenOfType(int expectedNumberOfChildren, Class<?> clazz) {
        boolean hasChildrenOfClass = false;
        int actualNumberOfChildren = 0;
        for (Node node : actual.getChildren()) {
            if (node.getClass().equals(clazz))
                hasChildrenOfClass = true;
            actualNumberOfChildren++;
        }
        Assertions.assertThat(actualNumberOfChildren).isEqualTo(expectedNumberOfChildren);
        Assertions.assertThat(hasChildrenOfClass).isTrue();
        return this;
    }
}
