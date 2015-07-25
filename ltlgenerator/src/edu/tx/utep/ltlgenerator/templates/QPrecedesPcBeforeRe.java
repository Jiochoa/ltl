package edu.tx.utep.ltlgenerator.templates;

import java.util.List;

public class QPrecedesPcBeforeRe extends Template {

	private static String template = "(FR) -> (((!(P &r !Rh)) U ((Q &-l !P) v ((Ri) ^ XRh))))";

	@Override
	public String generateFormula(String pProposition, String qProposition, String rProposition, String lProposition) {
		String formula = template;
		List<String> r = getCompositeProposition(rProposition);
		List<String> p = getCompositeProposition(pProposition);
		List<String> q = getCompositeProposition(qProposition);
		List<String> rh = getHProposition(rProposition);
		String rinverse = String.join("", getParallelInverse(rProposition));
		String rString = String.join("", r);
		String pString = String.join("", p);
		String rhString = String.join("", rh);

		List<String> notRh = rh;
		notRh.add(0, "!");
		String andedRh = operatorGenerator.getAndedPropositions(AND_R, p, notRh);
		formula = formula.replace("(P &r !Rh)", andedRh);

		List<String> notP = p;
		notP.add(0, "!");
		String andedP = operatorGenerator.getAndedPropositions(AND_MINUS_L, q, notP);
		formula = formula.replace("(Q &-l !P)", andedP);

		formula = formula.replace("Rh", rhString);
		formula = formula.replace("Ri", rinverse);
		formula = formula.replace("R", rString);
		formula = formula.replace("P", pString);

		return formula;
	}

}
