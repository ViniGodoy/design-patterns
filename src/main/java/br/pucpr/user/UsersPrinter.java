package br.pucpr.user;

import br.pucpr.table.TableData;
import java.util.ArrayList;
import java.util.List;

public class UsersPrinter {
  public void print(
          ArrayList<User> users,
          boolean maskCpf,
          boolean alignRight,
          Theme theme) {

    if (users == null || users.isEmpty()) {
      System.out.println("ERRO: Lista de usuários vazia ou nula.");
      return;
    }

    var tableData = new TableData() {
      @Override
      public String[] headers() {
        return new String[] {
                "ID",
                "NOME",
                "EMAIL",
                "CPF"
        };
      }

      @Override
      public int[] columnWidths() {
        return new int[] {
                5,
                20,
                22,
                14
        };
      }

      @Override
      public List<String[]> rows() {
        var rows = new ArrayList<String[]>();

        for (var user : users) {
          if (user == null) {
            continue;
          }

          rows.add(
                  new String[] {
                          formatId(user.id()),
                          formatName(user),
                          validateAndFormatEmail(user.email()),
                          formatCpf(user.cpf(), maskCpf)
                  });
        }
        return rows;
      }
    };

    tableData.print(alignRight, theme);
  }

  private static String formatId(Long id) {
    return id != null ? id.toString() : "0";
  }

  private static String formatCpf(String cpf, boolean mask) {
    if (cpf == null || cpf.length() != 11) {
      return "CPF INVÁLIDO";
    }

    if (mask) {
      return "***."
              + cpf.substring(3, 6)
              + "."
              + cpf.substring(6, 9)
              + "-**";
    }

    return cpf.substring(0, 3)
            + "."
            + cpf.substring(3, 6)
            + "."
            + cpf.substring(6, 9)
            + "-"
            + cpf.substring(9, 11);
  }

  private static String validateAndFormatEmail(String email) {
    return email == null || !email.contains("@")
            ? "INVÁLIDO"
            : email;
  }

  private static String formatName(User user) {
    var name = user.name();
    if (name == null || name.isEmpty()) {
      return "NÃO INFORMADO";
    }

    if (name.length() > 20) {
      name = name.substring(0, 17) + "...";
    }
    return name;
  }
}