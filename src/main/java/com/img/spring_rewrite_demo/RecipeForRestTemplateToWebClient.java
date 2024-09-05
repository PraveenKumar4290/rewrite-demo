package com.img.spring_rewrite_demo;

import lombok.EqualsAndHashCode;
import lombok.Value;
import org.openrewrite.Cursor;
import org.openrewrite.ExecutionContext;
import org.openrewrite.Recipe;
import org.openrewrite.TreeVisitor;
import org.openrewrite.java.JavaIsoVisitor;
import org.openrewrite.java.JavaTemplate;
import org.openrewrite.java.tree.J;

@Value
@EqualsAndHashCode(callSuper = false)
public class RecipeForRestTemplateToWebClient extends Recipe {

    @Override
    public String getDisplayName() {
        return "Hello world ! Here Custom Recipe";
    }

    @Override
    public String getDescription() {
        return "adding a Hello method to a class.";
    }

    @Override
    public TreeVisitor<?, ExecutionContext> getVisitor() {
        return new JavaIsoVisitor<>() {
            private final JavaTemplate helloTemplate =
                    JavaTemplate.builder("public String hello() { return \"Hello World\"; }")
                            .build();

            @Override
            public J.ClassDeclaration visitClassDeclaration(J.ClassDeclaration classDecl, ExecutionContext executionContext) {

                boolean helloMethodExists = classDecl.getBody().getStatements().stream()
                        .filter(statement -> statement instanceof J.MethodDeclaration)
                        .map(J.MethodDeclaration.class::cast)
                        .anyMatch(methodDeclaration -> methodDeclaration.getName().getSimpleName().equals("hello"));

                if (helloMethodExists) {
                    return classDecl;
                }
                classDecl = classDecl.withBody(helloTemplate.apply(new Cursor(getCursor(), classDecl.getBody()),
                        classDecl.getBody().getCoordinates().lastStatement()));

                return classDecl;
            }
        };
    }
}
