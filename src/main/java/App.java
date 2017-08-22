import controller.FormController;
import view.Form;

public class App  {

    public static void main(String[] args) {
        FormController controller = new FormController();
        Form f = new Form(controller);
        f.showForm();
    }
}