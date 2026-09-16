package br.pucpr.table.model;

import java.util.*;

public class ColumnTableData<T> implements TableData {
  private final List<ColumnData<? super T>> columns;
  private final List<T> data;
  private final List<DataChangedObserver> observers = new ArrayList<>();

  public ColumnTableData(
      Collection<? extends T> data, Collection<? extends ColumnData<? super T>> columns) {
    this.columns = new ArrayList<>(columns);
    this.data = new ArrayList<>(data);
  }

  @SafeVarargs
  public ColumnTableData(Collection<? extends T> data, ColumnData<? super T>... columns) {
    this(data, Arrays.asList(columns));
  }

  @Override
  public int rowCount() {
    return data.size();
  }

  @Override
  public int colCount() {
    return columns.size();
  }

  @Override
  public String header(int col) {
    return columns.get(col).header();
  }

  @Override
  public String get(int row, int col) {
    var line = data.get(row);
    return columns.get(col).get(line);
  }

  @Override
  public void addObserver(DataChangedObserver observer) {
    this.observers.add(observer);
  }

  public void fireTableDataChanged() {
    for (var observer : observers) {
      observer.onTableChange();
    }
  }

  public List<T> getData() {
    return Collections.unmodifiableList(data);
  }
}
