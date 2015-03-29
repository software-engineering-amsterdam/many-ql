package nl.uva.softwcons.qls.ast;

import static nl.uva.softwcons.ql.ast.type.BooleanType.BOOLEAN_TYPE;
import static org.assertj.core.api.Assertions.assertThat;
import nl.uva.softwcons.generated.QLSLexer;
import nl.uva.softwcons.generated.QLSParser;
import nl.uva.softwcons.helper.TestHelper;
import nl.uva.softwcons.ql.ast.type.BooleanType;
import nl.uva.softwcons.qls.ast.segment.Page;
import nl.uva.softwcons.qls.ast.segment.Question;
import nl.uva.softwcons.qls.ast.segment.Section;
import nl.uva.softwcons.qls.ast.stylesheet.Stylesheet;
import nl.uva.softwcons.qls.ast.widget.type.DropdownType;
import nl.uva.softwcons.qls.ast.widget.type.RadioButtonType;
import nl.uva.softwcons.qls.ast.widgetstyle.StyledWidget;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Before;
import org.junit.Test;

public class ASTBuilderVisitorTest {

    Stylesheet withPages;
    Stylesheet withSections;
    Stylesheet mixedQuestionRegion;
    Stylesheet withStyleForPage;
    Stylesheet withStylesForSection;
    Stylesheet withStylesForQuestions;

    @Before
    public void buildStyleSheets() {
        withPages = build(TestHelper.buildStylesheet("withPages", "page page1 { question q1 }",
                "page page2 { question q2 }"));
        withSections = build(TestHelper.buildStylesheet("withSections",
                "page page1 { section \"s1\" { question q1 } }",
                "page page2 { section \"s2\" { section \"s3\" { question q2 } } }"));
        mixedQuestionRegion = build(TestHelper.buildStylesheet("mixedQuestionRegion",
                "page page1 { question q1 section \"s1\" { question q2 } }",
                "page page2 { section \"s2\" { section \"s3\" { question q3 } } }"));
        withStyleForPage = build(TestHelper.buildStylesheet("s1",
                "page p1 { question q1  default boolean widget dropdown(\"True\", \"False\") { width: 2 } }"));
        withStylesForSection = build(TestHelper.buildStylesheet("withStylesForSection",
                "page p1 { section \"s1\" { question q2 default boolean widget dropdown(\"True\", \"False\") } }"));
        withStylesForQuestions = build(TestHelper.buildStylesheet("withStylesForQuestions",
                "page p1 { question q1 \n widget radio(\"True\", \"False\")\n"
                        + " question q2 \n widget dropdown(\"Yes\", \"No\") \n }"));

    }

    @Test
    public void testLabelOfStylesheet() {
        assertThat(withPages.getId().getName()).isEqualTo("withPages");
    }

    @Test
    public void testPagesClass() {
        assertThat(withPages.getPages().get(0)).isExactlyInstanceOf(Page.class);
        assertThat(withPages.getPages().get(0)).isExactlyInstanceOf(Page.class);
    }

    @Test
    public void testPagesCount() {
        assertThat(withPages.getPages().size()).isEqualTo(2);
    }

    @Test
    public void testPagesId() {
        Page page1 = withPages.getPages().get(0);
        Page page2 = withPages.getPages().get(1);

        assertThat(page1.getId().getName()).isEqualTo("page1");
        assertThat(page2.getId().getName()).isEqualTo("page2");
    }

    @Test
    public void testQuestionClassInPage() {
        Page page1 = withPages.getPages().get(0);
        Page page2 = withPages.getPages().get(1);

        assertThat(page1.getSegments().get(0)).isExactlyInstanceOf(Question.class);
        assertThat(page2.getSegments().get(0)).isExactlyInstanceOf(Question.class);
    }

    @Test
    public void testQuestionRegionsCountInPages() {
        Page page1 = withSections.getPages().get(0);
        Page page2 = withSections.getPages().get(1);
        assertThat(page1.getSegments().size()).isEqualTo(1);
        assertThat(page2.getSegments().size()).isEqualTo(1);
    }

    @Test
    public void testSectionsClass() {
        Page page1 = withSections.getPages().get(0);
        Page page2 = withSections.getPages().get(1);
        assertThat(page1.getSegments().get(0)).isExactlyInstanceOf(Section.class);
        assertThat(page2.getSegments().get(0)).isExactlyInstanceOf(Section.class);
    }

    @Test
    public void testSectionLabel() {
        Page page1 = withSections.getPages().get(0);
        Page page2 = withSections.getPages().get(1);
        Section section1 = (Section) page1.getSegments().get(0);
        Section section2 = (Section) page2.getSegments().get(0);

        assertThat(section1.getLabel()).isEqualTo("s1");
        assertThat(section2.getLabel()).isEqualTo("s2");

    }

    @Test
    public void testQuestionsCountInSections() {
        Page page1 = withSections.getPages().get(0);
        Page page2 = withSections.getPages().get(1);
        Section section1 = (Section) page1.getSegments().get(0);
        Section section2 = (Section) page2.getSegments().get(0);

        assertThat(section1.getContent().size()).isEqualTo(1);
        assertThat(section2.getContent().size()).isEqualTo(1);
    }

