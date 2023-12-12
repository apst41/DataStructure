package org.example;

import lombok.ToString;

@ToString
public enum DocumentTypeEnum {
  SELFIE("selfie"),
  KYC_PROOF("ktp"),
  livenessPhoto("livenessPhoto");

  DocumentTypeEnum(String value) {
    this.value = value;
  }

  public final String value;
}
