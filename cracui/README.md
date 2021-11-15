# Модификация Java UI для удовлетворения требований проекта OpenJDK CRaC

## Запустить тест UI приложения

Запускать из корня проекта **cracui**.

```
./jdk/bin/java -XX:+UnlockDiagnosticVMOptions -XX:+CRAllowToSkipCheckpoint -XX:CRaCCheckpointTo=./checkpoints -Djdk.crac.debug=true ./cracui/UIApp.java 1000 1000 1 1
```

## Отладка

### Снифферы для протокола **X11**

* **xscope**:
    * [gitlab](https://gitlab.freedesktop.org/xorg/app/xscope)
    * [man](https://www.x.org/releases/X11R7.5/doc/man/man1/xscope.1.html)
    * [details](http://jklp.org/profession/papers/xscope/paper.html)
    * После запуска **xscope** необходимо перенаправить запросы от **X client** к нему, которые затем будут
      проксированы **X server**:

```
DISPLAY=:1 ./jdk/bin/java -XX:+UnlockDiagnosticVMOptions -XX:+CRAllowToSkipCheckpoint -XX:CRaCCheckpointTo=./checkpoints -Djdk.crac.debug=true ./cracui/UIApp.java 1000 1000 1 1
```

* xtruss: https://www.chiark.greenend.org.uk/~sgtatham/xtruss/
* xmon
* xtrace

### Xlib & Java Native Interface (JNI)

Для этого необходимо получить реализацию **Xlib** и собрать, модифицировав для отладки при необходимости.

* **Xlib**:
    * [github](https://github.com/mirror/libX11)

Затем необхидимо указать динамическому линкеру, что необходимо загружать полученные после сборки файлы библиотеки в
замен системным через переменную окружения:

```
LD_LIBRARY_PATH=[/path/to/library]/libX11/src/.libs ./jdk/bin/java -XX:+UnlockDiagnosticVMOptions -XX:+CRAllowToSkipCheckpoint -XX:CRaCCheckpointTo=./checkpoints -Djdk.crac.debug=true ./cracui/UIApp.java 1000 1000 1 1
```

Для непосредственной отладки можно использовать простой и эффективный **GDB**.
Для его запуска совместно с **xscope** и отладочной версией **Xlib** можно попробовать:

```
LD_LIBRARY_PATH=[/path/to/library]/libX11/src/.libs DISPLAY=:1 gdb -args ./jdk/bin/java -XX:+UnlockDiagnosticVMOptions -XX:+CRAllowToSkipCheckpoint -XX:CRaCCheckpointTo=./checkpoints -Djdk.crac.debug=true ./cracui/UIApp.java 1000 1000 1 1
```
