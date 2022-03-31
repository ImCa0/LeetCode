import java.text.DecimalFormat;

class Debug {
  public static void main(String[] args) {
    DecimalFormat df = new DecimalFormat("0.00");
    System.out.print(df.format(0.2554));
  }
}
