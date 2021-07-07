package ge.btu.giorgi.maisuradze.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Currency {

    private String title;

    private String description;

    private String change;

    private Integer rate;

    public Currency() {
    }

    public Currency(String title, String description, String change, Integer rate) {
        this.title = title;
        this.description = description;
        this.change = change;
        this.rate = rate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
}
