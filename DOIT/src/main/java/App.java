public class App {
    private ConsoleView view;
    private Controller controller;
    public static void main(String[] args){
        createAppSimple().run();
    }
    private void run (){
        view.start(controller);
        view.stop();
    }
    private static App createAppSimple(){
        Controller controller= new Controller();
        ConsoleView view = new ConsoleView();
        return new App(view,controller);
    }
    private App(ConsoleView view, Controller controller){
        this.view=view;
        this.controller=controller;
    }
}
