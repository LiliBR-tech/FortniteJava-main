#!/bin/bash
echo "🔧 Compilando..."
javac -cp lib/junit-platform-console-standalone-1.10.0.jar -d out src/br/com/FortniteJava/JogoAvancado.java src/br/com/FortniteJavaTests/TesteJogo.java

echo "🚀 Executando testes..."
java -jar lib/junit-platform-console-standalone-1.10.0.jar --classpath out --scan-classpath
