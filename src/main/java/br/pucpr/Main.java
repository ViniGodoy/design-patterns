package br.pucpr;

import static br.pucpr.user.Theme.LIGHT;

import br.pucpr.user.User;
import br.pucpr.user.UsersPrinter;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    var usuarios = new ArrayList<User>();
    usuarios.add(
        new User(101L, "Carlos Eduardo de Souza", "carlos.souza@email.com", "12345678901"));
    usuarios.add(new User(102L, "Ana Maria Silva", "ana.silva@email.com", "98765432100"));
    usuarios.add(
        new User(103L, "João Pedro de Alcântara Bragança", "joao.pedro@email.com", "45678912345"));
    usuarios.add(new User(104L, "Mariana Costa", "marianacosta.email.com", "11122233344"));
    usuarios.add(new User(105L, "Lucas Mendes", "lucas@email.com", "12345"));
    usuarios.add(new User(106L, "", "beatriz@email.com", "55566677788"));

    System.out.println("IMPRIMINDO USUARIOS");
    System.out.println("-------------------");
    new UsersPrinter().print(usuarios, true, true, LIGHT);
  }
}
