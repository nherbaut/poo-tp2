package fr.uga.poo.expr.constants;

import fr.uga.poo.expr.ArithmeticExpression;

public abstract class ConstArithmeticExpression implements ArithmeticExpression {

	@Override
	public ConstArithmeticExpression value() {
		return this;
	}

	public abstract RationalConst getRationalValue();

}
