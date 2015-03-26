package org.fugazi.qls.ast.stylesheet.stylesheet_data.visitor;

import org.fugazi.qls.ast.style.DefaultStyleDeclaration;
import org.fugazi.qls.ast.stylesheet.StyleSheet;

import java.util.ArrayList;
import java.util.List;

public class DefaultDeclarationsVisitor extends FullQLSFormVisitor {

    private StyleSheet sheet;
    private List<DefaultStyleDeclaration> defaultStyleDeclarations;

    public DefaultDeclarationsVisitor(StyleSheet _sheet) {
        super();
        this.sheet = _sheet;
    }

    /**
     * =======================
     * Visitor methods
     * =======================
     */

    @Override
    public Void visitDefaultStyleDeclr(DefaultStyleDeclaration _styleDeclr) {
        this.saveDeclaration(_styleDeclr);
        return null;
    }

    /**
     * =======================
     * Private data handling functions
     * =======================
     */

    private void saveDeclaration(DefaultStyleDeclaration _defaultStyleDeclarations) {
        this.defaultStyleDeclarations.add(_defaultStyleDeclarations);
    }

    /**
     * =======================
     * Exposed methods
     * =======================
     */

    public List<DefaultStyleDeclaration> getDefaultStyleDeclarations() {
        if (this.defaultStyleDeclarations == null) {
            this.defaultStyleDeclarations = new ArrayList<>();
            this.visitStyleSheet(this.sheet);
        }
        return this.defaultStyleDeclarations;
    }
}
