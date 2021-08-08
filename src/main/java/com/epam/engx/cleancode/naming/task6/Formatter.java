package com.epam.engx.cleancode.naming.task6;

public class Formatter {

    private static final String CORNER_SYMBOL = "+";
    private static final String VERTICAL_BORDER_SYMBOL = "|";
    private static final String HORIZONTAL_BORDER_SYMBOL = "-";
    private static final String DELIMITER = " _ ";
    private static final String NEW_LINE = "\n";


    public String formatKeyValue(String key, String value) {
        String content = key + DELIMITER + value;
        String horizontalBorder = generateHorizontalBorder(content.length());
        return CORNER_SYMBOL + horizontalBorder + CORNER_SYMBOL + NEW_LINE
                + VERTICAL_BORDER_SYMBOL + content + VERTICAL_BORDER_SYMBOL + NEW_LINE
                + CORNER_SYMBOL + horizontalBorder + CORNER_SYMBOL + NEW_LINE;
    }

    private String generateHorizontalBorder(int times) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < times; i++) {
            result.append(Formatter.HORIZONTAL_BORDER_SYMBOL);
        }
        return result.toString();
    }
}
