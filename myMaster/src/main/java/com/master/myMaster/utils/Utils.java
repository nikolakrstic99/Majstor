package com.master.myMaster.utils;

import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Utils {

  public byte[] decodeImage(String base64Image) {
    return Base64.getDecoder().decode(base64Image.split(",")[1]);  // The split is to remove the data URL prefix if present
  }

  public String encodeImage(byte[] image) {
    return "data:image/png;base64," + Base64.getEncoder().encodeToString(image);
  }

  private static final Map<String, List<String>> map = new HashMap<>();

  static {
    map.put("Gradjevinski radovi", List.of("Moleraj", "Krecenje", "Keramicarski radovi", "Gipsarski radovi", "Fasaderski radovi", "Zidarski radovi", "Tesarski radovi", "Stolarski radovi", "Limarski radovi", "Vodoinstalaterski radovi", "Elektroinstalaterski radovi", "Grejanje", "Klimatizacija", "Ventilacija", "Ostali radovi"));
  }

  public List<String> getL1Categories() {
    return map.keySet().stream().toList();
  }

  public List<String> getL2Categories(String l1Category) {
    return map.get(l1Category);
  }
}
