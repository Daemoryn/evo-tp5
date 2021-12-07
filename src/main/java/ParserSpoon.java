import spoon.Launcher;

import java.io.File;

public class ParserSpoon {
    public static void main(String[] args) {
        Launcher spoon = new Launcher();
        spoon.addInputResource("C:\\Users\\Alex\\Documents\\GitHub\\evo-tp5-traceability\\src\\main\\java\\modelsSpoonable");
        spoon.getEnvironment().setAutoImports(true);
        spoon.setSourceOutputDirectory(new File("spooned"));
        spoon.addProcessor(new LogProcessor());
        spoon.run();

    }
}