# Модификация Java UI для удовлетворения требований проекта OpenJDK CRaC

## Запустить тест UI приложения

Запускать из корня проекта **cracui**.

```
./jdk/bin/java -XX:+UnlockDiagnosticVMOptions -XX:+CRAllowToSkipCheckpoint -XX:CRaCCheckpointTo=./checkpoints -Djdk.crac.debug=true ./cracui/UIApp.java 1000 1000 1 1
```

## Отладка

Снифферы для протокола **x window**:

* **xscope**:
  * [gitlab](https://gitlab.freedesktop.org/xorg/app/xscope)
  * [man](https://www.x.org/releases/X11R7.5/doc/man/man1/xscope.1.html)
  * [details](http://jklp.org/profession/papers/xscope/paper.html)
  * После запуска **xscope** необходимо перенаправить запросы от **client** к нему, которые затем будут проксированы **x server**:

```
DISPLAY=:1 ./jdk/bin/java -XX:+UnlockDiagnosticVMOptions -XX:+CRAllowToSkipCheckpoint -XX:CRaCCheckpointTo=./checkpoints -Djdk.crac.debug=true ./cracui/UIApp.java 1000 1000 1 1`
```

* xtruss: https://www.chiark.greenend.org.uk/~sgtatham/xtruss/
* xmon
* xtrace


