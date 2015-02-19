package lang.ql.gui;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import lang.ql.semantics.values.BooleanValue;
import lang.ql.semantics.values.IntegerValue;

/**
 * Created by Nik on 17-2-15.
 */
public abstract class InputField
{
    public InputField (IntegerValue val) {

    }
    public Node getElement(BooleanValue val) {
        return new CheckBox();
    }
}
