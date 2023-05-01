package enums;

public enum ModelToTable {
    artist("artists"), album("albums"), genre("genres");

    private String table;
    private ModelToTable (String name) {
        this.table = name;
    }

    public String getTableName() {
        return table;
    }
}
