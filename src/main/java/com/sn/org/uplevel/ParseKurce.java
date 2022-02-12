package com.sn.org.uplevel;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class ParseKurce extends Thread implements Observed {
    private  List<Valuta> valutas=new ArrayList<>();
    private int time;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
    Observer observer=new HelloController();
    @Override
    public void run() {
        super.run();
        do {
            try {
                valutas=kursPars();
            } catch (IOException e) {
                e.printStackTrace();
            }
            notifyObserver();
           // LocalDateTime localDateTime=LocalDateTime.now();
            //System.out.println(localDateTime);
            try {
                sleep(time*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }while (true);
    }

    public  List<Valuta> kursPars() throws IOException {
        String url = "https://minfin.com.ua/currency/" ;
        Document page = Jsoup.parse(new URL(url), 5000);
        Element krTablo=page.select("table[class=table-response mfm-table mfcur-table-lg mfcur-table-lg-currency has-no-tfoot]" ).first();
        Elements tdName=krTablo.select("td[class=mfcur-table-cur]").tagName("a");
        Elements tdKurs=krTablo.select("span[class=mfcur-nbu-full-wrap]");
        List<Valuta> valutas=new  ArrayList<>();
        for (int i=0; i<tdName.size();i++){
            Valuta valuta=new Valuta(tdName.get(i).text(),
                    Float.parseFloat(tdKurs.get(i).text().split(" ")[0].replace("000","")));
            valutas.add(valuta);

        }

       // valutas.forEach(System.out::println);
      return valutas;
    }

    @Override
    public synchronized void notifyObserver() {

        observer.handleEvent(valutas);
    }
}
