package pl.lublin.wsei.java.cwiczenia;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Infografika {
    public String tytuł;
    public String adres_strony;
    public String adres_grafiki;
    public String adres_miniaturki;
    public int szerokość;
    public String wysokość;

    public Infografika(String tekst){
        Pattern pat = Pattern.compile("<title><!\\[CDATA\\[(.*)\\]\\]");
        Matcher m = pat.matcher(tekst);
        if (m.find())
            tytuł = m.group(1);
        else
            tytuł = "";

        pat = Pattern.compile("<link>(.*)</link>");
        m = pat.matcher(tekst);
        if (m.find())
            adres_strony = m.group(1);
        else
            adres_strony = "";

        pat = Pattern.compile("width=\"(.*)\" height");
        m = pat.matcher(tekst);
        if (m.find())
            szerokość = Integer.parseInt(m.group(1));
        else
            szerokość = 0;

        pat = Pattern.compile("height=\"(.*)\"");
        m = pat.matcher(tekst);
        if(m.find())
            wysokość = m.group(1);
        else
            wysokość = "";

        pat = Pattern.compile("<media:thumbnail\\surl=\"(.*)\"");
        m = pat.matcher(tekst);
        if(m.find())
            adres_miniaturki = m.group(1);
        else
            adres_miniaturki = "";

        pat = Pattern.compile("<media:content\\surl=\"(.*)\"\\stype");
        m = pat.matcher(tekst);
        if (m.find())
            adres_grafiki = m.group(1);
        else
            adres_grafiki = "";


    }
    public void print() {
        System.out.println("Infografika: " +
                "\nTytuł: " + tytuł +
                "\nAdres strony : " + adres_strony +
                "\nAdres grafiki : " + adres_grafiki +
                "\nAdres miniaturki : " + adres_miniaturki +
                "\nRozmiary : " + szerokość + "px" + " x " + wysokość + "px");
    }
}
