package com.img.spring_rewrite_demo;

import com.img.spring_rewrite_demo.config.NewRecipe;
import org.junit.jupiter.api.Test;
import org.openrewrite.java.JavaParser;
import org.openrewrite.test.RecipeSpec;
import org.openrewrite.test.RewriteTest;

import static org.openrewrite.java.Assertions.java;

class SpringRewriteDemoApplicationTests implements RewriteTest {

    @Override
    public void defaults(RecipeSpec spec) {
//        try (InputStream token = requireNonNull(getClass().getResourceAsStream("eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Ik1UaEVOVUpHTkVNMVFURTRNMEZCTWpkQ05UZzVNRFUxUlRVd1FVSkRNRU13UmtGRVFrRXpSZyJ9.eyJwd2RfYXV0aF90aW1lIjoxNzIzMDk5MzQ4Mzk1LCJzZXNzaW9uX2lkIjoiekJYZGVzYVM4MnhHV2haaExiY2RDUVBqazNQQmlYN1AiLCJodHRwczovL2FwaS5vcGVuYWkuY29tL3Byb2ZpbGUiOnsiZW1haWwiOiJwcmF2ZWVubmFkaWdhdGxhQGdtYWlsLmNvbSIsImVtYWlsX3ZlcmlmaWVkIjp0cnVlfSwiaHR0cHM6Ly9hcGkub3BlbmFpLmNvbS9hdXRoIjp7InBvaWQiOiJvcmcteG5zVXpEOGpQTjE2YXFJYjI5bHlvM0JrIiwidXNlcl9pZCI6InVzZXItVmdOanh4dk9hOFVXeXo0RkcxcVMyUlUzIn0sImlzcyI6Imh0dHBzOi8vYXV0aDAub3BlbmFpLmNvbS8iLCJzdWIiOiJnb29nbGUtb2F1dGgyfDExMjc5OTg3NTY5MjA0NjkwNDUzOSIsImF1ZCI6WyJodHRwczovL2FwaS5vcGVuYWkuY29tL3YxIiwiaHR0cHM6Ly9vcGVuYWkub3BlbmFpLmF1dGgwYXBwLmNvbS91c2VyaW5mbyJdLCJpYXQiOjE3MjMwOTkzNDksImV4cCI6MTcyMzk2MzM0OSwic2NvcGUiOiJvcGVuaWQgcHJvZmlsZSBlbWFpbCBtb2RlbC5yZWFkIG1vZGVsLnJlcXVlc3Qgb3JnYW5pemF0aW9uLnJlYWQgb3JnYW5pemF0aW9uLndyaXRlIG9mZmxpbmVfYWNjZXNzIiwiYXpwIjoiVGRKSWNiZTE2V29USHROOTVueXl3aDVFNHlPbzZJdEcifQ.W_3fCU5qd4OtAm6pX9J4iH5qH_5lXWMqOfeBLfCFQJWWpjUNmrHvM1-R9AJrYeSnHdS9y4kwn5Yq_mdKrLmd9csYJ87mVRW-ND6M7UeSZ05FMuy4G4hZr2Mmgptv_QyLR9rCuujyzubwPx1TbuVWDOzoQEhlQgl1RLXlnO04drXE10FrUp36cQisuScWOrMuznVYjAbkEUUqdW782APbv9hio0USWPe_NuafiJNJycBQ1opieePuLY4-oAtSaCxwNZaN1fsB-G_DhEWL4c9HQC3ZNYz2LtUp_KD9p4hUt7eb7_HvP6rtTBnsgQtwxTOeWnRLTMHuwD2yk0UK_AQoHQ"))) {
//            ExecutionContext ctx = GenerativeCodeExecutionContextView.view(new InMemoryExecutionContext())
//                    .setOpenApiToken(new String(token.readAllBytes()).trim());
//            ctx = HttpSenderExecutionContextView.view(ctx).setHttpSender(new HttpUrlConnectionSender(
//                    Duration.ofSeconds(10), Duration.ofSeconds(30)));
//
//            spec.recipe(new NewRecipe())
//                    .cycles(1)
//                    .expectedCyclesThatMakeChanges(1)
//                    .executionContext(ctx);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        spec.recipe(new NewRecipe())
                .parser(JavaParser.fromJavaVersion().logCompilationWarningsAndErrors(true));
    }

    @Test
    void edit() {
        rewriteRun(

                java(
                        """
                                class TestClass { 
                                    void demo() {
                                        int a=10;
                                        System.out.println(a);
                                    } 
                                }
                                """,
                        """
                                class TestClass { 
                                    void demoTest() {
                                        int a=10;
                                        System.out.println(a);
                                    } 
                                }
                                """
                )
        );
    }
}
