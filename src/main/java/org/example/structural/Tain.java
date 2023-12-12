package org.example.structural;

import java.util.EnumSet;
import java.util.List;
import org.example.DocumentTypeEnum;

public class Tain {

  public static List<String> getDocumentTypes() {
    return EnumSet.allOf(DocumentTypeEnum.class).stream().map(Enum::toString).toList();
  }

  public static void main(String[] args) {
    System.out.println(getDocumentTypes());
  }
}
