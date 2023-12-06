package Q1;

import java.util.*;

public class Polynom {
    private List<Term> terms = new ArrayList<>();

    public Polynom(double[] coefficients, int[] powers) throws Exception {
        if (coefficients.length != powers.length) {
            throw new Exception("Coefficients and powers arrays must have the same length");
        }
        for (int i = 0; i < coefficients.length; i++) {
            terms.add(new Term(coefficients[i], powers[i]));
        }
        terms.sort(Comparator.comparingInt(Term::getPower).reversed());
    }

    // Implement plus, minus, derivative, toString, and equals methods here
    public Polynom plus(Polynom other) {
        Map<Integer, Double> powerToCoefficient = new HashMap<>();
        for (Term term : this.terms) {
            powerToCoefficient.put(term.getPower(), term.getCoefficient());
        }
        for (Term term : other.terms) {
            powerToCoefficient.merge(term.getPower(), term.getCoefficient(), Double::sum);
        }
        int size = powerToCoefficient.size();
        double[] coefficients = new double[size];
        int[] powers = new int[size];
        int index = 0;
        for (Map.Entry<Integer, Double> entry : powerToCoefficient.entrySet()) {
            coefficients[index] = entry.getValue();
            powers[index] = entry.getKey();
            index++;
        }
        try {
            return new Polynom(coefficients, powers);
        } catch (Exception e) {
            throw new RuntimeException("Unexpected exception", e);
        }
    }

    public Polynom minus(Polynom other) {
        Map<Integer, Double> powerToCoefficient = new HashMap<>();
        for (Term term : this.terms) {
            powerToCoefficient.put(term.getPower(), term.getCoefficient());
        }
        for (Term term : other.terms) {
            powerToCoefficient.merge(term.getPower(), -term.getCoefficient(), Double::sum);
        }
        int size = powerToCoefficient.size();
        double[] coefficients = new double[size];
        int[] powers = new int[size];
        int index = 0;
        for (Map.Entry<Integer, Double> entry : powerToCoefficient.entrySet()) {
            coefficients[index] = entry.getValue();
            powers[index] = entry.getKey();
            index++;
        }
        try {
            return new Polynom(coefficients, powers);
        } catch (Exception e) {
            throw new RuntimeException("Unexpected exception", e);
        }
    }

    public Polynom derivative() {
        List<Term> derivativeTerms = new ArrayList<>();
        for (Term term : this.terms) {
            if (term.getPower() != 0) {
                derivativeTerms.add(new Term(term.getCoefficient() * term.getPower(), term.getPower() - 1));
            }
        }
        double[] coefficients = new double[derivativeTerms.size()];
        int[] powers = new int[derivativeTerms.size()];
        for (int i = 0; i < derivativeTerms.size(); i++) {
            coefficients[i] = derivativeTerms.get(i).getCoefficient();
            powers[i] = derivativeTerms.get(i).getPower();
        }
        try {
            return new Polynom(coefficients, powers);
        } catch (Exception e) {
            throw new RuntimeException("Unexpected exception", e);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Term term : terms) {
            if (term.getCoefficient() != 0) {
                if (sb.length() > 0 && term.getCoefficient() > 0) {
                    sb.append(" + ");
                } else if (term.getCoefficient() < 0) {
                    sb.append(" - ");
                }
                if (Math.abs(term.getCoefficient()) != 1 || term.getPower() == 0) {
                    sb.append(Math.abs(term.getCoefficient()));
                }
                if (term.getPower() > 0) {
                    sb.append("x");
                    if (term.getPower() > 1) {
                        sb.append("^").append(term.getPower());
                    }
                }
            }
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Polynom other = (Polynom) obj;
        if (terms.size() != other.terms.size()) {
            return false;
        }
        for (int i = 0; i < terms.size(); i++) {
            Term term1 = terms.get(i);
            Term term2 = other.terms.get(i);
            if (term1.getPower() != term2.getPower() || term1.getCoefficient() != term2.getCoefficient()) {
                return false;
            }
        }
        return true;
    }
}