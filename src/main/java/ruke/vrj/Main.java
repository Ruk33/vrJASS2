package ruke.vrj;

import ruke.vrj.server.LanguageServer;

public class Main {

  public static void main(String[] args) {
    new LanguageServer().listen(System.in);
  }
}
