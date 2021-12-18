package common.tools;

import common.ultilities.Constant;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

public class Converter {
    public Long stringToAmount(String string) {
        return Long.valueOf(string.replaceAll("[^\\d.]+", ""));
    }

    public String formatAmount(Long amount) {
        Locale localeEN = new Locale("en", "EN");
        NumberFormat en = NumberFormat.getInstance(localeEN);
        return en.format(amount);
    }

    public static Map<String, String> getAllPropertiesFile(String pathProp) {
        Properties prop = new Properties();
        Map<String, String> map = new HashMap<>();
        try (FileInputStream inputStream = new FileInputStream(pathProp)) {
            prop.load(inputStream);
            for (String key : prop.stringPropertyNames()) {
                String value = prop.getProperty(key);
                map.put(key, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }


    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }

    public static boolean compareDate(String dateFrom, String dateTo, String date) {
        Date dateFromFormat = formatDate(dateFrom);
        Date dateToFormat = formatDate(dateTo);
        Date dateFormat = formatDate(date);
        assert dateFromFormat != null;
        assert dateFormat != null;
        assert dateToFormat != null;
        return (dateFormat.compareTo(dateFromFormat) >= 0 && dateFormat.compareTo(dateToFormat) <= 0);
    }

    public static Date formatDate(String date) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String localDateTimeToString(LocalDateTime date, String formatType) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatType);
        return date.format(formatter);
    }
    public static String localDateToString(LocalDate date, String formatType) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatType);
        return date.format(formatter);
    }
    public static LocalDate stringToLocalDate(String date, String formatType) {
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .parseCaseInsensitive().appendPattern(formatType)
                .toFormatter(Locale.ENGLISH);
        return LocalDate.parse(date, formatter);
    }
    public static LocalDateTime stringToLocalDateTime(String dateTime, String formatType){
        if (dateTime.length()<12) dateTime = dateTime + " 00:00:00";
        if (dateTime.contains("T"))
        {
            formatType ="yyyy-MM-dd HH:mm:ss";
            dateTime = dateTime.replace("T", " ");
        }
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .parseCaseInsensitive().appendPattern(formatType)
                .toFormatter(Locale.ENGLISH);
        return LocalDateTime.parse(dateTime, formatter);
    }

    public static WebElementFacade targetToElement(Target target, Actor actor) {
        try {
            target.resolveFor(actor).setImplicitTimeout(Duration.ofSeconds(60));
            WaitUntil.the(target, WebElementStateMatchers.isPresent()).forNoMoreThan(60).seconds();
            return target.resolveFor(actor);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<WebElementFacade> targetToElements(Target target, Actor actor, int timeOut) {
        List<WebElementFacade> lstElement = new ArrayList<>();
        try {
            timeOut = (timeOut == 0) ? Constant.IMPLICIT_WAIT : timeOut;
            target.resolveFor(actor).setImplicitTimeout(Duration.ofSeconds(timeOut));
            lstElement = target.resolveAllFor(actor);
            target.resolveFor(actor).setImplicitTimeout(Duration.ofMillis(Constant.IMPLICIT_WAIT));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lstElement;
    }
}
