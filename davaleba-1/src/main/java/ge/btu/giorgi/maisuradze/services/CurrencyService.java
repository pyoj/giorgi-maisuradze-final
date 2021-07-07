package ge.btu.giorgi.maisuradze.services;

import ge.btu.giorgi.maisuradze.models.Currency;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class CurrencyService {

    private final CurrencyDB DB = CurrencyDB.getInstance();

    @WebMethod
    public String getCurrency(Currency currency) {
        return DB.getCurrencyByTitle(currency.getTitle()).getTitle();
    }

    @WebMethod
    public String getCurrencyDescription(Currency currency) {
        return DB.getCurrencyByTitle(currency.getTitle()).getDescription();
    }

    @WebMethod
    public String getCurrencyChange(Currency currency) {
        return DB.getCurrencyByTitle(currency.getTitle()).getChange();
    }

    @WebMethod
    public int getCurrencyRate(Currency currency) {
        return DB.getCurrencyByTitle(currency.getTitle()).getRate();
    }

    @WebMethod
    public String getDate() {
        return "date";
    }
}
