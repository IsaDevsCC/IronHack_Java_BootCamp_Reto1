package BigShop;

import java.math.BigDecimal;

public class Digital extends Item{

    public Digital(String name, BigDecimal price) {
        super(name, price);
    }

    @Override
    public String toString() {
        return "Digital{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
