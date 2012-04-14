To use this project simply pull and use the sources. They should work with JDK Compliance 1.6 or higher.

For the code to work correctly your implementations of the ConcreteProblem and the ConcreteSolver need to meet certain requirements.

* ConcreteSolver:
This is quite simple: Just implement the only method defined in the Solver to solve the given ConcreteProblem.

* ConcreteProblem:
This isn't as beautiful as I hoped it would be.
Your concrete implementation of the class Problem need to initialise the attribute types:SupportedTypes[] with an array of types defining the structure of one instance of your ConcreteProblem.
That initialisation needs to perfectly match the structure of the input file or the data in your ConcreteProblem-instances will be wrong.
So when we take the Store Credit problem as an example ([Link to the problem at google codejam](http://code.google.com/codejam/contest/351101/dashboard#s=p0)) the input file looks like this:
<pre>3
100
3
5 75 25
200
7
150 24 79 50 88 345 3
8
8
2 1 9 4 4 56 90 3</pre>

In the first line the number of problems in this input is identified. This number can be ignored for the IOManager-class will automatically parse it.
Then comes the definition of the first problem:
<pre>INT (100)
INT (3)
LIST_INT (5 75 25)</pre>

So a concrete StoreCreditProblem would have the types-array initialised like that:

<pre>public StoreCreditProblem() {
	this.types = new SupportedTypes[3];
	this.types[0] = SupportedTypes.INT;
	this.types[1] = SupportedTypes.INT;
	this.types[2] = SupportedTypes.LIST_INT;
}</pre>


The second thing to do within the ConcreteProblem is to override the addValue-method. Here you can determine which data goes into which attribute. For the StoreCreditProblem I did create three attributes:
<pre>private int credit;
private int numberOfItemsInStore;
private ArrayList<Integer> pricesOfItemsInStore;</pre>

Then I did override the addValue-method so the IOManager can add the values defined within the types-array to the StoreCreditProblem:
<pre>@Override
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
}</pre>

The local variable cntr counts how many values have already been put into this problem and is handled by super.addValue(o), so don't forget to call it.