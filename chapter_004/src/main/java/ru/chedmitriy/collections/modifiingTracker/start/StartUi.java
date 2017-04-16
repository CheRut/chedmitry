package ru.chedmitriy.collections.modifiingTracker.start;

import ru.chedmitriy.collections.modifiingTracker.objects.ConsoleInput;
import ru.chedmitriy.collections.modifiingTracker.objects.MenuTracker;
import ru.chedmitriy.collections.modifiingTracker.objects.Tracker;


public class StartUi  {
    private final Tracker tracker;
    private  final ConsoleInput cIn;


    private StartUi(ConsoleInput cIn){
        this.cIn = cIn;
        tracker = new Tracker();
    }

    private void greeting(){
        System.out.println("WELCOME TO TRACKER");
    }

    private void exitAppText(){
        System.out.println("creating by dmiCher");

    }

    private void init() {
        greeting();
        MenuTracker mTrack = new MenuTracker(this.cIn,this.tracker);
        mTrack.menuActionFilling();
        do {
            mTrack.showMenu();
            int key = cIn.chooseOption("Введите команду: ");
            mTrack.optionSelect(key);
        } while (!"y".equals(cIn.ask("Exit(y): ")));
        exitAppText();
    }
    public static void main(String[] args)  {
        ConsoleInput cIn = new ConsoleInput();
        new StartUi(cIn).init();
    }


}
