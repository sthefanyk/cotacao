package ifpr.pgua.eic.cotacao.models;

import java.sql.Date;

public class Cotacao {
    private String name;
    private String min;
    private String max;
    private String bid;
    private String datetime;
    
    public Cotacao() {
    }

    public Cotacao(String name, String min, String max, String bid, String datetime) {
        this.name = name;
        this.min = min;
        this.max = max;
        this.bid = bid;
        this.datetime = datetime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
}
