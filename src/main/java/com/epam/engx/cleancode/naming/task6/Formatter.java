package com.epam.engx.cleancode.naming.task6;

public class Formatter {

    private static final String CORNER_SYMBOL = "+";
    private static final String SIDE_SYMBOL = "|";
    private static final String HORIZONTAL_BORDER_SYMBOL = "-";
    private static final String BOTTOM_SPACE_SYMBOL = " _ ";
    private static final String NEW_LINE = "\n";


    public String formatKeyValue(String key, String value) {
        String content = key + BOTTOM_SPACE_SYMBOL + value;
        String horizontalBorder = generateHorizontalBorder(HORIZONTAL_BORDER_SYMBOL, content.length());
        return CORNER_SYMBOL + horizontalBorder + CORNER_SYMBOL + NEW_LINE
                + SIDE_SYMBOL + content + SIDE_SYMBOL + NEW_LINE
                + CORNER_SYMBOL + horizontalBorder + CORNER_SYMBOL + NEW_LINE;
    }

    private String generateHorizontalBorder(String symbol, int times) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < times; i++) {
            result.append(symbol);
        }
        return result.toString();
    }
}
