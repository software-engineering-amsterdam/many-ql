package lang.ql.semantics.values;

/**
 * Created by bore on 23/02/15.
 */
public class Bl
{

    class EvalVisitor {
        Map<String, Value> env;

        EvalVisitor(Map<String, Value> env) {
            this.env = env;
        }

        Value visit(Add e) {
            return e.lhs.accept(this).add(e.rhs.accept(this));
        }

        Value visit(Var v) {
            return env.get(v.name);
        }
    }


    abstract class Exp {
        abstract Value eval();
    }

    class Add extends Exp {
        Exp lhs,rhs;

        @Override
        Value eval()
        {
            return lhs.eval().add(rhs.eval());
        }
    }

    class Var extends Exp {

        @Override
        Value eval()
        {
            return null;
        }
    }



}


