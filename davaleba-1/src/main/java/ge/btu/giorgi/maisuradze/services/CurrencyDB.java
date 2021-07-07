package ge.btu.giorgi.maisuradze.services;

import ge.btu.giorgi.maisuradze.models.Currency;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// singleton pattern
public class CurrencyDB {

    private static CurrencyDB INSTANCE = null;

    private List<Currency> currencies;

    public static CurrencyDB getInstance() {

        if (INSTANCE == null) {
            INSTANCE = new CurrencyDB();

            List<Currency> initCurrencies = new ArrayList<>();

            initCurrencies.add(new Currency("USD", "დოლარი", "0.01252",1));
            initCurrencies.add(new Currency("EUR", "ევრო", "0.162",0));
            initCurrencies.add(new Currency("GBP", "ფუნტი", "3.01252",1));
            initCurrencies.add(new Currency("RUB", "რუბლი", "25.01252",-1));
            initCurrencies.add(new Currency("TRY", "თურქული ლირა", "5.01252",-1));

            INSTANCE.currencies = initCurrencies;
        }

        return INSTANCE;
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public Currency getCurrencyByTitle(String title) {
        return currencies.stream().filter(
                c -> c.getTitle().equals(title)).collect(Collectors.toList()
        ).stream().findAny().orElse(null);
    }
}
