package fr.uga.poo.expr.constants;

public class IntegerConst extends ConstArithmeticExpression {

	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public IntegerConst(int a) {
		this.value = a;
	}

	@Override
	public RationalConst getRationalValue() {
		return new RationalConst(this.value, 1);

	}

	public String toString() {
		return "" + this.value;
	}

}
