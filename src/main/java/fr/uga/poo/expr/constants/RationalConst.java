package fr.uga.poo.expr.constants;

public class RationalConst extends ConstArithmeticExpression {

	public static final RationalConst ZERO = new RationalConst(0, 1);
	private int num;
	private int denum;

	public RationalConst(int num, int denum) {
		this.num = num;
		this.denum = denum;
		this.simplify();
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getDenum() {
		return denum;
	}

	public void setDenum(int denum) {
		this.denum = denum;
	}

	public void simplify() {
		int gcd = gcd(Math.abs(this.num), Math.abs(this.denum));
		this.num = this.num / gcd;
		this.denum = this.denum / gcd;
	}

	private static int gcd(final int a, final int b) {

		if (b == 0) {
			return a;
		} else {
			return gcd(b, a % b);
		}
	}

	@Override
	public RationalConst getRationalValue() {

		return this;
	}

	public String toString() {
		return this.num + "/" + this.denum;
	}

}
