import java.util.Locale;

/** Exercise (Chapter 13: Refactoring Techniques) — structure without behaviour changes. */
public class OrderSummary {

  private static final double PREMIUM_THRESHOLD = 100.0;
  private static final double DISCOUNT_THRESHOLD = 200.0;
  private static final double DISCOUNT_RATE = 0.10;
  private static final double TAX_RATE = 0.13;

  /**
   * Builds the same summary as the original implementation.
   *
   * @param customer the customer's name
   * @param itemNames the item names
   * @param itemPrices the corresponding prices
   * @return a formatted order summary
   */
  public static String summarize(String customer, String[] itemNames, double[] itemPrices) {
    double subtotal = calculateSubtotal(itemPrices);
    int premiumCount = countPremiumItems(itemPrices);
    double discount = subtotal > DISCOUNT_THRESHOLD ? subtotal * DISCOUNT_RATE : 0.0;
    double taxable = subtotal - discount;
    double tax = taxable * TAX_RATE;
    double total = taxable + tax;
    return formatReport(customer, itemNames, itemPrices, premiumCount,
        subtotal, discount, tax, total);
  }

  private static double calculateSubtotal(double[] prices) {
    double subtotal = 0.0;
    for (double price : prices) {
      subtotal += price;
    }
    return subtotal;
  }

  private static int countPremiumItems(double[] prices) {
    int count = 0;
    for (double price : prices) {
      if (price >= PREMIUM_THRESHOLD) {
        count++;
      }
    }
    return count;
  }

  private static String formatItemLine(String name, double price) {
    return String.format(Locale.US, "%s: $%.2f\n", name, price);
  }

  private static String formatReport(String customer, String[] names, double[] prices,
      int premiumCount, double subtotal, double discount, double tax, double total) {
    StringBuilder report = new StringBuilder();
    report.append("Order summary for ").append(customer).append("\n");
    report.append("----------------------\n");
    for (int i = 0; i < names.length; i++) {
      report.append(formatItemLine(names[i], prices[i]));
    }
    report.append(String.format(Locale.US, "Items: %d\n", names.length));
    report.append(String.format(Locale.US, "Premium items: %d\n", premiumCount));
    report.append(String.format(Locale.US, "Subtotal: $%.2f\n", subtotal));
    report.append(String.format(Locale.US, "Discount: $%.2f\n", discount));
    report.append(String.format(Locale.US, "Tax: $%.2f\n", tax));
    report.append(String.format(Locale.US, "Total: $%.2f", total));
    return report.toString();
  }
}
