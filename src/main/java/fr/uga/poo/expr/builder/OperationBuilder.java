package fr.uga.poo.expr.builder;

import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

import fr.uga.poo.expr.ArithmeticExpression;
import fr.uga.poo.expr.binary.BinaryOperation;
import fr.uga.poo.expr.binary.IntegerProduct;
import fr.uga.poo.expr.binary.IntegerSum;
import fr.uga.poo.expr.binary.RationalProduct;
import fr.uga.poo.expr.binary.RationalSum;
import fr.uga.poo.expr.constants.ConstArithmeticExpression;
import fr.uga.poo.expr.constants.IntegerConst;
import fr.uga.poo.expr.constants.RationalConst;

public abstract class OperationBuilder extends BinaryOperation<ArithmeticExpression, ArithmeticExpression>
		implements ArithmeticExpression {

	public OperationBuilder(ArithmeticExpression aleft, ArithmeticExpression aright) {
		super(aleft, aright);

	}

	public static BinaryOperation<?, ?> sum(ArithmeticExpression aleft, ArithmeticExpression aright) {

		ConstArithmeticExpression left = aleft.value();
		ConstArithmeticExpression right = aright.value();
		// integer sum
		if (left.getClass().equals(IntegerConst.class) && right.getClass().equals(IntegerConst.class)) {
			return new IntegerSum((IntegerConst) left, (IntegerConst) right);
		}
		// rational sum
		else {
			return new RationalSum(left.getRationalValue(), right.getRationalValue());
		}

	}

	public static BinaryOperation<?, ?> product(ArithmeticExpression aleft, ArithmeticExpression aright) {

		ConstArithmeticExpression left = aleft.value();
		ConstArithmeticExpression right = aright.value();

		if (left.getClass().equals(IntegerConst.class) && right.getClass().equals(IntegerConst.class)) {
			return new IntegerProduct((IntegerConst) left, (IntegerConst) right);
		} else {
			return new RationalProduct(left.getRationalValue(), right.getRationalValue());
		}

	}

	public static BinaryOperation<?, ?> soustraction(ArithmeticExpression aleft, ArithmeticExpression aright) {
		ConstArithmeticExpression left = aleft.value();
		ConstArithmeticExpression right = aright.value();

		if (left.getClass().equals(IntegerConst.class) && right.getClass().equals(IntegerConst.class)) {
			IntegerConst term2 = ((IntegerConst) right);
			term2.setValue(-term2.getValue());
			return new IntegerSum((IntegerConst) left, term2);
		} else {
			RationalConst term2 = right.getRationalValue();
			term2.setNum(-term2.getNum());
			return new RationalSum(left.getRationalValue(), term2);
		}
	}

	public static BinaryOperation<?, ?> division(ArithmeticExpression aleft, ArithmeticExpression aright) {
		ConstArithmeticExpression left = aleft.value();
		ConstArithmeticExpression right = aright.value();

		if (left.getClass().equals(IntegerConst.class) && right.getClass().equals(IntegerConst.class)) {
			// trick! division int to rational!
			RationalConst term1 = new RationalConst(((IntegerConst) left).getValue(),
					((IntegerConst) right).getValue());

			return new RationalSum(term1, RationalConst.ZERO);
		} else {
			//
			RationalConst term1 = left.getRationalValue();
			term1 = new RationalConst(term1.getNum(), term1.getDenum());

			RationalConst term2 = left.getRationalValue();
			term2 = new RationalConst(term2.getDenum(), term2.getNum());
			return new RationalProduct(term1, term2);

		}
	}
}
