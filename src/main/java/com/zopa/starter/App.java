package com.zopa.starter;


import com.zopa.filereader.CsvFileReader;
import com.zopa.model.Lender;
import com.zopa.model.LenderValidator;
import com.zopa.output.ResultOutput;
import com.zopa.service.CreditService;
import com.zopa.service.CreditServiceImpl;
import java.io.File;
import java.nio.file.NoSuchFileException;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class App {

  private CsvFileReader csvFileReader = new CsvFileReader();
  private CreditService creditService;

  private void checkProgramArguments(String[] args) throws NoSuchFileException {
    if (StringUtils.isEmpty(args[0])) {
      throw new IllegalArgumentException("Path to file can't be empty");
    }
    if (StringUtils.isEmpty(args[1])) {
      throw new IllegalArgumentException("Credit sum can't be empty");
    }
    if (StringUtils.isNotEmpty(args[0])) {
      String pathStr = args[0];
      File file = new File(pathStr);

      if (!file.exists()) {
        throw new NoSuchFileException("Can't find file by specified path");
      }
    }

    if (StringUtils.isNotEmpty(args[1])) {
      boolean isDigit = StringUtils.isNumeric(args[1]);
      if (isDigit) {
        Integer creditSum = new Integer(args[1]);
        if (creditSum < 1000) {
          throw new IllegalArgumentException(
              "Wrong second argument. The argument value should be a digit between £ 1000 до £ 15 000");
        }
        if (creditSum > 15000) {
          throw new IllegalArgumentException(
              "Wrong second argument. The argument value should be a digit between £ 1000 до £ 15 000");
        }
      } else {
        throw new IllegalArgumentException(
            "Wrong second argument type. The argument value should be a digit between £ 1000 до £ 15 000");
      }
    }
  }

  private List<Lender> readCsvFile(String filePath) {
    return csvFileReader.loadObjectList(Lender.class, filePath);
  }

  public static void main(String[] args) throws NoSuchFileException {
    App app = new App();
    app.checkProgramArguments(args);
    Long creditSum = Long.valueOf(args[1]);

    List<Lender> lenders = app.readCsvFile(args[0]);
    LenderValidator validator = new LenderValidator(lenders);
    boolean res = validator.checkSumEnough(creditSum);

    if (res) {
      app.creditService = new CreditServiceImpl(lenders, creditSum);
      Long amount = app.creditService.getRequestedAmount();
      Double rate = app.creditService.getRate();
      Double monthly = app.creditService.getMonthlyRepayment();
      Double total = app.creditService.getTotalRepayment();

      ResultOutput ro = new ResultOutput(amount, rate, monthly, total);
      ro.printResultInfo();
    } else {
      System.out.println("Lenders from the list do not have enough money. Try later ..");
    }
  }

}