    @Test
    public void testMixedQuestionRegionInPageSize() {
        Page page1 = mixedQuestionRegion.getPages().get(0);
        Page page2 = mixedQuestionRegion.getPages().get(1);

        assertThat(page1.getSegments().size()).isEqualTo(2);
        assertThat(page2.getSegments().size()).isEqualTo(1);
    }

    @Test
    public void testMixedQuestionRegionInPageTypes() {
        Page page1 = mixedQuestionRegion.getPages().get(0);
        Page page2 = mixedQuestionRegion.getPages().get(1);

        assertThat(page1.getSegments().get(0)).isExactlyInstanceOf(Question.class);
        assertThat(page1.getSegments().get(1)).isExactlyInstanceOf(Section.class);
        assertThat(page2.getSegments().get(0)).isExactlyInstanceOf(Section.class);
    }

    @Test
    public void testMixedQuestionRegionQuestionId() {
        Page page1 = mixedQuestionRegion.getPages().get(0);
        Question q = (Question) page1.getSegments().get(0);
        assertThat(q.getId().getName()).isEqualTo("q1");
    }

    @Test
    public void testStyleInPageCount() {
        Page page1 = withStyleForPage.getPages().get(0);
        assertThat(page1.getStyles().size()).isEqualTo(1);
    }

    @Test
    public void testDefaultStyleQuestionType() {
        Page page1 = withStyleForPage.getPages().get(0);

        assertThat(page1.getStyles().keySet()).hasSize(1);
        assertThat(page1.getStyles().keySet()).extracting("class").contains(BooleanType.class);
    }

    @Test
    public void testDefaultStyleWidgetType() {
        Page page1 = withStyleForPage.getPages().get(0);

        assertThat(page1.getStyles().keySet()).hasSize(1);
        assertThat(page1.getStyles().keySet()).extracting("class").contains(BooleanType.class);
    }

    @Test
    public void testDefaultStyleWidgetStyleExistance() {
        Page page1 = withStyleForPage.getPages().get(0);
        StyledWidget widget = page1.getStyles().get(BooleanType.BOOLEAN_TYPE);

        assertThat(widget.getWidgetStyle()).isNotNull();
    }

    @Test
    public void testDefaultStyleSectionQuestionType() {
        Section section = (Section) withStylesForSection.getPages().get(0).getSegments().get(0);

        assertThat(section.getStyles().keySet()).hasSize(1);
        assertThat(section.getStyles().keySet()).extracting("class").contains(BooleanType.class);
    }

    @Test
    public void testDefaultStyleSectionWidgetType() {
        Section section = (Section) withStylesForSection.getPages().get(0).getSegments().get(0);

        assertThat(section.getStyles().keySet()).hasSize(1);
        assertThat(section.getStyles().keySet()).extracting("class").contains(BooleanType.class);
    }

    @Test
    public void testWidgetStyleInSectionExistance() {
        Section section = (Section) withStylesForSection.getPages().get(0).getSegments().get(0);
        StyledWidget widget = section.getStyles().get(BOOLEAN_TYPE);

        assertThat(widget.getWidgetStyle()).isNotNull();
    }

    @Test
    public void testStyleVisibleOnlyInSection() {
        Page page1 = withStylesForSection.getPages().get(0);
        Section section = (Section) page1.getSegments().get(0);

        assertThat(section.getStyles().size()).isEqualTo(1);
        assertThat(page1.getStyles().size()).isEqualTo(0);
    }

    @Test
    public void testStylesForQuestionsWidgetType() {
        Page page1 = withStylesForQuestions.getPages().get(0);
        Question q1 = (Question) page1.getSegments().get(0);
        Question q2 = (Question) page1.getSegments().get(1);

        assertThat(q1.getStyledWidget().getWidgetType().get()).isExactlyInstanceOf(RadioButtonType.class);
        assertThat(q2.getStyledWidget().getWidgetType().get()).isExactlyInstanceOf(DropdownType.class);
    }

    @Test
    public void testStylesForQuestionsStrings() {
        Page page1 = withStylesForQuestions.getPages().get(0);
        Question q1 = (Question) page1.getSegments().get(0);
        Question q2 = (Question) page1.getSegments().get(1);

        RadioButtonType rb = (RadioButtonType) q1.getStyledWidget().getWidgetType().get();
        DropdownType dd = (DropdownType) q2.getStyledWidget().getWidgetType().get();

        assertThat(rb.getYes()).isEqualTo("True");
        assertThat(rb.getNo()).isEqualTo("False");
        assertThat(dd.getYes()).isEqualTo("Yes");
        assertThat(dd.getNo()).isEqualTo("No");

    }

    private Stylesheet build(final String input) {
        return parseForm(new ANTLRInputStream(input));
    }

    private Stylesheet parseForm(final ANTLRInputStream input) {
        final QLSLexer lexer = new QLSLexer(input);
        final QLSParser parser = new QLSParser(new CommonTokenStream(lexer));
        final ParseTree tree = parser.stylesheet();

        return (Stylesheet) new ASTBuilderVisitor().visit(tree);
    }

}
