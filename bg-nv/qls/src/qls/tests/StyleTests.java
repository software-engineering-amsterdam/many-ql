package qls.tests;

import org.junit.Test;
import ql.ast.type.BoolType;
import ql.ast.type.DecType;
import ql.ast.type.IntType;
import ql.ast.type.StrType;
import qls.ast.rule.*;
import qls.semantics.Style;
import qls.semantics.StyleStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bore on 29/03/15.
 */
public class StyleTests
{
    private static final BoolType boolType = new BoolType();
    private static final IntType intType = new IntType();
    private static final DecType decType = new DecType();
    private static final StrType strType = new StrType();

    private static final Width width100 = new Width(100, 0);
    private static final BackColor backColorBlue = new BackColor(new ColorValue("#0000FF"), 0);
    private static final BackColor backColorRed = new BackColor(new ColorValue("#FF0000"), 0);
    private static final Font fontArial = new Font("Arial", 0);
    private static final FontSize fontSize10 = new FontSize(10, 0);

    @Test
    public void mergeStylesDiffTypes()
    {
        Style s1 = new StyleBuilder().WithRules(boolType, this.buildRules(width100)).build();
        Style s2 = new StyleBuilder().WithRules(intType, this.buildRules(fontArial)).build();

        Style res = Style.mergeStyles(s1, s2);
        Rules boolRules = res.getRulesForType(boolType);
        assertRules(boolRules, width100);
        Rules intRules = res.getRulesForType(intType);
        assertRules(intRules, fontArial);
    }

    @Test
    public void mergeStylesSameType()
    {
        Style s1 = new StyleBuilder().WithRules(boolType, this.buildRules(width100)).build();
        Style s2 = new StyleBuilder().WithRules(boolType, this.buildRules(fontArial)).build();

        Style res = Style.mergeStyles(s1, s2);
        Rules boolRules = res.getRulesForType(boolType);
        assertRules(boolRules, width100, fontArial);
    }

    @Test
    public void mergeStylesSameTypeConflictingRules()
    {
        Style s1 = new StyleBuilder().WithRules(boolType, this.buildRules(backColorBlue)).build();
        Style s2 = new StyleBuilder().WithRules(boolType, this.buildRules(backColorRed)).build();

        Style res = Style.mergeStyles(s1, s2);
        Rules boolRules = res.getRulesForType(boolType);
        assertRules(boolRules, backColorBlue);
    }

    @Test
    public void mergeStylesSameTypeRules()
    {
        Style s1 = new StyleBuilder().WithRules(boolType, this.buildRules(backColorRed, width100)).build();
        Style s2 = new StyleBuilder().WithRules(boolType, this.buildRules(backColorBlue, fontArial)).build();

        Style res = Style.mergeStyles(s1, s2);
        Rules boolRules = res.getRulesForType(boolType);
        assertRules(boolRules, backColorRed, width100, fontArial);
    }

    @Test
    public void mergeStylesMultipleTypes()
    {
        Style s1 = new StyleBuilder()
                .WithRules(decType, this.buildRules(backColorRed))
                .WithRules(intType, this.buildRules(fontArial))
                .build();
        Style s2 = new StyleBuilder()
                .WithRules(strType, this.buildRules(backColorBlue))
                .WithRules(boolType, this.buildRules(width100))
                .build();

        Style res = Style.mergeStyles(s1, s2);

        Rules decRules = res.getRulesForType(decType);
        assertRules(decRules, backColorRed);
        Rules intRules = res.getRulesForType(intType);
        assertRules(intRules, fontArial);
        Rules strRules = res.getRulesForType(strType);
        assertRules(strRules, backColorBlue);
        Rules boolRules = res.getRulesForType(boolType);
        assertRules(boolRules, width100);
    }

    @Test
    public void mergeStylesMultipleTypesConflictingRules()
    {
        Style s1 = new StyleBuilder()
                .WithRules(decType, this.buildRules(backColorRed))
                .WithRules(intType, this.buildRules(fontArial))
                .build();
        Style s2 = new StyleBuilder()
                .WithRules(decType, this.buildRules(backColorBlue))
                .WithRules(boolType, this.buildRules(width100))
                .build();

        Style res = Style.mergeStyles(s1, s2);

        Rules decRules = res.getRulesForType(decType);
        assertRules(decRules, backColorRed);
        Rules intRules = res.getRulesForType(intType);
        assertRules(intRules, fontArial);
        Rules boolRules = res.getRulesForType(boolType);
        assertRules(boolRules, width100);
    }

    @Test
    public void styleStackPrecedenceBug()
    {
        Style s1 = new StyleBuilder().WithRules(boolType, this.buildRules(width100, backColorRed)).build();
        Style s2 = new StyleBuilder().WithRules(intType, this.buildRules(fontArial)).build();
        Style s3 = new StyleBuilder().WithRules(boolType, this.buildRules(backColorBlue, fontSize10)).build();

        StyleStack stack = new StyleStack();
        stack.push(s1);
        stack.push(s2);
        stack.push(s3);

        Rules intRules = stack.peekRulesForType(intType);
        assertRules(intRules, fontArial);
        Rules boolRules = stack.peekRulesForType(boolType);
        assertRules(boolRules, width100, backColorBlue, fontSize10);

        stack.pop();
        boolRules = stack.peekRulesForType(boolType);
        assertRules(boolRules, width100, backColorRed);
    }

    @Test
    public void mergeColorRules()
    {
        Rules r1 = buildRules(backColorBlue);
        Rules r2 = buildRules(backColorRed);
        Rules result = Rules.mergeRules(r1, r2);
        assertRules(result, backColorBlue);
    }

    @Test
    public void mergeColorRulesReverse()
    {
        Rules r1 = buildRules(backColorBlue);
        Rules r2 = buildRules(backColorRed);
        Rules result = Rules.mergeRules(r2, r1);
        assertRules(result, backColorRed);
    }

    @Test
    public void mergeNonOverlappingRules()
    {
        Rules r2 = buildRules(fontArial);
        Rules r1 = buildRules(width100);
        Rules result = Rules.mergeRules(r2, r1);
        assertRules(result, width100, fontArial);
    }

    @Test
    public void mergeRules()
    {
        Rules r2 = buildRules(fontArial, backColorBlue);
        Rules r1 = buildRules(width100, backColorRed);
        Rules result = Rules.mergeRules(r2, r1);
        assertRules(result, width100, fontArial, backColorBlue);
    }

    private Rules buildRules(qls.ast.rule.Rule... rs)
    {
        List<qls.ast.rule.Rule> result = new ArrayList<>();
        for (qls.ast.rule.Rule r : rs)
        {
            result.add(r);
        }

        return new Rules(result);
    }

    private void assertRules(Rules actual, qls.ast.rule.Rule... expected)
    {
        for (qls.ast.rule.Rule rule : expected)
        {
            assert this.contains(actual, rule);
        }
    }

    private boolean contains(Rules rs, qls.ast.rule.Rule r)
    {
        for (qls.ast.rule.Rule rule : rs)
        {
            if (rule.equals(r))
            {
                return true;
            }
        }
        return false;
    }
}
