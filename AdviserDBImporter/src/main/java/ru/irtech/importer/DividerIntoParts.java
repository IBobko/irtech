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
@SuppressWarnings("WeakerAccess")
public class DividerIntoParts {
    /**
     * The size of the two characters: \r\n.
     * If the file contains a newline in Unix notation this number should be replaced by 1.
     */
    static final Integer NUMBER_BYTES_OF_END_OF_STRING = 2;

    /**
     * Contains the number of how many bytes should contain one portion.
     */
    private static final long PORTION = 512 * 1024;

    /**
     * An instance of java.nio.file.Path that contains the path to the current file.
     */
    private final Path path;

    /**
     * Table columns, which are presented at the beginning of the file.
     */
    private List<String> columns;

    /**
     * The intervals on the file.
     */
    private List<Long> parts;

    /**
     * Constructor that initializes variables and
     * holds all the necessary calculations for the division file.
     *
     * @param path An instance of java.nio.file.Path that contains the path to the current file.
     * @throws IOException May occur when working with streams.
     */
    DividerIntoParts(final Path path) throws IOException {
        this.path = path;
        final InputStream inputStreamReader = new FileInputStream(getPath().toString());
        final List<Long> positions = new ArrayList<>();

        long currentPosition = 0;

        final StringBuilder columns = new StringBuilder();
        char ch;
        while ((ch = (char) inputStreamReader.read()) != '\r') {
            currentPosition++;
            columns.append(ch);
        }
        //noinspection ResultOfMethodCallIgnored, because we skip "\r" symbol
        inputStreamReader.read();
        currentPosition += NUMBER_BYTES_OF_END_OF_STRING;

        this.columns = Arrays.asList(columns.toString().split(","));
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

    /**
     * Returns the size of the parts which are divided from the file.
     *
     * @return The size of the parts.
     */
    public Integer getSize() {
        return this.parts.size();
    }

    /**
     * Returns the intervals of the individual parts of the index.
     *
     * @param i the index of part.
     * @return PartOfFile instance.
     */
    public PartOfFile getPart(final int i) {
        if (i + 1 > getSize() || i < 0) {
            return null;
        }
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
