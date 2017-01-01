package  ru.chedmitriy.start;

/**
 * Created by dimsan on 19.09.2016.
 */
public class StartUi  {
    private final Tracker tracker;
    private  final ConsoleInput cIn;


    public StartUi(ConsoleInput cIn){
        this.cIn = cIn;
        tracker = new Tracker();
    }
	/*
	* Method, which shows us the greeting at startup
	**/
	public void greeting(){
    System.out.println("WELCOME TO TRACKER");
	}
	/*
	* Method, which shows us some text at the close of the program
	**/
    public void exitAppText(){
        System.out.println("creating by dmiCher");

    }
	/*
	*Method that initial basic startup functions
	**/
    public  void init() {
        greeting();
        MenuTracker mTracker = new MenuTracker(this.cIn,this.tracker);
        mTracker.menuActionFilling();
        do {
            mTracker.showMenu();
            int key = cIn.chooseOption("Type a command: ");
            mTracker.optionSelect(key);
        } while (!"y".equals(cIn.ask("Exit(y): ")));
        exitAppText();
    }
    public static void main(String[] args)  {
        ConsoleInput cIn = new ConsoleInput();
        new StartUi(cIn).init();
    }
}
