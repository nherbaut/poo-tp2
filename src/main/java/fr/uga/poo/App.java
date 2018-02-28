package fr.uga.poo;
import fr.uga.poo.expr.builder.OperationBuilder;
import fr.uga.poo.expr.constants.ConstArithmeticExpression;
import fr.uga.poo.expr.constants.IntegerConst;
import fr.uga.poo.expr.constants.RationalConst;

public class App {
	public static void main(String[] args) {

		IntegerConst int1 = new IntegerConst(3);
		IntegerConst int2 = new IntegerConst(4);

		assert OperationBuilder.sum(int1, int2).value().toString().equals("7");

		RationalConst r1 = new RationalConst(1, 2);
		RationalConst r3 = new RationalConst(3, 2);
		assert OperationBuilder.sum(r1, r1).value().toString().equals("2/1");

		assert OperationBuilder.sum(OperationBuilder.sum(r1, int1).value(), r3).value().toString().equals("5/1");

		IntegerConst nine = new IntegerConst(9);
		IntegerConst two = new IntegerConst(2);
		IntegerConst three = new IntegerConst(3);
		IntegerConst one = new IntegerConst(1);
		IntegerConst five = new IntegerConst(5);
		IntegerConst twelve = new IntegerConst(12);
		
		ConstArithmeticExpression res = OperationBuilder.product(
				OperationBuilder.sum(nine, two),
				OperationBuilder.soustraction(
								three,
								OperationBuilder.division(
										one,
										OperationBuilder.sum(
												five,
												twelve)
										
									)
								)).value();
		System.out.println(res.toString());

	}
}
