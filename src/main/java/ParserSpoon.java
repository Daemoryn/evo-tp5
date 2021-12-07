import spoon.Launcher;

public class ParserSpoon {
    public static void main(String[] args) {
        Launcher spoon = new Launcher();
        spoon.addInputResource("/Users/benjaminadolphe/Desktop/fac/M2/S1 - local/HAI913I-Evolution-et-restructuration-des-logiciels/TP5/src/main/java/modelsSpoonable");
        spoon.getEnvironment().setAutoImports(true);
        spoon.addProcessor(new LogProcessor());
        spoon.run();
    }
}