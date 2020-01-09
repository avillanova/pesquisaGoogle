package util;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.*;

public class Tools {

    public static WebElement waitBy(WebElement element) {
        try {
            new WebDriverWait( Hook.getDriver(), 2 )
                    .until(  ExpectedConditions.visibilityOf( element ));
        }catch(Exception e){
            System.err.println(element+" Não encontrado....");
        }
        return element;
    }

    public static WebElement waitClickableBy(WebElement element) {
        try {
            new WebDriverWait( Hook.getDriver(), 4 )
                    .until(  ExpectedConditions.elementToBeClickable( element ));
        }catch(Exception e){
            System.err.println(element+" Não encontrado....");
        }
        return element;
    }


    public static List<String> getDate(String intervalo){
        List<String> dates = new ArrayList<String>();
        dates.add(intervalo.substring(0, 10));
        dates.add(intervalo.substring(12));
        return dates;
    }

    public static String getConvertedDates(List<String> dates){
        String expected=null;
        Date start = new Date(dates.get(0));
        Date end = new Date(dates.get(1));
        Calendar calStart = Calendar.getInstance(TimeZone.getTimeZone("America/Sao_Paulo"));
        calStart.setTime(start);
        Calendar calEnd = Calendar.getInstance(TimeZone.getTimeZone("America/Sao_Paulo"));
        calEnd.setTime(end);
        expected = calStart.get(Calendar.DATE)+" de "+
                new SimpleDateFormat("MMM").format(calStart.getTime()).toLowerCase()+". de "+
                calStart.get(Calendar.YEAR)+" – "+
                calEnd.get(Calendar.DATE)+" de "+
                new SimpleDateFormat("MMM").format(calEnd.getTime()).toLowerCase()+". de "+
                calEnd.get(Calendar.YEAR);
        return expected;
    }
}
