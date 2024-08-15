package com.master.myMaster.utils;

import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Utils {

  private static final Map<String, List<String>> map = new HashMap<>();

  static {
    map.put(
            "Gradjevinski radovi",
            List.of(
                    "Moler", "Gipsar", "Fasader", "Zidar", "Parketar", "Keramicar",
                    "Limar", "Gradjevinski stolar", "Izolater", "Tesar",
                    "Pomocni radnik", "Postavljanje podnih povrsina", "Secenje i busenje"
            )
    );
    map.put(
            "Elektronika",
            List.of(
                    "Elektricar", "Serviser lifotva", "Audio-video serviser",
                    "Serviser mobilnih telefona", "Serviser racunara", "Serviser kucnih aparata"
            )
    );
    map.put(
            "Odrzavanje",
            List.of(
                    "Cistacica", "Bastovan", "Drvoseca", "Visinski radnik", "Domar"
            )
    );
    map.put(
            "Vodovod i sanitarije",
            List.of(
                    "Vodoinstalater", "Montazer grejnih instalacija",
                    "Ventilacioni sistemi", "Montazer klima uredjaja", "Montazer sanitarija"
            )
    );
    map.put(
            "Obrada materijala",
            List.of(
                    "Bravar", "Tapetar", "Metalostrugar", "Staklorezac",
                    "Krojac", "Obucar"
            )
    );
    map.put(
            "Automobilska industrija",
            List.of(
                    "Automehanicar", "Autoelektricar", "Vulkanizer", "Limar",
                    "Slep sluzba", "Serviser motocikala"
            )
    );
  }

  public List<String> getL1Categories() {
    return map.keySet().stream().toList();
  }

  public List<String> getL2Categories(String l1Category) {
    return map.get(l1Category);
  }
}
