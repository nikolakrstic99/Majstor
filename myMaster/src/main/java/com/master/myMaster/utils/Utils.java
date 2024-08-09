package com.master.myMaster.utils;

import java.util.Base64;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Utils {

  public byte[] decodeImage(String base64Image) {
    return Base64.getDecoder().decode(base64Image.split(",")[1]);  // The split is to remove the data URL prefix if present
  }

  public String encodeImage(byte[] image) {
    return "data:image/png;base64," + Base64.getEncoder().encodeToString(image);
  }
}
