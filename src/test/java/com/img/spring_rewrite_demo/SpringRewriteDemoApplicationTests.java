package com.img.spring_rewrite_demo;

import org.junit.jupiter.api.Test;
import org.openrewrite.java.JavaParser;
import org.openrewrite.test.RecipeSpec;
import org.openrewrite.test.RewriteTest;

import static org.openrewrite.java.Assertions.java;

class SpringRewriteDemoApplicationTests implements RewriteTest {

    @Override
    public void defaults(RecipeSpec spec) {
        spec.recipe(new RecipeForRestTemplateToWebClient())
                .parser(JavaParser.fromJavaVersion().
                        logCompilationWarningsAndErrors(true));
    }

    @Test
    void addsHelloToFooBar() {
        // language=java
        rewriteRun(
                java(
                        """
                                    package com.imag;
                                
                                    class Hello {
                                    }
                                """,
                        """
                                    package com.imag;
                                
                                    class Hello {
                                        public String hello() {
                                            return "Hello World";
                                        }
                                    }
                                """
                )
        );
    }

    @Test
    void doesNotChangeExistingHello() {
        rewriteRun(
                // language=java
                java(
                        """
                                    package com.imag;
                                
                                    class FooBar {
                                        public String hello() { return ""; }
                                    }
                                """
                )
        );
    }
}
