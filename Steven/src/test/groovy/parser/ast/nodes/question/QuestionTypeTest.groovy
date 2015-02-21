package parser.ast.nodes.question

import exceptions.NoSuchType
import junit.framework.Assert
import spock.lang.Specification

/**
 * Created by Steven Kok on 21/02/2015.
 */
class QuestionTypeTest extends Specification {

    def "Should return correct QuestionType"() {
        expect:
        def values = QuestionType.values()
        for (QuestionType questionType : values) {
            def type = questionType.getQuestionType(questionType.getType())
            Assert.assertEquals(questionType, type)
        }
    }

    def "Should throw NoSuchType exception when providing unknown type"() {
        when:
        QuestionType.getQuestionType(type)

        then:
        thrown(NoSuchType.class)

        where:
        type     | _
        "A"      | _
        ""       | _
        " "      | _
        "string" | _
        "STRIng" | _
        "CLASS"  | _
    }
}
