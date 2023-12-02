package org.abbo.nng.util;

import org.nng.abbo.domain.product.NngAbboProduct;
import org.nng.abbo.domain.product.NngAbboProductCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NngAbboTradeSimulatorParameterGenerator {
    private static List<Double> priceParameters = new ArrayList<>();
    private static List<String> currencyParameters = new ArrayList<>();
    private static List<NngAbboProductCategory> productCategories = List.of(
            NngAbboProductCategory.PACKAGING,
            NngAbboProductCategory.CREAM,
            NngAbboProductCategory.HEALTH,
            NngAbboProductCategory.COSMETIC,
            NngAbboProductCategory.FLYERS
            );

    public static Integer getTotalNumberOfProductCategories() {
        return productCategories.size();
    }

    public static NngAbboProductCategory getRandomProductType(Integer index) {
        return productCategories.get(index);
    }


    public static NngAbboProduct getCosmeticProduct() {
        return NngAbboTradeSimulatorEntityGenerator.createCosmeticProduct(UUID.randomUUID().toString(),
                "Lipstick",
                "Red organic lipstick", NngAbboTradeSimulatorEntityGenerator.createPrice("NOK", 300D));
    }

    public static NngAbboProduct getHealthProduct() {
        return NngAbboTradeSimulatorEntityGenerator.createHealthProduct(UUID.randomUUID().toString(),
                "Vitamins",
                "60 multivitamins", NngAbboTradeSimulatorEntityGenerator.createPrice("EURO", 25D));
    }

    public static NngAbboProduct getCreamProduct() {
        return NngAbboTradeSimulatorEntityGenerator.createCosmeticProduct(UUID.randomUUID().toString(),
                "Lipstick",
                "Red organic lipstick", NngAbboTradeSimulatorEntityGenerator.createPrice("SEK", 300D));
    }

    public static NngAbboProduct getFlyersProduct() {
        return NngAbboTradeSimulatorEntityGenerator.createCosmeticProduct(UUID.randomUUID().toString(),
                "Lipstick",
                "Red organic lipstick", NngAbboTradeSimulatorEntityGenerator.createPrice("DKK", 300D));
    }

    public static NngAbboProduct getPackagingProduct() {
        return NngAbboTradeSimulatorEntityGenerator.createCosmeticProduct(UUID.randomUUID().toString(),
                "Lipstick",
                "Red organic lipstick", NngAbboTradeSimulatorEntityGenerator.createPrice("NOK", 300D));
    }
}
