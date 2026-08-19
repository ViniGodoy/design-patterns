package br.pucpr.planet;

import br.pucpr.table.TableData;
import br.pucpr.user.Theme;
import java.util.ArrayList;
import java.util.List;

public class PlanetasPrinter {
  public void print(
          ArrayList<Planet> planets,
          boolean alignRight,
          Theme theme) {

    if (planets == null || planets.isEmpty()) {
      System.out.println("ERRO: Lista de planetas vazia ou nula.");
      return;
    }

    var tableData = new TableData() {
      @Override
      public String[] headers() {
        return new String[] {
                "Nome",
                "Diâmetro",
                "Dist. sol (km)",
                "Dist. sol (ua)",
                "Tipo"
        };
      }

      @Override
      public int[] columnWidths() {
        return new int[] {
                20,
                10,
                15,
                15,
                10
        };
      }

      @Override
      public List<String[]> rows() {
        var rows = new ArrayList<String[]>();
        for (var planet : planets) {
          if (planet == null) {
            continue;
          }

          rows.add(
                  new String[] {
                          formatName(planet.name()),
                          String.format("%,.1f", planet.diameterKm()),
                          String.format("%,d", planet.sunDistanceKm()),
                          String.format(
                                  "%,.2f",
                                  Planet.kmToAu(planet.sunDistanceKm())),
                          formatType(planet.type())
                  });
        }
        return rows;
      }
    };
    tableData.print(alignRight, theme);
  }

  private static String formatName(String name) {
    if (name == null || name.isEmpty()) {
      return "NÃO INFORMADO";
    }
    if (name.length() > 20) {
      name = name.substring(0, 17) + "...";
    }
    return name;
  }

  private static String formatType(PlanetType type) {
    return switch (type) {
      case ROCK -> "Rochoso";
      case GAS -> "Gasoso";
      case ICE -> "Gelado";
      case DWARF -> "Anão";
    };
  }
}