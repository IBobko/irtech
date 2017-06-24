package ru.irtech.importer;

import java.util.List;

/**
 * @author Igor Bobko <limit-speed@yandex.ru>.
 */
@SuppressWarnings("WeakerAccess")
public class PartOfFile {
    /**
     * Table columns, which are presented at the beginning of the file.
     */
    private List<String> columns;

    /**
     * The beginning of the interval file.
     */
    private Long from;

    /**
     * The interval end of the file.
     */
    private Long to;

    public List<String> getColumns() {
        return columns;
    }

    public void setColumns(final List<String> columns) {
        this.columns = columns;
    }

    public Long getFrom() {
        return from;
    }

    public void setFrom(final Long from) {
        this.from = from;
    }

    public Long getTo() {
        return to;
    }

    public void setTo(final Long to) {
        this.to = to;
    }
}

