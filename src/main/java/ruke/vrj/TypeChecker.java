package ruke.vrj;

import java.util.ArrayList;

/**
 * MIT License
 *
 * Copyright (c) 2017 Franco Montenegro
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
public class TypeChecker {

  public static boolean isValidNumber(final Symbol expression) {
    return expression.type.equals("integer") || expression.type.equals("real");
  }

  public static boolean isValidFunctionCall(final Symbol function, final ArrayList<Symbol> args) {
    if (function.params.size() != args.size()) {
      return false;
    }

    for (int i = 0, max = function.params.size(); i < max; i++) {
      if (args.get(i).flags.contains(SymbolFlag.ARRAY)) {
        return false;
      }

      if (!TypeChecker.compatible(function.params.get(i), args.get(i))) {
        return false;
      }
    }

    return true;
  }

  public static boolean isValidArrayIndex(final Symbol index) {
    if (!"integer".equals(index.type)) {
      return false;
    }

    if (index.flags.contains(SymbolFlag.VARIABLE) && index.flags.contains(SymbolFlag.ARRAY)) {
      return false;
    }

    return true;
  }

  public static boolean isStruct(final Symbol struct) {
    return struct.flags.contains(SymbolFlag.STRUCT);
  }

  public static boolean isLibrary(final Symbol library) {
    return library.flags.contains(SymbolFlag.LIBRARY);
  }

  public static boolean isValidInitializer(final Symbol initializer) {
    if (!initializer.flags.contains(SymbolFlag.FUNCTION)) {
      return false;
    }

    if (!initializer.params.isEmpty()) {
      return false;
    }

    if (initializer.parent != null) {
      final boolean parentIsStruct = TypeChecker.isStruct(initializer.parent);
      final boolean initializerNotStatic = !initializer.flags.contains(SymbolFlag.STATIC);

      if (parentIsStruct && initializerNotStatic) {
        return false;
      }
    }

    return true;
  }

  public static boolean compatible(final Symbol a, final Symbol b) {
    final Symbol aType = a.getTypes().get(0);

    for (final Symbol bType : b.getTypes()) {
      if (aType.equals(bType)) {
        return true;
      }
    }

    return false;
  }

}
