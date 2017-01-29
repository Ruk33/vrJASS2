package ruke.vrj;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.NANOSECONDS;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import java.io.File;
import ruke.vrj.compiler.Compiler;

public class Main {

  public static void main(String[] args) {
    final Compiler compiler = new Compiler();

    try {
      for (final String arg : args) {
        final String toCompile = Files.toString(new File(arg), Charsets.UTF_8);
        final String compiled = compiler.compile(toCompile);
        final long start = System.nanoTime();

        if (compiler.getResults().isEmpty()) {
          System.out.println(compiled);
        } else {
          System.out.println(compiler.getResults());
        }

        System.out.println(
            "Compiled in " +
            MILLISECONDS.convert(System.nanoTime() - start, NANOSECONDS) +
            " milliseconds"
        );
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
