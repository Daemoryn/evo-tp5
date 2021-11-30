import spoon.Launcher;
import spoon.reflect.CtModel;
import spoon.reflect.code.CtComment;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.factory.Factory;
import spoon.reflect.visitor.filter.TypeFilter;

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