package nl.uva.softwcons.qls.validation;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import nl.uva.softwcons.helper.TestHelper;
import nl.uva.softwcons.ql.ast.LineInfo;
import nl.uva.softwcons.ql.ast.expression.identifier.Identifier;
import nl.uva.softwcons.ql.ast.type.BooleanType;
import nl.uva.softwcons.ql.ast.type.DateType;
import nl.uva.softwcons.ql.ast.type.NumberType;
import nl.uva.softwcons.ql.ast.type.StringType;
import nl.uva.softwcons.ql.validation.Error;
import nl.uva.softwcons.ql.validation.type.Environment;
import nl.uva.softwcons.qls.StylesheetBuilder;
import nl.uva.softwcons.qls.ast.stylesheet.Stylesheet;
import nl.uva.softwcons.qls.validation.widget.WidgetTypeChecker;
import nl.uva.softwcons.qls.validation.widget.error.IncompatibleWidget;

import org.junit.Test;

public class WidgetTypeCheckerTest {

    @Test
    public void testPageStyleInconsistency() {
        List<Error> errors = getWidgetTypeErrors("page page1 { question q1 default boolean widget slider (10, 20, 1)} ");

        assertThat(errors).hasSize(1);
        assertThat(errors.get(0)).isExactlyInstanceOf(IncompatibleWidget.class);
    }

    @Test
    public void testPageStyleConsistent() {
        List<Error> errors = getWidgetTypeErrors("page page1 { question q1 "
                + "default boolean widget dropdown (\"Yes\", \"No\")} ");
        assertThat(errors).hasSize(0);
    }

    @Test
    public void testPageManyStylesInconsistency() {
        List<Error> errors = getWidgetTypeErrors("page page1 { question q1 "
                + "default boolean widget radio (\"Yes\", \"No\") \n default string widget radio (\"Yes\", \"No\")} ");
        assertThat(errors).hasSize(1);
        assertThat(errors.get(0)).isExactlyInstanceOf(IncompatibleWidget.class);
    }

    @Test
    public void testPageManyStylesConsistent() {
        List<Error> errors = getWidgetTypeErrors("page page1 { question q1 "
                + "default boolean widget dropdown (\"Yes\", \"No\") \n default string widget text} ");
        assertThat(errors).hasSize(0);
    }

    @Test
    public void testSectionStyleConsistent() {
        List<Error> errors = getWidgetTypeErrors("page page1 { section \"section\" { question q1 "
                + "default boolean widget dropdown (\"Yes\", \"No\")} }");
        assertThat(errors).hasSize(0);
    }

    @Test
    public void testSectionStyleInconsistency() {
        List<Error> errors = getWidgetTypeErrors("page page1 { section \"section\" { question q1 "
                + "default boolean widget slider (1, 10, 1)} } ");
        assertThat(errors).hasSize(1);
        assertThat(errors.get(0)).isExactlyInstanceOf(IncompatibleWidget.class);
    }

    @Test
    public void testSectionManyStylesInconsistency() {
        List<Error> errors = getWidgetTypeErrors("page page1 { section \"section\" { question q1 "
                + "default string widget radio (\"Yes\", \"No\") \n "
                + "default string widget radio (\"Yes\", \"No\")} } ");
        assertThat(errors).hasSize(1);
        assertThat(errors).hasOnlyElementsOfType(IncompatibleWidget.class);
    }

    @Test
    public void testSectionManyStylesConsistent() {
        List<Error> errors = getWidgetTypeErrors("page page1 { section \"section\" { question q1 "
                + "default boolean widget dropdown (\"Yes\", \"No\") \n "
                + "default string widget text \n default date widget text } } ");
        assertThat(errors).hasSize(0);
    }

    @Test
    public void testPageSectionStyle() {
        List<Error> errors = getWidgetTypeErrors("page page1 { section \"section\" { question q1 "
                + "default boolean widget dropdown (\"Yes\", \"No\") \n "
                + "default string widget text \n default date widget text } default string widget text } ");
        assertThat(errors).hasSize(0);
    }

    @Test
    public void testStylesheetWithoutStyles() {
        List<Error> errors = getWidgetTypeErrors("page page1 { section \"section\" { question q1 } } ");
        assertThat(errors).hasSize(0);
    }

    @Test
    public void testQuestionWithCorrectWidget() {
        List<Error> errors = getWidgetTypeErrors("page page1 { section \"section\" { question q1 widget radio (\"Yes\", \"No\") } } ");
        assertThat(errors).hasSize(0);
    }

    @Test
    public void testBooleanQuestionWithInCorrectWidget() {
        List<Error> errors = getWidgetTypeErrors("page page1 { section \"section\" { question q1 widget text } } ");
        assertThat(errors).hasSize(1);
        assertThat(errors).hasOnlyElementsOfType(IncompatibleWidget.class);
    }

    @Test
    public void testStringQuestionWithInCorrectWidget() {
        List<Error> errors = getWidgetTypeErrors("page page1 { section \"section\" { question q2 widget radio  (\"Yes\", \"No\") } } ");
        assertThat(errors).hasSize(1);
        assertThat(errors).hasOnlyElementsOfType(IncompatibleWidget.class);
    }

    @Test
    public void testDateQuestionWithInCorrectWidget() {
        List<Error> errors = getWidgetTypeErrors("page page1 { section \"section\" { question q4 widget radio  (\"Yes\", \"No\") } } ");
        assertThat(errors).hasSize(1);
        assertThat(errors).hasOnlyElementsOfType(IncompatibleWidget.class);
    }

    @Test
    public void testNumberQuestionWithInCorrectWidget() {
        List<Error> errors = getWidgetTypeErrors("page page1 { section \"section\" { question q3 widget radio  (\"Yes\", \"No\") } } ");
        assertThat(errors).hasSize(1);
        assertThat(errors).hasOnlyElementsOfType(IncompatibleWidget.class);
    }

    @Test
    public void testNumberQuestionWithCorrectWidgetSlider() {
        List<Error> errors = getWidgetTypeErrors("page page1 { section \"section\" { question q3 widget slider (10, 20, 1) } } ");
        assertThat(errors).hasSize(0);
    }

    @Test
    public void testNumberQuestionWithCorrectWidgetSpinbox() {
        List<Error> errors = getWidgetTypeErrors("page page1 { section \"section\" { question q3 widget spinbox (10, 20, 1)} } ");
        assertThat(errors).hasSize(0);
    }

    @Test
    public void testNumberQuestionWithCorrectWidgetText() {
        List<Error> errors = getWidgetTypeErrors("page page1 { section \"section\" { question q3 widget text } } ");
        assertThat(errors).hasSize(0);
    }

    private static Environment getEnvironment() {
        Environment env = new Environment();
        LineInfo dummyLineInfo = new LineInfo(0, 0);
        env.defineVariable(new Identifier("q1", dummyLineInfo), BooleanType.BOOLEAN_TYPE);
        env.defineVariable(new Identifier("q2", dummyLineInfo), StringType.STRING_TYPE);
        env.defineVariable(new Identifier("q3", dummyLineInfo), NumberType.NUMBER_TYPE);
        env.defineVariable(new Identifier("q4", dummyLineInfo), DateType.DATE_TYPE);
        return env;
    }

    private static List<Error> getWidgetTypeErrors(final String... stylesheetContents) {
        final Stylesheet stylesheet = StylesheetBuilder.build(TestHelper.buildStylesheet("stylesheet1",
                stylesheetContents));
        final WidgetTypeChecker checker = new WidgetTypeChecker(getEnvironment());
        stylesheet.accept(checker);

        return checker.getErrors();

    }

}
