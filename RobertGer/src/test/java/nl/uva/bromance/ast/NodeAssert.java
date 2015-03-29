package nl.uva.bromance.ast;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

public class NodeAssert extends AbstractAssert<NodeAssert, QLNode> {


    public NodeAssert(QLNode actual) {
        super(actual, NodeAssert.class);
    }

    public static NodeAssert assertThat(QLNode actual) {
        return new NodeAssert(actual);
    }


    public NodeAssert hasChildrenOfType(Class<?> expectedClazz) {
        boolean hasChildrenOfClass = false;

        for (QLNode node : actual.getChildren()) {
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
        for (QLNode node : actual.getChildren()) {
            if (node.getClass().equals(clazz))
                hasChildrenOfClass = true;
            actualNumberOfChildren++;
        }
        Assertions.assertThat(actualNumberOfChildren).isEqualTo(expectedNumberOfChildren);
        Assertions.assertThat(hasChildrenOfClass).isTrue();
        return this;
    }
}
