package com.zopa.output;

public class ResultOutput {

  private static final int CONSTANT = 100;

  private Long amount;
  private Double rate;
  private Double monthlyRepayment;
  private Double totalRepayment;

  public ResultOutput(
      Long requestAmount,
      Double rate,
      Double monthlyRepayment,
      Double totalRepayment) {
    this.amount = requestAmount;
    this.rate = rate;
    this.monthlyRepayment = monthlyRepayment;
    this.totalRepayment = totalRepayment;
  }

  public void printResultInfo() {
    StringBuilder res = new StringBuilder();
    res.append("Requested amount: £").append(amount).append("\n")
        .append("Rate:").append(String.format("%.1f", rate * CONSTANT)).append("\n")
        .append("Monthly repayment: £").append(String.format("%.2f", monthlyRepayment)).append("\n")
        .append("Total repayment: £").append(String.format("%.2f", totalRepayment));

    System.out.println(res.toString());
  }

}
