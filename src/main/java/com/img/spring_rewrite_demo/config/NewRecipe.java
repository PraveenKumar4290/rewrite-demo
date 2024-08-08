package com.img.spring_rewrite_demo.config;

import com.img.spring_rewrite_demo.model.GenerativeCodeEditor;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.openrewrite.ExecutionContext;
import org.openrewrite.Recipe;
import org.openrewrite.java.JavaVisitor;
import org.openrewrite.java.tree.J;

@Value
@EqualsAndHashCode(callSuper = false)
public class NewRecipe extends Recipe {
    @Override
    public String getDisplayName() {
        return "Hello rewrite";
    }

    @Override
    public String getDescription() {
        return "Description.";
    }

    @Override
    public JavaVisitor<ExecutionContext> getVisitor() {
        return new JavaVisitor<ExecutionContext>() {
            @Override
            public J visitMethodDeclaration(J.MethodDeclaration method, ExecutionContext ctx) {
                if (method.getSimpleName().equals("demo")) {
                    return method.withName(method.getName().withSimpleName("demoTest"));
                }
                return super.visitMethodDeclaration(method, ctx);
            }
        };
    }

}
