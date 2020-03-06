package estudo;

import java.util.Locale;
import java.util.ResourceBundle;

public class Main4 {
  public static void main(String[] args) {
    ResourceBundle bundle = ResourceBundle.getBundle("mensagens");

    System.out.println(bundle.getString("app_title"));
    System.out.println(bundle.getString("name_label"));
    System.out.println(bundle.getString("phone_label"));

    bundle = ResourceBundle.getBundle("mensagens", new Locale("pt", "BR"));

    System.out.println(bundle.getString("app_title"));
    System.out.println(bundle.getString("name_label"));
    System.out.println(bundle.getString("phone_label"));

  }
}
