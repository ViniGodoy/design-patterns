package br.pucpr.table.model;

public class PagedTableData implements TableData {
  private TableData data;
  private int pageSize;
  private int page;

  public PagedTableData(TableData data, int pageSize) {
    this.data = data;
    this.pageSize = pageSize;
    this.page = 0;
  }

  private int pageCount() {
    return (data.rowCount() / pageSize) + 1;
  }

  private int rowOffset(int page) {
    return page * pageSize;
  }

  public void setPage(int page) {
    if (page < pageCount() - 1) {
      this.page = page;
      fireTableDataChanged();
    }
  }

  @Override
  public int rowCount() {
    if (data.rowCount() < pageSize) return data.rowCount();
    if (page < pageCount() - 1) return pageSize;
    return data.rowCount() % pageSize;
  }

  @Override
  public int colCount() {
    return data.colCount();
  }

  @Override
  public String header(int col) {
    return data.header(col);
  }

  @Override
  public String get(int row, int col) {
    return data.get(rowOffset(page) + row, col);
  }

  @Override
  public void addObserver(DataChangedObserver observer) {
    data.addObserver(observer);
  }

  @Override
  public void fireTableDataChanged() {
    data.fireTableDataChanged();
  }
}
