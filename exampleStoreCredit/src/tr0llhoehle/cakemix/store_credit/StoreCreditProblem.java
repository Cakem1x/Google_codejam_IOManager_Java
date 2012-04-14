package tr0llhoehle.cakemix.store_credit;

import java.text.ParseException;
import java.util.ArrayList;

import tr0llhoehle.cakemix.utility.googleCodeJam.SupportedTypes;

public class StoreCreditProblem extends tr0llhoehle.cakemix.utility.googleCodeJam.Problem {
    private int credit;
    private int numberOfItemsInStore;
    private ArrayList<Integer> pricesOfItemsInStore;

    public StoreCreditProblem() {
	this.types = new SupportedTypes[3];
	this.types[0] = SupportedTypes.INT;
	this.types[1] = SupportedTypes.INT;
	this.types[2] = SupportedTypes.LIST_INT;
    }

    public int getCredit() {
	return credit;
    }

    public int getNumberOfItemsInStore() {
	return numberOfItemsInStore;
    }

    public ArrayList<Integer> getPricesOfItemsInStore() {
	return pricesOfItemsInStore;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void addValue(Object o) throws ParseException {
	switch (cntr) {
	case 0:
	    credit = (int) o;
	    break;
	case 1:
	    numberOfItemsInStore = (int) o;
	    break;
	case 2:
	    pricesOfItemsInStore = (ArrayList<Integer>) o;
	    break;
	}
	super.addValue(o);
    }
}
