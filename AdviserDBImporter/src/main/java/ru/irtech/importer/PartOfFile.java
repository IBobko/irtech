package ru.irtech.importer;

import java.util.List;

/**
 * @author Igor Bobko <limit-speed@yandex.ru>.
 */
public class PartOfFile {
    /**
     * Columns which presents in file.
     */
    private List<String> columns;
    private Long from;
    private Long to;

    public List<String> getColumns() {
        return columns;
    }

    public void setColumns(List<String> columns) {
        this.columns = columns;
    }

    public Long getFrom() {
        return from;
    }

    public void setFrom(Long from) {
        this.from = from;
    }

    public Long getTo() {
        return to;
    }

    public void setTo(Long to) {
        this.to = to;
    }
}

