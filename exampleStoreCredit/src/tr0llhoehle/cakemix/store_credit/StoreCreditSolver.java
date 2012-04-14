package tr0llhoehle.cakemix.store_credit;

public class StoreCreditSolver implements tr0llhoehle.cakemix.utility.googleCodeJam.Solver<StoreCreditProblem> {

    @Override
    public String solve(StoreCreditProblem p) {
	return "I'm actually not solving anything... But I can tell you how many credit the problem instace had: " + p.getCredit();
    }
}
