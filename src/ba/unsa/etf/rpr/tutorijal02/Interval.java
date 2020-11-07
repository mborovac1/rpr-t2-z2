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

    public static Interval intersect(Interval i1, Interval i2) {
        Interval temp = new Interval();

        if(i1.pocetnaTacka < i2.pocetnaTacka && i1.krajnjaTacka < i2.krajnjaTacka) {
            temp.pocetnaTacka = i2.pocetnaTacka;
            if(i2.pripadaPocetna)
                temp.pripadaPocetna = true;
            else
                temp.pripadaPocetna = false;

            temp.krajnjaTacka = i1.krajnjaTacka;
            if(i1.pripadaKrajnja)
                temp.pripadaKrajnja = true;
            else
                temp.pripadaKrajnja = false;
        }
        else if(i2.pocetnaTacka < i1.pocetnaTacka && i2.krajnjaTacka < i1.krajnjaTacka) {
            temp.pocetnaTacka = i1.pocetnaTacka;
            if(i1.pripadaPocetna)
                temp.pripadaPocetna = true;
            else
                temp.pripadaPocetna = false;

            temp.krajnjaTacka = i2.krajnjaTacka;
            if(i2.pripadaKrajnja)
                temp.pripadaKrajnja = true;
            else
                temp.pripadaKrajnja = false;
        }
        else if(i1.pocetnaTacka < i2.pocetnaTacka && i1.krajnjaTacka > i2.krajnjaTacka) {
            temp = i2;
        }
        else if(i2.pocetnaTacka < i1.pocetnaTacka && i2.krajnjaTacka > i1.krajnjaTacka) {
            temp = i1;
        }
        else if(i1 == i2) {
            temp = i1;
        }

        return temp;
    }

    public Interval intersect(Interval i) {
        return intersect(this, i);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        if(isNull()) {
            s.append("()");
            return String.valueOf(s);
        }
        else {
            if (pripadaPocetna)
                s.append("[");
            else
                s.append("(");
            s.append(pocetnaTacka + "," + krajnjaTacka);
            if (pripadaKrajnja)
                s.append("]");
            else
                s.append(")");
            return String.valueOf(s);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Interval) {
            return pocetnaTacka == ((Interval) obj).pocetnaTacka && krajnjaTacka == ((Interval) obj).krajnjaTacka && pripadaPocetna == ((Interval) obj).pripadaPocetna && pripadaKrajnja == ((Interval) obj).pripadaKrajnja;
        }
        else
            return false;
    }
}