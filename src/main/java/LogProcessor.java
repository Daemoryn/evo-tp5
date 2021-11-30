import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtBinaryOperator;
import spoon.reflect.code.CtCodeSnippetStatement;
import spoon.reflect.code.CtFor;
import spoon.reflect.code.CtIf;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtExecutable;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

public class LogProcessor extends AbstractProcessor<CtExecutable> {

//    @Override
//    public boolean isToBeProcessed(CtExecutable candidate) {
//        return super.isToBeProcessed(candidate);
//    }

    @Override
    public void process(CtExecutable element) {
        CtCodeSnippetStatement snippet = getFactory().Core().createCodeSnippetStatement();

        // Snippet which contains the log.
        final String value = String.format("System.out.println(\"Enter in the method %s from class %s\")",
                element.getSimpleName(),
                element.getParent(CtClass.class).getSimpleName());
        System.out.println("value = "+value);
        snippet.setValue(value);
        // Inserts the snippet at the beginning of the method body.
        if (element.getBody() != null) {
            element.getBody().insertBegin(snippet);
        }
    }
}