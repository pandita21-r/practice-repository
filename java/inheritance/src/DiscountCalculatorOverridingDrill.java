
public class DiscountCalculatorOverridingDrill{
    static class DiscountCalculator {
        private String name;
        private double discountPercentage;

        public DiscountCalculator(String name, double discountPercentage) {
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("Discount name must not be blank.");
            }
            if (discountPercentage < 0 || discountPercentage > 100) {
                throw new IllegalArgumentException("Discount percentage must be between 0 and 100.");
            }
            this.name = name;
            this.discountPercentage = discountPercentage;
        }

        public String getName() {
            return name;
        }

        public double getDiscountPercentage() {
            return discountPercentage;
        }

        public double calculateFinalPrice(double originalPrice) {
            if (originalPrice <= 0) {
                System.out.println(
                        "[" + getName() + "] Invalid original price: " + originalPrice + ". Must be positive.");
                return 0.0;
            }
            double discountAmount = originalPrice * (discountPercentage / 100.0);
            double finalPrice = originalPrice - discountAmount;

            System.out.println("[" + getName() + "] Base discount: original = " + originalPrice + ", discount = "
                    + discountAmount + ", final = " + finalPrice);
            return finalPrice;
        }
    }

    static class LoyalCustomerDiscountCalculator extends DiscountCalculator {
        private double extraDiscountPercentage;

        public LoyalCustomerDiscountCalculator(double discountPercentage, double extraDiscountPercentage) {
            super("Loyal", discountPercentage);
            if (extraDiscountPercentage < 0 || extraDiscountPercentage > 100) {
                throw new IllegalArgumentException("Extra discount must be between 0 and 100.");
            }
            this.extraDiscountPercentage = extraDiscountPercentage;
        }

        @Override
        public double calculateFinalPrice(double originalPrice) {
            if (originalPrice <= 0) {
                super.calculateFinalPrice(originalPrice);
                return 0.0;
            }

            double baseFinal = super.calculateFinalPrice(originalPrice);
            double extraDiscount = baseFinal * (extraDiscountPercentage / 100.0);
            double finalPrice = baseFinal - extraDiscount;

            System.out
                    .println("[" + getName() + "] Extra loyal discount: baseFinal = " + baseFinal + ", extraDiscount = "
                            + extraDiscount + ", final = " + finalPrice);
            return finalPrice;
        }
    }

    static class FlashSaleDiscountCalculator extends DiscountCalculator {
        public FlashSaleDiscountCalculator(double discountPercentage) {
            super("Flash Sale", discountPercentage);
        }

        @Override
        public double calculateFinalPrice(double originalPrice) {
            if (originalPrice <= 0) {
                System.out
                        .println(
                                "[" + getName() + "] Invalid original price: " + originalPrice + ". Must be positive.");
                return 0.0;
            }
            double effectivePercentage;
            if (originalPrice < 100.0) {
                effectivePercentage = getDiscountPercentage();
            } else {
                effectivePercentage = getDiscountPercentage() + 10.0;
            }
            double discountAmount = originalPrice * (effectivePercentage / 100.0);
            double finalPrice = originalPrice - discountAmount;

            if (originalPrice < 100) {
                System.out.println("[" + getName() + "] Normal flash sale discount: original = " + originalPrice
                        + ", discount = " + discountAmount + ", final = " + finalPrice);
            } else if (originalPrice >= 100) {
                System.out.println("[" + getName() + "] High flash sale discount: original = " + originalPrice
                        + ", discount = " + discountAmount + ", final = " + finalPrice);
            }
            return finalPrice;
        }
    }

    public static void main(String[] args) {
        DiscountCalculator base = new DiscountCalculator("Base", 10.0);
        LoyalCustomerDiscountCalculator loyal = new LoyalCustomerDiscountCalculator(10.0, 20.0);
        FlashSaleDiscountCalculator flash = new FlashSaleDiscountCalculator(15.0);

        double validSmall = 50.0;
        double validLarge = 200.0;
        double invalidPrice = -10.0;

        try {
            System.out.println("=== Base Discount ===");
            base.calculateFinalPrice(validSmall);
            base.calculateFinalPrice(invalidPrice);

            System.out.println();
            System.out.println("=== Loyal Discount ===");
            loyal.calculateFinalPrice(validSmall);
            loyal.calculateFinalPrice(validLarge);
            loyal.calculateFinalPrice(invalidPrice);

            System.out.println();
            System.out.println("=== Flash Sale Discount ===");
            flash.calculateFinalPrice(validSmall);
            flash.calculateFinalPrice(validLarge);
            flash.calculateFinalPrice(invalidPrice);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
