package ar.uba.fi.tdd.rulogic.model.entities;

import java.util.List;

public class DataBase {

	private List<Fact> facts;
	private List<Rule> rules;
	private List<Malformation> malformations;

	public DataBase(List<Fact> facts, List<Rule> rules, List<Malformation> malformations) {
		this.facts = facts;
		this.rules = rules;
		this.malformations = malformations;
	}

	public List<Fact> getFacts() {
		return facts;
	}

	public List<Rule> getRules() {
		return rules;
	}

	public List<Malformation> getMalformations() {
		return malformations;
	}

	public boolean hasMalformations() {
		return malformations.size() > 0;
	}

	public boolean factQuery(Fact query) {
		for (Fact fact : facts) {
			if (fact.equals(query)) return true;
		}
		
		return false;
	}

	private Rule findRuleWithPredicate(String predicate) {
		for (Rule rule : rules) {
			if (rule.getSignature().getPredicate().equals(predicate)) return rule;
		}
		return null;
	}

	public boolean ruleQuery(Fact query) {
		Rule rule = findRuleWithPredicate(query.getPredicate());
		if (rule == null) return false;

		List<Fact> evaluatedRule = rule.evaluate(query.getArgs());
		for (Fact fact : evaluatedRule) {
			if (!factQuery(fact)) return false;
		}

		return true;
	}

}
