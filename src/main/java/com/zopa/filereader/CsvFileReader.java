package com.zopa.filereader;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class CsvFileReader {

  private static final Logger log = Logger.getLogger(CsvFileReader.class.getName());

  public <T> List<T> loadObjectList(Class<T> type, String fileName) {
    try {
      CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();
      CsvMapper mapper = new CsvMapper();
      File file = new File(fileName);
      MappingIterator<T> readValues = mapper.reader(type).with(bootstrapSchema).readValues(file);
      return readValues.readAll();
    } catch (Exception e) {
      log.info("Error occurred while loading objects list from file " + fileName + "\n" + e.getMessage());
      return Collections.emptyList();
    }
  }

}
