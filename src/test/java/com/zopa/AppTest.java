package com.zopa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.zopa.filereader.CsvFileReader;
import com.zopa.model.Lender;
import java.util.List;
import org.junit.Test;

public class AppTest {

    @Test
    public void testReadingFile() {
        CsvFileReader csvFileReader = new CsvFileReader();
        List<Lender> lenders = csvFileReader.loadObjectList(Lender.class, "market.csv");

        Lender bob = new Lender("Bob", 0.075, 640L);
        Lender jane = new Lender("Jane", 0.069, 480L);
        Lender fred = new Lender("Fred", 0.071, 520L);
        Lender mary = new Lender("Mary", 0.104, 170L);
        Lender john = new Lender("John", 0.081, 320L);
        Lender dave = new Lender("Dave", 0.074, 140L);
        Lender angela = new Lender("Angela", 0.071, 60L);
        lenders.forEach(System.out::println);

        assertEquals(bob, lenders.get(0));
        assertEquals(jane, lenders.get(1));
        assertEquals(fred, lenders.get(2));
        assertEquals(mary, lenders.get(3));
        assertEquals(john, lenders.get(4));
        assertEquals(dave, lenders.get(5));
        assertEquals(angela, lenders.get(6));
    }

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
}
