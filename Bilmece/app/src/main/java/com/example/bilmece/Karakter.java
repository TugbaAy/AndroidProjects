package com.example.bilmece;

public class Karakter {

    int kilo;
    int hareketSayisi;
    int saldiriGucu;
    String isim = "Karaktere isim veriniz. ";

    public String yemek() {
        if (hareketSayisi > 0) {
            kilo++;
            hareketSayisi--;

            return "Yemek yedi ve kilosu arttı.";
        } else return "Yeterli hareket yok.";
    }

    public String uyu() {
        if (hareketSayisi > 0) {
            hareketSayisi--;
            return "Karakterimiz uyudu.";
        } else return "Yeterli hareket yok.";
    }

    public String savas() {
        if (hareketSayisi > 0) {
            hareketSayisi--;
            return "Karakterimiz savaştı.";
        } else return "Yeterli hareket yok.";
    }

    @Override
    public String toString() {

        return "Ad : " + isim
                + "\nKilo : " + kilo
                + "\nHareket Sayısı : " + hareketSayisi
                + "\nSaldırı Gücü : " + saldiriGucu;
    }

}
