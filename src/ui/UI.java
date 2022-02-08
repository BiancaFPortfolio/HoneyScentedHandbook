package ui;
import util.Tree;
import javafx.application.Application;
import javafx.stage.Stage;

public class UI extends Application {
    //Tree to store dictionary data
    Tree tree;
    //Will be updated will what's typed by the user
    String input;
    
    //No argument constructor required
    public UI() {
        //Pass in null for root tree node because root will not have 
        tree = new Tree(null);
        input = "";
    }

    @Override
    public void start(Stage arg0) throws Exception {
        
    }
}
