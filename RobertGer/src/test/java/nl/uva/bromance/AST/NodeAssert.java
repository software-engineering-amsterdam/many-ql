package nl.uva.bromance.AST;

import org.assertj.core.api.AbstractAssert;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Robert on 3/1/2015.
 */
public class NodeAssert extends AbstractAssert<NodeAssert, Node> {
    protected NodeAssert(Node actual, Class<?> selfType) {
        super(actual, selfType);
    }

    public NodeAssert hasChildren() {
        assertThat(actual.hasChildren()).isTrue();
        return this;
    }

    public NodeAssert hasChildrenOfType(Class<?> expectedClazz) {
        boolean hasChildrenOfClass = false;

        for (Node node : actual.getChildren()) {
            if (node.getClass().equals(expectedClazz))
                hasChildrenOfClass = true;
            break;
        }
        assertThat(hasChildrenOfClass).isTrue();
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
        assertThat(actualNumberOfChildren).isEqualTo(expectedNumberOfChildren);
        assertThat(hasChildrenOfClass).isTrue();
        return this;
    }
}
