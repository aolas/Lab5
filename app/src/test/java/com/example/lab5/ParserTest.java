package com.example.lab5;

import junit.framework.TestCase;

import org.junit.Test;

public class ParserTest extends TestCase {

    Parser pars = new Parser(    );
    @Test
    public void testGetbaseList() {
        String inputString = "{\"rates\":{\"CAD\":1.5578,\"HKD\":9.0885,\"ISK\":164.8,\"PHP\":56.708,\"DKK\":7.4435,\"HUF\":367.11,\"CZK\":27.422,\"AUD\":1.6603,\"RON\":4.8768,\"SEK\":10.371,\"IDR\":17288.41,\"INR\":86.804,\"BRL\":6.7191,\"RUB\":92.3025,\"HRK\":7.5778,\"JPY\":122.36,\"THB\":36.659,\"CHF\":1.0693,\"SGD\":1.6014,\"PLN\":4.6202,\"BGN\":1.9558,\"TRY\":9.6906,\"CNY\":7.8845,\"NOK\":10.9693,\"NZD\":1.7647,\"ZAR\":19.2187,\"USD\":1.1727,\"MXN\":24.9759,\"ILS\":3.9794,\"GBP\":0.90662,\"KRW\":1332.51,\"MYR\":4.8732},\"base\":\"EUR\",\"date\":\"2020-10-28\"}";
        Exchange testExchange = pars.getbaseList(inputString);

        assertEquals("EUR", testExchange.getBase());
        assertEquals("2020-10-28", testExchange.getDate());
        // neaisku kodel suformuojamas kitoks sarasas vykdant testavima, nots duomenys naudojami tokie pat
        assertEquals("CAD", testExchange.getCurrencyList().get(0).getbaseName()); //failed

    }
}