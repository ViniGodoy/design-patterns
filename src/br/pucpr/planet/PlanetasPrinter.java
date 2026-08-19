package br.pucpr.planet;

import br.pucpr.user.Theme;
import java.util.ArrayList;

public class PlanetasPrinter {
  public void print(ArrayList<Planet> planets, boolean alignRight, Theme theme) {
    if (planets == null || planets.isEmpty()) {
      System.out.println("ERRO: Lista de planetas vazia ou nula.");
      return;
    }

    final var borderChar = theme.getBorderChar();
    final var BORDER_WIDTH = 95;

    var sb = new StringBuilder();

    sb.repeat(borderChar, BORDER_WIDTH).append("\n");
    sb.append(String.format("| %-10s | %-20s | %-22s | %-14s |%-14s |%n", "Nome","Diametro", "Dist. sol (km)", "Dist. sol (ua)","TIPO"));
    sb.repeat(borderChar, BORDER_WIDTH).append("\n");
    for (var planet: planets) {
      if (planet == null){
        continue;
      }
      sb.append(
          String.format(
              "| %-10s | %-20s | %-22s | %-14s |%-14s |%n",
              formatNamePlanet(planet.name()),
              formatDiameter(planet.diameterKm()),
              formatSunDistanceKm(planet.sunDistanceKm()),
              formatDistanceUa(planet.sunDistanceKm()),
              formatType(planet.type())
          )
      );


    }

    //borda inferior
    sb.repeat(borderChar, BORDER_WIDTH).append("\n");

    // Espaçamento

    if (alignRight) {
      var lines = sb.toString().split("\n");
      for (var line : lines) {
        System.out.println("                    " + line);
      }
    } else {
      System.out.print(sb);
    }


  }

  private static String formatNamePlanet(String name) {
    return name != null ? name : "NOME INVÁLIDO";
  }

  private static String formatDiameter(double diameterKm) {
    return String.format("%,.1f", diameterKm);
  }

  private static String formatSunDistanceKm(long sunDistanceKm) {
    return String.format("%,d", sunDistanceKm);
  }

  private static String formatDistanceUa(double sunDistanceKm) {
    double distanceUa = sunDistanceKm / 149_600_000.0;
    return String.format("%,.2f", distanceUa);
  }

  private static String formatType(PlanetType type) {
    switch (type) {
      case ROCK:
        return "Rochoso";
      case GAS:
        return "Gasoso";
      case ICE:
        return "Gelado";
      case DWARF:
        return "Anão";
      default:
        return "TIPO INVÁLIDO";
    }
  }

}
