package tr0llhoehle.cakemix.store_credit;

import java.io.IOException;
import java.text.ParseException;

import tr0llhoehle.cakemix.utility.googleCodeJam.IOManager;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
	IOManager<StoreCreditSolver, StoreCreditProblem> io = new IOManager<StoreCreditSolver, StoreCreditProblem>(
		new StoreCreditSolver(), (Class<StoreCreditProblem>) new StoreCreditProblem().getClass());

	if (args.length > 0) {
	    try {
		io.start(args[0]);
	    } catch (IOException e) {
		e.printStackTrace();
	    } catch (ParseException e) {
		e.printStackTrace();
	    }
	}
    }

}
