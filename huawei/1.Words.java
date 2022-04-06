package huawei;

import java.text.DecimalFormat;
import java.util.Scanner;

class Words {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String s = scanner.nextLine();
    scanner.close();
    String[] list = s.split(" ");
    int sum = 0;
    for (int i = 0; i < list.length; i++) {
      sum += list[i].length();
    }
    DecimalFormat df = new DecimalFormat("0.00");
    double res = 1.0 * sum / list.length;
    System.out.println(df.format(res));
  }
}
