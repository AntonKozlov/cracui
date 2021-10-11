# Модификация Java UI для удовлетворения требований проекта OpenJDK CRaC

## Запустить тест UI приложения

Запускать из корня проекта **cracui**.

```
./jdk/bin/java -XX:+UnlockDiagnosticVMOptions -XX:+CRAllowToSkipCheckpoint -XX:CRaCCheckpointTo=./checkpoints -Djdk.crac.debug=true ./cracui/UIApp.java 1000 1000 1 1
```

## Отладка

Снифферы для протокола X11:
* xcope: https://www.x.org/releases/X11R7.5/doc/man/man1/xscope.1.html
* xtruss: https://www.chiark.greenend.org.uk/~sgtatham/xtruss/
* xmon
* xtrace


