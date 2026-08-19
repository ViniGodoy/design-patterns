package br.pucpr.table;

public interface TableData {
  int rowCount();

  int colCount();

  String header(int col);

  String get(int row, int col);
}
