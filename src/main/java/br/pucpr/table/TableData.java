package br.pucpr.table;

import br.pucpr.user.Theme;
import java.util.List;

public interface TableData {
    String[] headers();
    List<String[]> rows();
    int[] columnWidths();

    default int borderWidth() {
        int width = 1;
        for (int columnWidth : columnWidths()) {
            width += columnWidth + 3;
        }
        return width;
    }

    default void print(boolean alignRight, Theme theme) {
        final var borderChar = theme.getBorderChar();
        final var borderWidth = borderWidth();

        var sb = new StringBuilder();

        sb.repeat(borderChar, borderWidth).append("\n");
        sb.append(formatRow(headers()));
        sb.repeat(borderChar, borderWidth).append("\n");

        for (var row : rows()) {
            sb.append(formatRow(row));
        }

        sb.repeat(borderChar, borderWidth).append("\n");

        if (alignRight) {
            var lines = sb.toString().split("\n");

            for (var line : lines) {
                System.out.println("                    " + line);
            }
        } else {
            System.out.print(sb);
        }
    }

    private String formatRow(String[] values) {
        var sb = new StringBuilder("|");
        var widths = columnWidths();
        for (int i = 0; i < values.length; i++) {
            sb.append(String.format(" %-"+widths[i]+"s |", values[i]));
        }

        sb.append("\n");
        return sb.toString();
    }
}