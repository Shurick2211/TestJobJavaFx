package com.sn.org.uplevel;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ParseKurce {


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

}
