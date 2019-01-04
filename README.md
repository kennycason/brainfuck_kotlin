# Brain Fuck - Kotlin

```kotlin
val evaluator = BrainFuckEvaluator()
val context = evaluator.evaluate(load("helloworld.bf"))
assertEquals("Hello World!\n", context.stdOut.toString())
```


helloworld.bf
```
+++++ +++++
[
    > +++++ ++
    > +++++ +++++
    > +++
    > +

    <<<< -
]
> ++ .
> + .
+++++ ++ .
.
+++ .
> ++ .
<< +++++ +++++ +++++ .
> .
+++ .
----- - .
----- --- .
> + .
> .
```