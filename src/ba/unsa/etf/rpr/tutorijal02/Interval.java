package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double pocetnaTacka, krajnjaTacka;
    private boolean pripadaPocetna, pripadaKrajnja;

    public Interval(double pocetnaTacka, double krajnjaTacka, boolean pripadaPocetna, boolean pripadaKrajnja) {
        if(pocetnaTacka > krajnjaTacka)
            throw new IllegalArgumentException("");
        this.pocetnaTacka = pocetnaTacka;
        this.krajnjaTacka = krajnjaTacka;
        this.pripadaPocetna = pripadaPocetna;
        this.pripadaKrajnja = pripadaKrajnja;
    }

    public Interval() {
        pocetnaTacka = 0;
        krajnjaTacka = 0;
        pripadaPocetna = false;
        pripadaKrajnja = false;
    }

    public boolean isNull() {
        return pocetnaTacka == 0 && krajnjaTacka == 0 && pripadaPocetna == false && pripadaKrajnja == false;
    }

    public boolean isIn(double tacka) {
        if(pripadaPocetna && !pripadaKrajnja)
            return tacka >= pocetnaTacka && tacka < krajnjaTacka;
        else if(pripadaPocetna && pripadaKrajnja)
            return tacka >= pocetnaTacka && tacka <= krajnjaTacka;
        else if(!pripadaPocetna && pripadaKrajnja)
            return tacka > pocetnaTacka && tacka <= krajnjaTacka;
        else
            return tacka > pocetnaTacka && tacka < krajnjaTacka;
    }

}
