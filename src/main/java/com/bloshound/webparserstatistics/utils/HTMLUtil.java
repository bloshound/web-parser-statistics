package com.bloshound.webparserstatistics.utils;



import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.logging.Logger;
import java.util.stream.Collectors;


@Component
public class HTMLUtil {

   // public static final Character[] delimiters = {' ', ',', '.', '!', '?', '"', ';', ':', '[', ']', '(', ')', '\n', '\r', '\t'};

    private static final Logger logger = Logger.getLogger(HTMLUtil.class.getName());

    private String regex = "[ ,.!?\";:\\[\\]()\n\r\t]+";

    public HTMLUtil(String regex) {
        Objects.requireNonNull(regex);
        this.regex = regex;
    }

    public HTMLUtil() {
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        Objects.requireNonNull(regex);
        this.regex = regex;

    }


    private String[] splitOnDelimiters(String content) {
       content = StringUtils.trimLeadingWhitespace(content);
      return content.split(regex);

    }

    public Map<String, Long> entrancesCounting(String content) {
        Map<String, Long> entrances = Arrays.stream(splitOnDelimiters(content))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return entrances;
    }

    public LinkedHashMap<String, Long> sortedLinkedEntrancesCounting(@NotNull Map<String, Long> map) {
        LinkedHashMap<String, Long> sortedEntrances = map.entrySet()
                .stream()
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> newValue, LinkedHashMap::new));
        return sortedEntrances;
    }

}
