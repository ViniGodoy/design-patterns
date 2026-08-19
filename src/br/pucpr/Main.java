package br.pucpr;

import static br.pucpr.planet.PlanetType.*;
import static br.pucpr.planet.PlanetType.DWARF;
import static br.pucpr.planet.PlanetType.ICE;
import static br.pucpr.user.Theme.LIGHT;

import br.pucpr.planet.Planet;
import br.pucpr.planet.PlanetasPrinter;
import br.pucpr.user.Theme;
import br.pucpr.user.User;
import br.pucpr.user.UsersPrinter;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {


    final var planetas = new ArrayList<Planet>();
    planetas.add(new Planet("Mercúrio", 4879, 57_910_000L, ROCK));
    planetas.add(new Planet("Vênus", 12104, 108_200_000L, ROCK));
    planetas.add(new Planet("Terra", 12756, 149_600_000L, ROCK));
    planetas.add(new Planet("Marte", 6792, 227_940_000L, ROCK));
    planetas.add(new Planet("Júpiter", 142984, 778_330_000L, GAS));
    planetas.add(new Planet("Saturno", 120536, 1_429_400_000L, GAS));
    planetas.add(new Planet("Urano", 51118, 2_870_990_000L, ICE));
    planetas.add(new Planet("Netuno", 49528, 4_504_300_000L, ICE));
    planetas.add(new Planet("Plutão", 2376, 5_906_380_000L, DWARF));
    System.out.println();
    System.out.println("IMPRIMINDO PLANETAS");
    System.out.println("-------------------");
  }
}
