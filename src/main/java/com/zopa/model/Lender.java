package com.zopa.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Lender {

  private String name;

  private Double rate;

  private Long available;

  public Lender() {}

  public Lender(String name, Double rate, Long available) {
    this.name = name;
    this.rate = rate;
    this.available = available;
  }

  @JsonProperty("Lender")
  public String getName() {
    return name;
  }

  @JsonProperty("Rate")
  public Double getRate() {
    return rate;
  }

  @JsonProperty("Available")
  public Long getAvailable() {
    return available;
  }

  public void setAvailable(Long available) {
    this.available = available;
  }

  @Override
  public String toString() {
    return "Lender{" +
        "name='" + name + '\'' +
        ", rate=" + rate +
        ", available=" + available +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Lender lender = (Lender) o;
    return Objects.equals(name, lender.name) &&
        Objects.equals(rate, lender.rate) &&
        Objects.equals(available, lender.available);
  }

  @Override
  public int hashCode() {

    return Objects.hash(name, rate, available);
  }
}
