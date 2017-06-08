package ru.irtech.importer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Igor Bobko <limit-speed@yandex.ru>.
 */
public class DividerIntoParts {
    static final Integer NUMBER_BYTES_OF_END_OF_STRING = 2;
    private final static long PORTION = 512 * 1024;
    private final Path path;
    /**
     * Columns which presents in file.
     */
    private List<String> columns;
    /**
     * Intervals.
     */
    private List<Long> parts;

    DividerIntoParts(final Path path) throws IOException {
        this.path = path;
        final InputStream inputStreamReader = new FileInputStream(path.toString());
        final List<Long> positions = new ArrayList<>();

        long currentPosition = 0;

        final StringBuilder columns = new StringBuilder();
        char ch;
        while ((ch = (char)inputStreamReader.read())!= '\r') {
            currentPosition++;
            columns.append(ch);
        }
        //noinspection ResultOfMethodCallIgnored, because we skip "\r" symbol
        inputStreamReader.read();
        currentPosition += NUMBER_BYTES_OF_END_OF_STRING;

        this.columns = Arrays.asList(columns.toString().split(";"));
        positions.add(currentPosition);
        main:
        while (inputStreamReader.skip(PORTION) == PORTION) {
            currentPosition += PORTION;
            while (true) {
                int r = inputStreamReader.read();
                currentPosition++;
                if (r == -1) {
                    break main;
                }
                char c = (char) r;
                if (c == '\n') {
                    positions.add(currentPosition);
                    break;
                }
            }
        }

        parts = positions;
    }

    public List<String> getColumns() {
        return columns;
    }

    private List<Long> getParts() {
        return parts;
    }

    public Path getPath() {
        return path;
    }


    public Integer getSize() {
        return this.parts.size();
    }

    public PartOfFile getPart(int i) {
        if (i + 1 > getSize() || i < 0) return null;
        final PartOfFile partOfFile = new PartOfFile();
        partOfFile.setColumns(getColumns());
        partOfFile.setFrom(getParts().get(i));
        if (i + 1 == getSize()) {
            partOfFile.setTo(null);
        } else {
            partOfFile.setTo(getParts().get(i + 1));
        }
        return partOfFile;
    }
}
