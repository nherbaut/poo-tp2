package fr.uga.poo.expr.binary;
import fr.uga.poo.expr.constants.ConstArithmeticExpression;
import fr.uga.poo.expr.constants.IntegerConst;

public class IntegerSum extends BinaryOperation<IntegerConst, IntegerConst> {

	public IntegerSum(IntegerConst left, IntegerConst right) {
		super(left, right);
	}

	@Override
	public ConstArithmeticExpression value() {

		return new IntegerConst(this.left.getValue() + this.right.getValue());

	}

}
