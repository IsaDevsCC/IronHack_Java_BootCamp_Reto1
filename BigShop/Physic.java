package BigShop;

import java.math.BigDecimal;
import java.math.MathContext;

public class Physic extends Item {

    final BigDecimal PLUS = new BigDecimal(20);
    final BigDecimal PERCENTAGE = new BigDecimal(100);
    public Physic(String name, BigDecimal price) {
        super(name, price);
        setPrice();
    }

    public void setPrice() {
        super.setPrice(super.getPrice().add(super.getPrice().multiply(PLUS).divide(PERCENTAGE)));
    }

    @Override
    public String toString() {
        return "Physic{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
